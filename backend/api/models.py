from django.db import models
import uuid

class Equipment(models.Model):
    uid = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False, unique=True)
    assetPrefix = models.CharField(max_length=10, null=True, blank=True)
    name = models.CharField(max_length=100, null=True, blank=True)
    manufac = models.CharField(max_length=100, null=True, blank=True)
    parts = models.TextField(null=True, blank=True)
    location = models.CharField(max_length=100, null=True, blank=True)
    dateMade = models.BigIntegerField(null=True, blank=True)
    dateBuy = models.BigIntegerField(null=True, blank=True)
    image = models.CharField(max_length=255, null=True, blank=True)
    farmId = models.IntegerField(null=True, blank=True)  # will become FK later
    largeEquipmentVin = models.CharField(max_length=100, null=True, blank=True)
    vehicleVin = models.CharField(max_length=100, null=True, blank=True)
    serialNo = models.CharField(max_length=100, null=True, blank=True)
    reg = models.CharField(max_length=100, null=True, blank=True)
    syncId = models.CharField(max_length=100, null=True, blank=True)
    synctime = models.IntegerField(null=True, blank=True)

class Task(models.Model):
    uid = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    name = models.CharField(max_length=100, null=True, blank=True)
    desc = models.TextField(null=True, blank=True)
    timestamp = models.BigIntegerField(null=True, blank=True)
    del_field = models.BooleanField(default=False, null=True, blank=True)
    due = models.BigIntegerField(null=True, blank=True)
    exp = models.BigIntegerField(null=True, blank=True)
    status = models.IntegerField(null=True, blank=True)
    priority = models.IntegerField(null=True, blank=True)
    assignedId = models.CharField(max_length=100, null=True, blank=True)
    assigned = models.CharField(max_length=100, null=True, blank=True)
    farm = models.IntegerField(null=True, blank=True)
    syncId = models.CharField(max_length=255, null=True, blank=True)
    synctime = models.BigIntegerField(null=True, blank=True)

    def __str__(self):
        return self.name if self.name else str(self.uid)