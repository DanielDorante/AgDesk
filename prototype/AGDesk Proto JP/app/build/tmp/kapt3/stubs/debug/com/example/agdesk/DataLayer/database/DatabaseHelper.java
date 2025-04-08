package com.example.agdesk.DataLayer.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fH\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH\u0007J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH\u0007J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010\u001d\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f\u00a8\u0006!"}, d2 = {"Lcom/example/agdesk/DataLayer/database/DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addInventory", "", "inventory", "Lcom/example/agdesk/models/InventoryModel;", "addTask", "name", "", "date", "time", "getAllInventories", "", "getAllTasks", "Lcom/example/agdesk/models/TaskModel;", "getFields", "Lcom/example/agdesk/models/FieldsModel;", "getMonthlyTasks", "getWeeklyTasks", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "saveField", "points", "Lcom/google/android/gms/maps/model/LatLng;", "Companion", "app_debug"})
public final class DatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DATABASE_NAME = "fields.db";
    private static final int DATABASE_VERSION = 1;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TABLE_FIELDS = "fields";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ID = "id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_NAME = "name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_POINTS = "points";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TABLE_TASKS = "tasks";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_TASK_ID = "task_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_TASK_NAME = "task_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_TASK_DATE = "task_date";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_TASK_TIME = "task_time";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TABLE_INVENTORY = "inventory";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_INVENTORY_ID = "inventory_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_INVENTORY_NAME = "inventory_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_INVENTORY_QUANTITY = "inventory_quantity";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.agdesk.DataLayer.database.DatabaseHelper.Companion Companion = null;
    
    public DatabaseHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    public final void saveField(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.google.android.gms.maps.model.LatLng> points) {
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.FieldsModel> getFields() {
        return null;
    }
    
    public final void addTask(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String time) {
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.TaskModel> getAllTasks() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.TaskModel> getWeeklyTasks() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.TaskModel> getMonthlyTasks() {
        return null;
    }
    
    public final void addInventory(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.InventoryModel inventory) {
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.InventoryModel> getAllInventories() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/agdesk/DataLayer/database/DatabaseHelper$Companion;", "", "()V", "COLUMN_ID", "", "COLUMN_INVENTORY_ID", "COLUMN_INVENTORY_NAME", "COLUMN_INVENTORY_QUANTITY", "COLUMN_NAME", "COLUMN_POINTS", "COLUMN_TASK_DATE", "COLUMN_TASK_ID", "COLUMN_TASK_NAME", "COLUMN_TASK_TIME", "DATABASE_NAME", "DATABASE_VERSION", "", "TABLE_FIELDS", "TABLE_INVENTORY", "TABLE_TASKS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}