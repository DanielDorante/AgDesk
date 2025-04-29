package com.example.agdesk.ViewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/example/agdesk/ViewModels/InventoryViewModel;", "Landroidx/lifecycle/ViewModel;", "inventoryRepository", "Lcom/example/agdesk/repository/InventoryRepository;", "(Lcom/example/agdesk/repository/InventoryRepository;)V", "_items", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/agdesk/models/InventoryModel;", "items", "Lkotlinx/coroutines/flow/StateFlow;", "getItems", "()Lkotlinx/coroutines/flow/StateFlow;", "insertItems", "Lkotlinx/coroutines/Job;", "inventoryModel", "loadItems", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class InventoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.repository.InventoryRepository inventoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.agdesk.models.InventoryModel>> _items = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.agdesk.models.InventoryModel>> items = null;
    
    @javax.inject.Inject()
    public InventoryViewModel(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.repository.InventoryRepository inventoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.agdesk.models.InventoryModel>> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertItems(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.InventoryModel inventoryModel) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadItems() {
        return null;
    }
}