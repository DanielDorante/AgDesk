package com.example.agdesk.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\f\"\u00020\u0007H\u0087@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/agdesk/repository/FieldRepository;", "", "fieldDAO", "Lcom/example/agdesk/DataLayer/DAOs/FieldDAO;", "(Lcom/example/agdesk/DataLayer/DAOs/FieldDAO;)V", "getAllFields", "", "Lcom/example/agdesk/models/FieldsModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFields", "", "fieldsModel", "", "([Lcom/example/agdesk/models/FieldsModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class FieldRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DataLayer.DAOs.FieldDAO fieldDAO = null;
    
    @javax.inject.Inject()
    public FieldRepository(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.DAOs.FieldDAO fieldDAO) {
        super();
    }
    
    @androidx.annotation.WorkerThread()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertFields(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.FieldsModel[] fieldsModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllFields(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.FieldsModel>> $completion) {
        return null;
    }
}