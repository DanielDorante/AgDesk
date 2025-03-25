package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\"\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\u00020\t2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b\"\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u000b\"\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u00020\t2\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u000b\"\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\u00020\t2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u000b\"\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u001f\u00a8\u0006 "}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "", "getAll", "", "Lcom/example/agdesk/models/AssetModel;", "getAllLargeEquipment", "getAllSmallEquipment", "getAllVehicles", "insertAsset", "", "asset", "", "Lcom/example/agdesk/DataLayer/entities/Asset;", "([Lcom/example/agdesk/DataLayer/entities/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLargeEquipment", "largeEquipment", "Lcom/example/agdesk/DataLayer/entities/LargeEquipment;", "([Lcom/example/agdesk/DataLayer/entities/LargeEquipment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSmallEquipment", "smallEquipment", "Lcom/example/agdesk/DataLayer/entities/SmallEquipment;", "([Lcom/example/agdesk/DataLayer/entities/SmallEquipment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSync", "sync", "Lcom/example/agdesk/DataLayer/entities/sync/AssetSync;", "([Lcom/example/agdesk/DataLayer/entities/sync/AssetSync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertVehicle", "vehicle", "Lcom/example/agdesk/DataLayer/entities/Vehicle;", "([Lcom/example/agdesk/DataLayer/entities/Vehicle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAsset", "(Lcom/example/agdesk/DataLayer/entities/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface AssetDAO {
    
    @androidx.room.Query(value = "SELECT * FROM Asset")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.AssetModel> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM Asset INNER JOIN Large_Equipment ON Asset.uid = Large_Equipment.uid;")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.AssetModel> getAllLargeEquipment();
    
    @androidx.room.Query(value = "SELECT * FROM Asset INNER JOIN small_Equipment ON Asset.uid = small_Equipment.uid;")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.AssetModel> getAllSmallEquipment();
    
    @androidx.room.Query(value = "SELECT * FROM Asset INNER JOIN Vehicles ON Asset.uid = Vehicles.uid;")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.AssetModel> getAllVehicles();
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset[] asset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSync(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.sync.AssetSync[] sync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertVehicle(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Vehicle[] vehicle, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSmallEquipment(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.SmallEquipment[] smallEquipment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLargeEquipment(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.LargeEquipment[] largeEquipment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset asset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}