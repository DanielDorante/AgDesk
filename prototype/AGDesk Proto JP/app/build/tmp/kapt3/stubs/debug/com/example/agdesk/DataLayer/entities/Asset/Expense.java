package com.example.agdesk.DataLayer.entities.Asset;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003Jb\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010&J\u0013\u0010\'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\t\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010\u00a8\u0006,"}, d2 = {"Lcom/example/agdesk/DataLayer/entities/Asset/Expense;", "", "uid", "", "syncId", "", "start", "", "receipt", "isDelete", "", "maintenanceId", "assetId", "lodgedById", "(Ljava/lang/String;Ljava/lang/Long;DLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;J)V", "getAssetId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLodgedById", "()J", "getMaintenanceId", "getReceipt", "getStart", "()D", "getSyncId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Long;DLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;J)Lcom/example/agdesk/DataLayer/entities/Asset/Expense;", "equals", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(foreignKeys = {@androidx.room.ForeignKey(entity = com.example.agdesk.DataLayer.entities.Asset.Asset.class, parentColumns = {"uid"}, childColumns = {"Asset_Id"}, onDelete = 5, onUpdate = 5), @androidx.room.ForeignKey(entity = com.example.agdesk.DataLayer.entities.User.Users.class, parentColumns = {"id"}, childColumns = {"Lodged_by_id"}, onDelete = 5, onUpdate = 5)})
public final class Expense {
    @androidx.room.PrimaryKey()
    @androidx.room.ColumnInfo(name = "Expense_id")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String uid = null;
    @androidx.room.ColumnInfo(name = "Global_id")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long syncId = null;
    @androidx.room.ColumnInfo(name = "Cost")
    private final double start = 0.0;
    @androidx.room.ColumnInfo(name = "receipt_Number")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String receipt = null;
    @androidx.room.ColumnInfo(name = "is_Delete")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isDelete = null;
    @androidx.room.ColumnInfo(name = "Maintenance_Id")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String maintenanceId = null;
    @androidx.room.ColumnInfo(name = "Asset_Id")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String assetId = null;
    @androidx.room.ColumnInfo(name = "Lodged_by_id")
    private final long lodgedById = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component2() {
        return null;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    public final long component8() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.DataLayer.entities.Asset.Expense copy(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.Nullable()
    java.lang.Long syncId, double start, @org.jetbrains.annotations.NotNull()
    java.lang.String receipt, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isDelete, @org.jetbrains.annotations.NotNull()
    java.lang.String maintenanceId, @org.jetbrains.annotations.NotNull()
    java.lang.String assetId, long lodgedById) {
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
    
    public Expense(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.Nullable()
    java.lang.Long syncId, double start, @org.jetbrains.annotations.NotNull()
    java.lang.String receipt, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isDelete, @org.jetbrains.annotations.NotNull()
    java.lang.String maintenanceId, @org.jetbrains.annotations.NotNull()
    java.lang.String assetId, long lodgedById) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getSyncId() {
        return null;
    }
    
    public final double getStart() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceipt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isDelete() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMaintenanceId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAssetId() {
        return null;
    }
    
    public final long getLodgedById() {
        return 0L;
    }
}