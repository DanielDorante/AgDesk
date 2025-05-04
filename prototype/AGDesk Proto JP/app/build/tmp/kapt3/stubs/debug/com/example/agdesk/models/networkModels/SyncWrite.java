package com.example.agdesk.models.networkModels;

@kotlinx.serialization.Serializable()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u00a2\u0006\u0002\u0010\rJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u00c6\u0003JY\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/example/agdesk/models/networkModels/SyncWrite;", "", "assets", "", "Lcom/example/agdesk/models/networkModels/dataModels/AssetNetworkModel;", "tasks", "Lcom/example/agdesk/models/networkModels/dataModels/TaskNetworkModel;", "operations", "Lcom/example/agdesk/models/networkModels/dataModels/OperationNetworkModel;", "damages", "Lcom/example/agdesk/models/networkModels/dataModels/DamageNetworkModel;", "expenses", "Lcom/example/agdesk/models/networkModels/dataModels/ExpenseNetworkModel;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAssets", "()Ljava/util/List;", "getDamages", "getExpenses", "getOperations", "getTasks", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class SyncWrite {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel> assets = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel> tasks = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.agdesk.models.networkModels.dataModels.OperationNetworkModel> operations = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.agdesk.models.networkModels.dataModels.DamageNetworkModel> damages = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.agdesk.models.networkModels.dataModels.ExpenseNetworkModel> expenses = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.OperationNetworkModel> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.DamageNetworkModel> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.ExpenseNetworkModel> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.models.networkModels.SyncWrite copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel> assets, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel> tasks, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.OperationNetworkModel> operations, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.DamageNetworkModel> damages, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.ExpenseNetworkModel> expenses) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public SyncWrite(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel> assets, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel> tasks, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.OperationNetworkModel> operations, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.DamageNetworkModel> damages, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.networkModels.dataModels.ExpenseNetworkModel> expenses) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel> getAssets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel> getTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.OperationNetworkModel> getOperations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.DamageNetworkModel> getDamages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.networkModels.dataModels.ExpenseNetworkModel> getExpenses() {
        return null;
    }
}