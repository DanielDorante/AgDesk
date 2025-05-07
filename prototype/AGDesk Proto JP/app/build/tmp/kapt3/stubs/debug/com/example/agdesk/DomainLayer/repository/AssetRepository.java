package com.example.agdesk.DomainLayer.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@\u00a2\u0006\u0002\u0010\bJ\"\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0015\"\u00020\u0007H\u0087@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0087@\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0087@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/agdesk/DomainLayer/repository/AssetRepository;", "", "assetDAO", "Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "(Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;)V", "getAllAssets", "", "Lcom/example/agdesk/models/UIModels/AssetModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLargeEquipment", "getAllSmallEquipment", "getAllVehicles", "getCheckoutStatus", "assets", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfflineAssets", "", "Lcom/example/agdesk/models/networkModels/dataModels/AssetNetworkModel;", "insertAsset", "", "assetModel", "", "([Lcom/example/agdesk/models/UIModels/AssetModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAsset", "(Lcom/example/agdesk/models/UIModels/AssetModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAssetNetwork", "assetNetworkModel", "app_debug"})
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
    com.example.agdesk.models.UIModels.AssetModel[] assetModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCheckoutStatus(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.UIModels.AssetModel> assets, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.AssetModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllAssets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.AssetModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllVehicles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.AssetModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllLargeEquipment(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.AssetModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllSmallEquipment(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.AssetModel>> $completion) {
        return null;
    }
    
    @androidx.annotation.WorkerThread()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UIModels.AssetModel assetModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @androidx.annotation.WorkerThread()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateAssetNetwork(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel> assetNetworkModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOfflineAssets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel>> $completion) {
        return null;
    }
}