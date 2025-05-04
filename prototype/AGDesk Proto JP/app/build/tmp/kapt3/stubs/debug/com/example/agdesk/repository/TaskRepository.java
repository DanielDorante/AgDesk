package com.example.agdesk.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00a2\u0006\u0002\u0010\nJ\"\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0016\"\u00020\tH\u0087@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0087@\u00a2\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0087@\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/agdesk/repository/TaskRepository;", "", "taskDAO", "Lcom/example/agdesk/DataLayer/DAOs/TaskDAO;", "userDAO", "Lcom/example/agdesk/DataLayer/DAOs/UserDAO;", "(Lcom/example/agdesk/DataLayer/DAOs/TaskDAO;Lcom/example/agdesk/DataLayer/DAOs/UserDAO;)V", "getAllTasks", "", "Lcom/example/agdesk/models/TaskModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfflineTasks", "", "Lcom/example/agdesk/models/networkModels/dataModels/TaskNetworkModel;", "getTasksByTimeFrame", "timeFrame", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThisUsersTasks", "insertTask", "", "taskModel", "", "([Lcom/example/agdesk/models/TaskModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "(Lcom/example/agdesk/models/TaskModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTaskNetwork", "taskNetworkModel", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TaskRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DataLayer.DAOs.TaskDAO taskDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DataLayer.DAOs.UserDAO userDAO = null;
    
    @javax.inject.Inject()
    public TaskRepository(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.DAOs.TaskDAO taskDAO, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.DAOs.UserDAO userDAO) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTasksByTimeFrame(@org.jetbrains.annotations.NotNull()
    java.lang.String timeFrame, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.TaskModel>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getThisUsersTasks(@org.jetbrains.annotations.NotNull()
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
    
    @androidx.annotation.WorkerThread()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateTaskNetwork(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel> taskNetworkModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOfflineTasks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel>> $completion) {
        return null;
    }
}