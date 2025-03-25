package com.example.agdesk.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\"\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0011\"\u00020\bH\u0087@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/agdesk/repository/AssetRepository;", "", "assetDAO", "Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "(Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;)V", "UpdateAsset", "", "assetModel", "Lcom/example/agdesk/models/AssetModel;", "(Lcom/example/agdesk/models/AssetModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAssets", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLargeEquipment", "getAllSmallEquipment", "getAllVehicles", "insertAsset", "", "([Lcom/example/agdesk/models/AssetModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AssetRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DataLayer.DAOs.AssetDAO assetDAO = null;
    
    @javax.inject.Inject()
    public AssetRepository(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.DAOs.AssetDAO assetDAO) {
        super();
    }
    
    @androidx.annotation.WorkerThread()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.AssetModel[] assetModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllAssets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.AssetModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllVehicles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.AssetModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllLargeEquipment(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.AssetModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllSmallEquipment(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.AssetModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object UpdateAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.AssetModel assetModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}