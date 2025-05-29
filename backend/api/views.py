from rest_framework.decorators import api_view
from rest_framework.response import Response
from .models import Equipment, Task
from .serializers import EquipmentSerializer, TaskSerializer
import requests
from datetime import datetime

import uuid


CLOUD_SYNC_URL = "https://cloud.example.com/api/sync"  # Replace with URL



@api_view(['POST'])
def sync_assets_and_tasks(request):
    try:
        last_sync_time = int(request.data.get('lastSyncTimeStamp', 0))
    except (TypeError, ValueError):
        return Response({"error": "Invalid or missing lastSyncTimeStamp"}, status=400)

    updated_assets = Equipment.objects.filter(synctime__gt=last_sync_time)
    updated_tasks = Task.objects.filter(synctime__gt=last_sync_time)

    asset_serializer = EquipmentSerializer(updated_assets, many=True)
    task_serializer = TaskSerializer(updated_tasks, many=True)

    return Response({
        "assets": asset_serializer.data,
        "tasks": task_serializer.data
    }, status=200)

@api_view(['GET'])
def fetch_assets_and_tasks(request):
    assets = Equipment.objects.all()
    tasks = Task.objects.all()
    asset_serializer = EquipmentSerializer(assets, many=True)
    task_serializer = TaskSerializer(tasks, many=True)

    return Response({
        "assets": asset_serializer.data,
        "tasks": task_serializer.data
    }, status=200)


@api_view(['POST'])
def push_to_cloud_view(request):
    assets = Equipment.objects.all()
    tasks = Task.objects.all()

    asset_data = EquipmentSerializer(assets, many=True).data
    task_data = TaskSerializer(tasks, many=True).data

    payload = {
        "assets": asset_data,
        "tasks": task_data
    }

    try:
        res = requests.post(CLOUD_SYNC_URL, json=payload, timeout=10)
        return Response({
            "status_code": res.status_code,
            "response": res.json() if res.headers.get('content-type') == 'application/json' else res.text
        }, status=res.status_code)
    except requests.RequestException as e:
        return Response({"error": str(e)}, status=500)

@api_view(['POST'])
def update_master(request):
    updated_assets = []
    updated_tasks = []

    # --- ASSETS ---
    for asset in request.data.get('assets', []):
        sync_id = asset.get('syncId')
        uid = asset.get('uid')
        incoming_time = asset.get('synctime')

        # Ensure UID is string and parseable UUID or generate if missing
        if not uid:
            uid = str(uuid.uuid4())
            asset['uid'] = uid

        try:
            uid_obj = uuid.UUID(uid)
        except ValueError:
            # Invalid UID format, generate new UID and save that
            uid = str(uuid.uuid4())
            uid_obj = uuid.UUID(uid)
            asset['uid'] = uid

        if not sync_id:
            # CASE 1: New record
            serializer = EquipmentSerializer(data=asset)
            if serializer.is_valid():
                serializer.save()
                asset['syncId'] = 1
                asset['synctime'] = None
                updated_assets.append(asset)
            else:
                print("❌ Asset create error:", serializer.errors)
        else:
            # CASE 2: Update if newer, else create if not found
            try:
                db_asset = Equipment.objects.get(uid=uid_obj)
                if incoming_time and db_asset.synctime and int(incoming_time) > int(db_asset.synctime):
                    serializer = EquipmentSerializer(db_asset, data=asset)
                    if serializer.is_valid():
                        serializer.save()
                asset['synctime'] = None
                updated_assets.append(asset)
            except Equipment.DoesNotExist:
                # Create new asset with this UID
                serializer = EquipmentSerializer(data=asset)
                if serializer.is_valid():
                    serializer.save()
                    asset['syncId'] = 1
                    asset['synctime'] = None
                    updated_assets.append(asset)
                else:
                    print("❌ Asset create error on missing UID:", serializer.errors)

    # --- TASKS ---
    for task in request.data.get('tasks', []):
        sync_id = task.get('syncId')
        uid = task.get('uid')
        incoming_time = task.get('synctime')

        if not uid:
            uid = str(uuid.uuid4())
            task['uid'] = uid

        try:
            uid_obj = uuid.UUID(uid)
        except ValueError:
            uid = str(uuid.uuid4())
            uid_obj = uuid.UUID(uid)
            task['uid'] = uid

        if not sync_id:
            # CASE 1: New record
            serializer = TaskSerializer(data=task)
            if serializer.is_valid():
                serializer.save()
                task['syncId'] = 1
                task['synctime'] = None
                updated_tasks.append(task)
            else:
                print("❌ Task create error:", serializer.errors)
        else:
            # CASE 2: Update if newer, else create if not found
            try:
                db_task = Task.objects.get(uid=uid_obj)
                if incoming_time and db_task.synctime and int(incoming_time) > int(db_task.synctime):
                    serializer = TaskSerializer(db_task, data=task)
                    if serializer.is_valid():
                        serializer.save()
                task['synctime'] = None
                updated_tasks.append(task)
            except Task.DoesNotExist:
                serializer = TaskSerializer(data=task)
                if serializer.is_valid():
                    serializer.save()
                    task['syncId'] = 1
                    task['synctime'] = None
                    updated_tasks.append(task)
                else:
                    print("❌ Task create error on missing UID:", serializer.errors)

    return Response({
        "assets": updated_assets,
        "tasks": updated_tasks
    }, status=200)