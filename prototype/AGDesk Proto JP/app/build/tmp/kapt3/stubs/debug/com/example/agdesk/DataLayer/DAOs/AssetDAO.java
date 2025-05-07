package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\'J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\'J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\'J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\'J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0010H\'J\"\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001d\"\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u00032\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\u001d\"\u00020!H\u00a7@\u00a2\u0006\u0002\u0010\"J\"\u0010#\u001a\u00020\u00032\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0\u001d\"\u00020%H\u00a7@\u00a2\u0006\u0002\u0010&J\"\u0010\'\u001a\u00020\u00032\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0\u001d\"\u00020)H\u00a7@\u00a2\u0006\u0002\u0010*J\"\u0010+\u001a\u00020\u00032\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0\u001d\"\u00020-H\u00a7@\u00a2\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u00060"}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "", "deleteAsset", "", "asset", "Lcom/example/agdesk/DataLayer/entities/Asset/Asset;", "(Lcom/example/agdesk/DataLayer/entities/Asset/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSync", "delUid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveOperationsByUUid", "", "Lcom/example/agdesk/DataLayer/entities/Asset/Operations;", "uid", "getAll", "", "Lcom/example/agdesk/models/UIModels/AssetModel;", "getAllLargeEquipment", "getAllSmallEquipment", "getAllVehicles", "getBySyncId", "syncId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByUid", "getOfflineAssets", "Lcom/example/agdesk/models/networkModels/dataModels/AssetNetworkModel;", "insertAsset", "", "([Lcom/example/agdesk/DataLayer/entities/Asset/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLargeEquipment", "largeEquipment", "Lcom/example/agdesk/DataLayer/entities/Asset/LargeEquipment;", "([Lcom/example/agdesk/DataLayer/entities/Asset/LargeEquipment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSmallEquipment", "smallEquipment", "Lcom/example/agdesk/DataLayer/entities/Asset/SmallEquipment;", "([Lcom/example/agdesk/DataLayer/entities/Asset/SmallEquipment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSync", "sync", "Lcom/example/agdesk/DataLayer/entities/sync/AssetSync;", "([Lcom/example/agdesk/DataLayer/entities/sync/AssetSync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertVehicle", "vehicle", "Lcom/example/agdesk/DataLayer/entities/Asset/Vehicle;", "([Lcom/example/agdesk/DataLayer/entities/Asset/Vehicle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAsset", "app_debug"})
@androidx.room.Dao()
public abstract interface AssetDAO {
    
    @androidx.room.Query(value = "SELECT * FROM Asset")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.UIModels.AssetModel> getAll();
    
    @androidx.room.Query(value = "\n    SELECT \n        asset_sync.uid AS uid,\n        Asset.asset_Prefix,\n        Asset.asset_Name,\n        Asset.manufacture,\n        Asset.part_List,\n        Asset.location,\n        Asset.date_Manufactured,\n        Asset.date_Purchased,\n        Asset.asset_Image,\n        Asset.farm_Id,\n        Asset.global_Id,\n        asset_sync.synctimestamp,\n        Large_Equipment.vin AS largeEquipmentVin,  -- Alias for the vin from Large_Equipment\n        small_Equipment.serial_Number,\n        Vehicles.vin AS vehicleVin,  -- Alias for the vin from Vehicles\n        Vehicles.registration\n    FROM ASSET_SYNC \n    INNER JOIN Asset ON asset_sync.uid = Asset.uid\n    LEFT JOIN Large_Equipment ON asset_sync.uid = Large_Equipment.uid\n    LEFT JOIN small_Equipment ON asset_sync.uid = small_Equipment.uid\n    LEFT JOIN Vehicles ON asset_sync.uid = Vehicles.uid\n")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel> getOfflineAssets();
    
    @androidx.room.Query(value = "SELECT * FROM Asset WHERE global_Id = :syncId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBySyncId(long syncId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.agdesk.DataLayer.entities.Asset.Asset> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Asset WHERE uid = :uid LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByUid(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.agdesk.DataLayer.entities.Asset.Asset> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Asset INNER JOIN Large_Equipment ON Asset.uid = Large_Equipment.uid;")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.UIModels.AssetModel> getAllLargeEquipment();
    
    @androidx.room.Query(value = "SELECT * FROM Asset INNER JOIN small_Equipment ON Asset.uid = small_Equipment.uid;")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.UIModels.AssetModel> getAllSmallEquipment();
    
    @androidx.room.Query(value = "SELECT * FROM Asset INNER JOIN Vehicles ON Asset.uid = Vehicles.uid;")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.models.UIModels.AssetModel> getAllVehicles();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset.Asset[] asset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSync(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.sync.AssetSync[] sync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM ASSET_SYNC WHERE uid = :delUid")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSync(@org.jetbrains.annotations.NotNull()
    java.lang.String delUid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertVehicle(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset.Vehicle[] vehicle, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSmallEquipment(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Asset.SmallEquipment[] smallEquipment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
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
    
    @androidx.room.Query(value = "SELECT * FROM Operations WHERE Asset_Id = :uid AND End_Date_Time IS NULL")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActiveOperationsByUUid(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.DataLayer.entities.Asset.Operations>> $completion);
}