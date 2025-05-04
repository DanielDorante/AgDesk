package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0017\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0019\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\"\u0010\u001a\u001a\u00020\u00032\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u00032\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u001c\"\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\""}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/TaskDAO;", "", "deleteSync", "", "delUid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "task", "Lcom/example/agdesk/DataLayer/entities/Task;", "(Lcom/example/agdesk/DataLayer/entities/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "Lcom/example/agdesk/models/TaskModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBySyncId", "Lcom/example/agdesk/DataLayer/entities/Asset/Asset;", "syncId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfflineTasks", "Lcom/example/agdesk/models/networkModels/dataModels/TaskNetworkModel;", "getTimeframe", "timeFrame", "getUserTasks", "id", "insertSync", "sync", "", "Lcom/example/agdesk/DataLayer/entities/sync/TaskSync;", "([Lcom/example/agdesk/DataLayer/entities/sync/TaskSync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTask", "([Lcom/example/agdesk/DataLayer/entities/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "app_debug"})
@androidx.room.Dao()
public abstract interface TaskDAO {
    
    @androidx.room.Query(value = "SELECT * FROM TASK")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.TaskModel>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM TASK_SYNC INNER JOIN TASK ON TASK.uid = TASK_SYNC.uid")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOfflineTasks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM TASK WHERE due_Date < :timeFrame")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTimeframe(int timeFrame, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.TaskModel>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Asset WHERE global_Id = :syncId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBySyncId(int syncId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.agdesk.DataLayer.entities.Asset.Asset> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTask(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Task[] task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
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
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.TaskModel>> $completion);
}