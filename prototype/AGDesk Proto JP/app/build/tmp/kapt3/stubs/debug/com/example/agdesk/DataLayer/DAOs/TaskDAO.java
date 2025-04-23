package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\"\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0013\"\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/TaskDAO;", "", "deleteTask", "", "task", "Lcom/example/agdesk/DataLayer/entities/Task;", "(Lcom/example/agdesk/DataLayer/entities/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "Lcom/example/agdesk/models/TaskModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeframe", "timeFrame", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserTasks", "id", "insertSync", "sync", "", "Lcom/example/agdesk/DataLayer/entities/sync/TaskSync;", "([Lcom/example/agdesk/DataLayer/entities/sync/TaskSync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTask", "([Lcom/example/agdesk/DataLayer/entities/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "app_debug"})
@androidx.room.Dao()
public abstract interface TaskDAO {
    
    @androidx.room.Query(value = "SELECT * FROM TASK")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.TaskModel>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM TASK WHERE due_Date < :timeFrame")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTimeframe(int timeFrame, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.TaskModel>> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTask(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Task[] task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSync(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.sync.TaskSync[] sync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Task WHERE assigned_To = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserTasks(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.TaskModel>> $completion);
}