package com.example.agdesk.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\f\"\u00020\u0007H\u0087@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0087@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/agdesk/repository/TaskRepository;", "", "taskDAO", "Lcom/example/agdesk/DataLayer/DAOs/TaskDAO;", "(Lcom/example/agdesk/DataLayer/DAOs/TaskDAO;)V", "getAllTasks", "", "Lcom/example/agdesk/models/TaskModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTask", "", "taskModel", "", "([Lcom/example/agdesk/models/TaskModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "(Lcom/example/agdesk/models/TaskModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TaskRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DataLayer.DAOs.TaskDAO taskDAO = null;
    
    @javax.inject.Inject()
    public TaskRepository(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.DAOs.TaskDAO taskDAO) {
        super();
    }
    
    @androidx.annotation.WorkerThread()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertTask(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.TaskModel[] taskModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllTasks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.TaskModel>> $completion) {
        return null;
    }
    
    @androidx.annotation.WorkerThread()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.TaskModel taskModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}