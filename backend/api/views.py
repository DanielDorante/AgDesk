from rest_framework.decorators import api_view
from rest_framework.response import Response
from .models import Equipment, Task
from .serializers import EquipmentSerializer, TaskSerializer
import requests
from datetime import datetime

CLOUD_SYNC_URL = "https://cloud.example.com/api/sync"  # Replace with URL


@api_view(['POST'])
def sync_assets_and_tasks(request):
    assets = request.data.get('assets', [])
    tasks = request.data.get('tasks', [])

    print(" Incoming Assets:", assets)
    print(" Incoming Tasks:", tasks)

    asset_serializer = EquipmentSerializer(data=assets, many=True)
    task_serializer = TaskSerializer(data=tasks, many=True)

    print("✅ Asset Valid?", asset_serializer.is_valid())
    print("✅ Task Valid?", task_serializer.is_valid())
    print("❌ Asset Errors:", asset_serializer.errors)
    print("❌ Task Errors:", task_serializer.errors)

    if asset_serializer.is_valid() and task_serializer.is_valid():
        asset_serializer.save()
        task_serializer.save()
        return Response({"message": "Assets and Tasks synced successfully."}, status=201)

    return Response({
        "asset_errors": asset_serializer.errors,
        "task_errors": task_serializer.errors
    }, status=400)


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


# NEW: UpdateMaster endpoint (syncId + timestamp logic)
@api_view(['POST'])
def update_master(request):
    updated_assets = []
    updated_tasks = []

    for asset in request.data.get('assets', []):
        sync_id = asset.get('syncId')
        incoming_time = asset.get('synctime')

        if not sync_id:
            serializer = EquipmentSerializer(data=asset)
            if serializer.is_valid():
                saved = serializer.save()
                asset['syncId'] = saved.id
                updated_assets.append(asset)
        else:
            try:
                db_asset = Equipment.objects.get(id=sync_id)
                if incoming_time and db_asset.synctime and int(incoming_time) > int(db_asset.synctime.timestamp() * 1000):
                    serializer = EquipmentSerializer(db_asset, data=asset)
                    if serializer.is_valid():
                        serializer.save()
                updated_assets.append(asset)
            except Equipment.DoesNotExist:
                pass

    for task in request.data.get('tasks', []):
        sync_id = task.get('syncid')
        incoming_time = task.get('timestamp')

        if not sync_id:
            serializer = TaskSerializer(data=task)
            if serializer.is_valid():
                saved = serializer.save()
                task['syncid'] = str(saved.uid)
                updated_tasks.append(task)
        else:
            try:
                db_task = Task.objects.get(id=sync_id)
                if incoming_time and db_task.timestamp and int(incoming_time) > int(db_task.timestamp):
                    serializer = TaskSerializer(db_task, data=task)
                    if serializer.is_valid():
                        serializer.save()
                updated_tasks.append(task)
            except Task.DoesNotExist:
                pass

    return Response({
        "assets": updated_assets,
        "tasks": updated_tasks
    }, status=200)
