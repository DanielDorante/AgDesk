from rest_framework.decorators import api_view
from rest_framework.response import Response
from .models import Equipment, Task
from .serializers import EquipmentSerializer, TaskSerializer
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
