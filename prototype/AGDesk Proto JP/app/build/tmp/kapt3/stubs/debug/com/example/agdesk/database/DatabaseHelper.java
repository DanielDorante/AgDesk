package com.example.agdesk.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0007J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0015J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010#\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J$\u0010\'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0014J\u000e\u0010*\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u0015\u00a8\u0006,"}, d2 = {"Lcom/example/agdesk/database/DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addInventory", "", "inventory", "Lcom/example/agdesk/models/InventoryModel;", "addTask", "", "userId", "", "name", "date", "time", "createUser", "user", "Lcom/example/agdesk/models/UserModel;", "getAllAssets", "", "Lcom/example/agdesk/models/AssetModel;", "getAllInventories", "getAllTasks", "Lcom/example/agdesk/models/TaskModel;", "getAllUsers", "getFields", "Lcom/example/agdesk/models/FieldsModel;", "getMonthlyTasks", "getWeeklyTasks", "insertAsset", "asset", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "saveField", "points", "Lcom/google/android/gms/maps/model/LatLng;", "updateAsset", "Companion", "app_debug"})
public final class DatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DATABASE_NAME = "agdesk.db";
    private static final int DATABASE_VERSION = 1;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TABLE_USERS = "users";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_USER_NAME = "user_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_USER_EMAIL = "user_email";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_USER_PASSWORD = "user_password";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TABLE_FIELDS = "fields";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ID = "id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FIELD_USER_ID = "field_user_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_NAME = "name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_POINTS = "points";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TABLE_TASKS = "tasks";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_TASK_ID = "task_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TASK_USER_ID = "task_user_id";
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
    private static final java.lang.String INVENTORY_USER_ID = "inventory_user_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_INVENTORY_NAME = "inventory_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_INVENTORY_QUANTITY = "inventory_quantity";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TABLE_ASSETS = "assets";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_ID = "id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_PREFIX = "assetPrefix";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_NAME = "name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_MANUFAC = "manufac";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_PARTS = "parts";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_LOCATION = "location";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_DATE_MADE = "dateMade";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_DATE_BUY = "dateBuy";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_IMAGE = "image";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_FARM_ID = "farmId";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_VIN = "vin";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_SERIAL_NO = "serialNo";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_REG = "reg";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_SYNC_ID = "syncId";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_CHECKOUT_STATUS = "checkoutStatus";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String COLUMN_ASSET_CHECKOUT_BY = "checkoutBy";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.agdesk.database.DatabaseHelper.Companion Companion = null;
    
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
    
    public final long createUser(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UserModel user) {
        return 0L;
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.UserModel> getAllUsers() {
        return null;
    }
    
    public final void saveField(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.google.android.gms.maps.model.LatLng> points) {
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.FieldsModel> getFields(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    public final void addTask(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String time) {
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.TaskModel> getAllTasks(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.TaskModel> getWeeklyTasks(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.TaskModel> getMonthlyTasks(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    public final long addInventory(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.InventoryModel inventory) {
        return 0L;
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.InventoryModel> getAllInventories(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    public final long insertAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.AssetModel asset) {
        return 0L;
    }
    
    @android.annotation.SuppressLint(value = {"Range"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.AssetModel> getAllAssets() {
        return null;
    }
    
    public final int updateAsset(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.AssetModel asset) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/agdesk/database/DatabaseHelper$Companion;", "", "()V", "COLUMN_ASSET_CHECKOUT_BY", "", "COLUMN_ASSET_CHECKOUT_STATUS", "COLUMN_ASSET_DATE_BUY", "COLUMN_ASSET_DATE_MADE", "COLUMN_ASSET_FARM_ID", "COLUMN_ASSET_ID", "COLUMN_ASSET_IMAGE", "COLUMN_ASSET_LOCATION", "COLUMN_ASSET_MANUFAC", "COLUMN_ASSET_NAME", "COLUMN_ASSET_PARTS", "COLUMN_ASSET_PREFIX", "COLUMN_ASSET_REG", "COLUMN_ASSET_SERIAL_NO", "COLUMN_ASSET_SYNC_ID", "COLUMN_ASSET_VIN", "COLUMN_ID", "COLUMN_INVENTORY_ID", "COLUMN_INVENTORY_NAME", "COLUMN_INVENTORY_QUANTITY", "COLUMN_NAME", "COLUMN_POINTS", "COLUMN_TASK_DATE", "COLUMN_TASK_ID", "COLUMN_TASK_NAME", "COLUMN_TASK_TIME", "COLUMN_USER_EMAIL", "COLUMN_USER_ID", "COLUMN_USER_NAME", "COLUMN_USER_PASSWORD", "DATABASE_NAME", "DATABASE_VERSION", "", "FIELD_USER_ID", "INVENTORY_USER_ID", "TABLE_ASSETS", "TABLE_FIELDS", "TABLE_INVENTORY", "TABLE_TASKS", "TABLE_USERS", "TASK_USER_ID", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}