package com.example.agdesk.Application;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/example/agdesk/Application/AgDesk;", "Landroid/app/Application;", "Landroidx/work/Configuration$Provider;", "()V", "hiltWorkerFactory", "Landroidx/hilt/work/HiltWorkerFactory;", "getHiltWorkerFactory", "()Landroidx/hilt/work/HiltWorkerFactory;", "setHiltWorkerFactory", "(Landroidx/hilt/work/HiltWorkerFactory;)V", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "onCreate", "", "app_debug"})
public final class AgDesk extends android.app.Application implements androidx.work.Configuration.Provider {
    @javax.inject.Inject()
    public androidx.hilt.work.HiltWorkerFactory hiltWorkerFactory;
    
    public AgDesk() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.hilt.work.HiltWorkerFactory getHiltWorkerFactory() {
        return null;
    }
    
    public final void setHiltWorkerFactory(@org.jetbrains.annotations.NotNull()
    androidx.hilt.work.HiltWorkerFactory p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.work.Configuration getWorkManagerConfiguration() {
        return null;
    }
}