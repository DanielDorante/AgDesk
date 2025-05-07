package com.example.agdesk.ViewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0010\"\u00020\b\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/example/agdesk/ViewModels/AssetViewModel;", "Landroidx/lifecycle/ViewModel;", "assetRepository", "Lcom/example/agdesk/DomainLayer/repository/AssetRepository;", "(Lcom/example/agdesk/DomainLayer/repository/AssetRepository;)V", "_assets", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/agdesk/models/UIModels/AssetModel;", "assets", "Lkotlinx/coroutines/flow/StateFlow;", "getAssets", "()Lkotlinx/coroutines/flow/StateFlow;", "insertAsssets", "Lkotlinx/coroutines/Job;", "assetModel", "", "([Lcom/example/agdesk/models/UIModels/AssetModel;)Lkotlinx/coroutines/Job;", "loadAssets", "loadLargeAssets", "loadSmallAssets", "loadVehicleAssets", "updateAsset", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AssetViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DomainLayer.repository.AssetRepository assetRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.agdesk.models.UIModels.AssetModel>> _assets = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.agdesk.models.UIModels.AssetModel>> assets = null;
    
    @javax.inject.Inject()
    public AssetViewModel(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DomainLayer.repository.AssetRepository assetRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.agdesk.models.UIModels.AssetModel>> getAssets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertAsssets(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UIModels.AssetModel... assetModel) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadAssets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadVehicleAssets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadSmallAssets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadLargeAssets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UIModels.AssetModel assetModel) {
        return null;
    }
}