package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\"\u0010\r\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u00020\u00032\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u000e\"\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\"\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u000e\"\u00020\u0016H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\u00020\u00032\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u000e\"\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\"\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u000e\"\u00020\u001eH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006!"}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "", "deleteAsset", "", "asset", "Lcom/example/agdesk/DataLayer/entities/Asset/Asset;", "(Lcom/example/agdesk/DataLayer/entities/Asset/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "Lcom/example/agdesk/models/AssetModel;", "getAllLargeEquipment", "getAllSmallEquipment", "getAllVehicles", "insertAsset", "", "([Lcom/example/agdesk/DataLayer/entities/Asset/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLargeEquipment", "largeEquipment", "Lcom/example/agdesk/DataLayer/entities/Asset/LargeEquipment;", "([Lcom/example/agdesk/DataLayer/entities/Asset/LargeEquipment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSmallEquipment", "smallEquipment", "Lcom/example/agdesk/DataLayer/entities/Asset/SmallEquipment;", "([Lcom/example/agdesk/DataLayer/entities/Asset/SmallEquipment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSync", "sync", "Lcom/example/agdesk/DataLayer/entities/sync/AssetSync;", "([Lcom/example/agdesk/DataLayer/entities/sync/AssetSync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertVehicle", "vehicle", "Lcom/example/agdesk/DataLayer/entities/Asset/Vehicle;", "([Lcom/example/agdesk/DataLayer/entities/Asset/Vehicle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAsset", "app_debug"})
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
    com.example.agdesk.DataLayer.entities.Asset.Asset[] asset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSync(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.sync.AssetSync[] sync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertVehicle(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset.Vehicle[] vehicle, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSmallEquipment(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset.SmallEquipment[] smallEquipment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLargeEquipment(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset.LargeEquipment[] largeEquipment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset.Asset asset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset.Asset asset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}