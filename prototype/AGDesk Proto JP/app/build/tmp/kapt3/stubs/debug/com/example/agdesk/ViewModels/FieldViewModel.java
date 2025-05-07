package com.example.agdesk.ViewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\r\u001a\u00020\u000e2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000f\"\u00020\b\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/agdesk/ViewModels/FieldViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/agdesk/DomainLayer/repository/FieldRepository;", "(Lcom/example/agdesk/DomainLayer/repository/FieldRepository;)V", "_fields", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/agdesk/models/UIModels/FieldsModel;", "fields", "Lkotlinx/coroutines/flow/StateFlow;", "getFields", "()Lkotlinx/coroutines/flow/StateFlow;", "insertFields", "Lkotlinx/coroutines/Job;", "", "([Lcom/example/agdesk/models/UIModels/FieldsModel;)Lkotlinx/coroutines/Job;", "loadFields", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FieldViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DomainLayer.repository.FieldRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.agdesk.models.UIModels.FieldsModel>> _fields = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.agdesk.models.UIModels.FieldsModel>> fields = null;
    
    @javax.inject.Inject()
    public FieldViewModel(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DomainLayer.repository.FieldRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.agdesk.models.UIModels.FieldsModel>> getFields() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertFields(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UIModels.FieldsModel... fields) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadFields() {
        return null;
    }
}