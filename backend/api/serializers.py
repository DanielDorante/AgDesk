from rest_framework import serializers
from .models import Equipment, Task


class EquipmentSerializer(serializers.ModelSerializer):
    synctime = serializers.IntegerField(allow_null=True, required=False)

    class Meta:
        model = Equipment
        fields = '__all__'

class TaskSerializer(serializers.ModelSerializer):
    class Meta:
        model = Task
        fields = '__all__'