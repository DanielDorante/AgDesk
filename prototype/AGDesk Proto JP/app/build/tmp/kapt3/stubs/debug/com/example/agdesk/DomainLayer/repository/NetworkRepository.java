package com.example.agdesk.DomainLayer.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/agdesk/DomainLayer/repository/NetworkRepository;", "", "assetRepository", "Lcom/example/agdesk/DomainLayer/repository/AssetRepository;", "taskRepository", "Lcom/example/agdesk/DomainLayer/repository/TaskRepository;", "httpClient", "Lio/ktor/client/HttpClient;", "dbSyncDAO", "Lcom/example/agdesk/DataLayer/DAOs/DbSyncDAO;", "(Lcom/example/agdesk/DomainLayer/repository/AssetRepository;Lcom/example/agdesk/DomainLayer/repository/TaskRepository;Lio/ktor/client/HttpClient;Lcom/example/agdesk/DataLayer/DAOs/DbSyncDAO;)V", "getSyncTimeUI", "Ljava/util/Date;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncFromServer", "", "syncToServer", "app_debug"})
public final class NetworkRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DomainLayer.repository.AssetRepository assetRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DomainLayer.repository.TaskRepository taskRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final io.ktor.client.HttpClient httpClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.DataLayer.DAOs.DbSyncDAO dbSyncDAO = null;
    
    @javax.inject.Inject()
    public NetworkRepository(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DomainLayer.repository.AssetRepository assetRepository, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.DomainLayer.repository.TaskRepository taskRepository, @org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient httpClient, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.DAOs.DbSyncDAO dbSyncDAO) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncFromServer(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSyncTimeUI(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Date> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncToServer(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}