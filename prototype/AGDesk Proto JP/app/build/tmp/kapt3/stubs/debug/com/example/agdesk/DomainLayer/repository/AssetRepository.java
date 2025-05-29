package com.example.agdesk.DomainLayer.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0087@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0010J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@\u00a2\u0006\u0002\u0010\u0010J\"\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0019\"\u00020\u000fH\u0087@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000fH\u0087@\u00a2\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0087@\u00a2\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001e"}, d2 = {"Lcom/example/agdesk/DomainLayer/repository/AssetRepository;", "", "assetDAO", "Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "(Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;)V", "getAssetDAO", "()Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "delAssetNetwork", "", "assetNetworkModel", "", "Lcom/example/agdesk/models/networkModels/dataModels/AssetNetworkModel;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAssets", "", "Lcom/example/agdesk/models/UIModels/AssetModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLargeEquipment", "getAllSmallEquipment", "getAllVehicles", "getCheckoutStatus", "assets", "getOfflineAssets", "insertAsset", "assetModel", "", "([Lcom/example/agdesk/models/UIModels/AssetModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAsset", "(Lcom/example/agdesk/models/UIModels/AssetModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAssetNetwork", "app_debug"})
public final class AssetRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DataLayer.DAOs.AssetDAO assetDAO = null;
    
    @javax.inject.Inject()
    public AssetRepository(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.DAOs.AssetDAO assetDAO) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.DataLayer.DAOs.AssetDAO getAssetDAO() {
        return null;
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
    
    @androidx.annotation.WorkerThread()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delAssetNetwork(@org.jetbrains.annotations.NotNull()
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