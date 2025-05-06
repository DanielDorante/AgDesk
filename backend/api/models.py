from django.db import models
import uuid

class Equipment(models.Model):
    uid = models.UUIDField(default=uuid.uuid4, editable=False, unique=True)
    assetPrefix = models.CharField(max_length=10)
    name = models.CharField(max_length=100)
    manufac = models.CharField(max_length=100)
    parts = models.TextField()
    location = models.CharField(max_length=100)
    dateMade = models.DateTimeField(null=True)
    dateBuy = models.DateTimeField(null=True)
    image = models.CharField(max_length=255)
    farmId = models.IntegerField()  # change to FK later when making a fram model
    largeEquipmentVin = models.CharField(max_length=100, null=True, blank=True)
    vehicleVin = models.CharField(max_length=100, null=True, blank=True)
    serialNo = models.CharField(max_length=100, null=True, blank=True)
    reg = models.CharField(max_length=100, null=True, blank=True)
    syncId = models.CharField(max_length=100, null=True, blank=True)
    synctime = models.DateTimeField(null=True)

class Task(models.Model):
    uid = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    name = models.CharField(max_length=100)
    desc = models.TextField()
    timestamp = models.BigIntegerField()
    del_field = models.BooleanField(default=False)
    due = models.BigIntegerField()
    exp = models.BigIntegerField()
    status = models.IntegerField()
    priority = models.IntegerField()
    assignedId = models.CharField(max_length=100, null=True, blank=True)
    assigned = models.CharField(max_length=100, null=True, blank=True)
    farm = models.IntegerField()
    syncid = models.CharField(max_length=255, null=True, blank=True)

def __str__(self):
    return self.name
