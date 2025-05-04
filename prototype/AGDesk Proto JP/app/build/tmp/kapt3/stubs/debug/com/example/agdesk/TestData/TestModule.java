package com.example.agdesk.TestData;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/example/agdesk/TestData/TestModule;", "", "()V", "provideDbDataCreator", "Lcom/example/agdesk/TestData/dbDataCreator;", "networkRepository", "Lcom/example/agdesk/repository/NetworkRepository;", "assetRepository", "Lcom/example/agdesk/repository/AssetRepository;", "taskRepository", "Lcom/example/agdesk/repository/TaskRepository;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class TestModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.agdesk.TestData.TestModule INSTANCE = null;
    
    private TestModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.TestData.dbDataCreator provideDbDataCreator(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.repository.NetworkRepository networkRepository, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.repository.AssetRepository assetRepository, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.repository.TaskRepository taskRepository) {
        return null;
    }
}