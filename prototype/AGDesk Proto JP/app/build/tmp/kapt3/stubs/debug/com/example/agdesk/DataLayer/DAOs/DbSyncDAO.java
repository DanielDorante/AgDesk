package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/DbSyncDAO;", "", "getLastSyncInfo", "Lcom/example/agdesk/models/networkModels/SyncRequest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSyncInfo", "", "dbSync", "Lcom/example/agdesk/DataLayer/entities/sync/DbSync;", "(Lcom/example/agdesk/DataLayer/entities/sync/DbSync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSyncTimestamp", "timestamp", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface DbSyncDAO {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSyncInfo(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.sync.DbSync dbSync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM DbSync WHERE dbInfoId = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLastSyncInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.agdesk.models.networkModels.SyncRequest> $completion);
    
    @androidx.room.Query(value = "UPDATE DbSync SET lastSyncTimeStamp = :timestamp WHERE dbInfoId = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSyncTimestamp(@org.jetbrains.annotations.NotNull()
    java.lang.String timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}