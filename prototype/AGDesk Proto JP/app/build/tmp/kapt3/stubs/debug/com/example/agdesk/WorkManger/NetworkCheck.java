package com.example.agdesk.WorkManger;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/agdesk/WorkManger/NetworkCheck;", "", "context", "Landroid/content/Context;", "workMangerHelper", "Lcom/example/agdesk/WorkManger/WorkManagerHelper;", "(Landroid/content/Context;Lcom/example/agdesk/WorkManger/WorkManagerHelper;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkRequest", "Landroid/net/NetworkRequest;", "kotlin.jvm.PlatformType", "showToast", "", "message", "", "startNetworkCallback", "stopNetworkCallback", "app_debug"})
public final class NetworkCheck {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.net.ConnectivityManager connectivityManager = null;
    private final android.net.NetworkRequest networkRequest = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.WorkManger.WorkManagerHelper workMangerHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final android.net.ConnectivityManager.NetworkCallback networkCallback = null;
    
    public NetworkCheck(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.WorkManger.WorkManagerHelper workMangerHelper) {
        super();
    }
    
    public final void startNetworkCallback() {
    }
    
    public final void stopNetworkCallback() {
    }
    
    private final void showToast(java.lang.String message) {
    }
}