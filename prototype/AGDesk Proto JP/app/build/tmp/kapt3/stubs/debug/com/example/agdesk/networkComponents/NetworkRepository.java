package com.example.agdesk.networkComponents;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/agdesk/networkComponents/NetworkRepository;", "", "assetRepository", "Lcom/example/agdesk/repository/AssetRepository;", "taskRepository", "Lcom/example/agdesk/repository/TaskRepository;", "httpClient", "Lio/ktor/client/HttpClient;", "(Lcom/example/agdesk/repository/AssetRepository;Lcom/example/agdesk/repository/TaskRepository;Lio/ktor/client/HttpClient;)V", "syncFromServer", "", "lastSyncTimestamp", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncToServer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NetworkRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.repository.AssetRepository assetRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.repository.TaskRepository taskRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final io.ktor.client.HttpClient httpClient = null;
    
    @javax.inject.Inject()
    public NetworkRepository(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.repository.AssetRepository assetRepository, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.repository.TaskRepository taskRepository, @org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient httpClient) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncFromServer(@org.jetbrains.annotations.NotNull()
    java.lang.String lastSyncTimestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncToServer(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}