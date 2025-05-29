from rest_framework import serializers
from .models import Equipment, Task
from datetime import datetime

class EquipmentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Equipment
        fields = '__all__'

    def to_internal_value(self, data):
        for field in []:
            if field in data and data[field]:
                try:
                    data[field] = datetime.fromtimestamp(int(data[field]) / 1000)
                except (ValueError, TypeError):
                    pass  
        return super().to_internal_value(data)


class TaskSerializer(serializers.ModelSerializer):
    class Meta:
        model = Task
        fields = '__all__'

    def to_internal_value(self, data):
        for field in []:
            if field in data and data[field]:
                try:
                    data[field] = int(data[field])
                except ValueError:
                    pass  # Let validation catch it
        return super().to_internal_value(data)
