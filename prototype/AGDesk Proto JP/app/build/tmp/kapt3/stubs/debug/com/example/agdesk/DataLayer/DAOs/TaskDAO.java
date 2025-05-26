package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u00032\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f\"\u00020 H\u00a7@\u00a2\u0006\u0002\u0010!J\"\u0010\"\u001a\u00020\u00032\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u001f\"\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006%"}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/TaskDAO;", "", "deleteSync", "", "delUid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "task", "Lcom/example/agdesk/DataLayer/entities/Task;", "(Lcom/example/agdesk/DataLayer/entities/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "Lcom/example/agdesk/models/UIModels/TaskModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBySyncId", "syncId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByUid", "uid", "getOfflineTasks", "Lcom/example/agdesk/models/networkModels/dataModels/TaskNetworkModel;", "getTimeframe", "timeFrame", "getUserTasks", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSync", "sync", "", "Lcom/example/agdesk/DataLayer/entities/sync/TaskSync;", "([Lcom/example/agdesk/DataLayer/entities/sync/TaskSync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTask", "([Lcom/example/agdesk/DataLayer/entities/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "app_debug"})
@androidx.room.Dao()
public abstract interface TaskDAO {
    
    @androidx.room.Query(value = "SELECT * FROM TASK")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.TaskModel>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM TASK_SYNC INNER JOIN TASK ON TASK.uid = TASK_SYNC.uid")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOfflineTasks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM TASK WHERE due_Date < :timeFrame")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTimeframe(long timeFrame, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.TaskModel>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Task WHERE global_Id = :syncId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBySyncId(long syncId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.agdesk.DataLayer.entities.Task> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Task WHERE uid = :uid LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByUid(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.agdesk.DataLayer.entities.Task> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTask(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Task[] task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSync(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.sync.TaskSync[] sync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM task_sync WHERE uid = :delUid")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSync(@org.jetbrains.annotations.NotNull()
    java.lang.String delUid, @org.jetbrains.annotations.NotNull()
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
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.TaskModel>> $completion);
}