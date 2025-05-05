package com.example.agdesk.DataLayer.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lcom/example/agdesk/DataLayer/database/AgDeskDatabase;", "Landroidx/room/RoomDatabase;", "()V", "assetDao", "Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "dbSyncDao", "Lcom/example/agdesk/DataLayer/DAOs/DbSyncDAO;", "fieldDao", "Lcom/example/agdesk/DataLayer/DAOs/FieldDAO;", "inventoryDao", "Lcom/example/agdesk/DataLayer/DAOs/InventoryDAO;", "taskDao", "Lcom/example/agdesk/DataLayer/DAOs/TaskDAO;", "userDao", "Lcom/example/agdesk/DataLayer/DAOs/UserDAO;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.agdesk.DataLayer.entities.Asset.Asset.class, com.example.agdesk.DataLayer.entities.sync.AssetSync.class, com.example.agdesk.DataLayer.entities.Asset.Operations.class, com.example.agdesk.DataLayer.entities.Asset.Damage.class, com.example.agdesk.DataLayer.entities.Asset.Expense.class, com.example.agdesk.DataLayer.entities.Asset.Vehicle.class, com.example.agdesk.DataLayer.entities.Asset.SmallEquipment.class, com.example.agdesk.DataLayer.entities.Asset.LargeEquipment.class, com.example.agdesk.DataLayer.entities.Task.class, com.example.agdesk.DataLayer.entities.sync.TaskSync.class, com.example.agdesk.DataLayer.entities.Fields.class, com.example.agdesk.DataLayer.entities.sync.FieldSync.class, com.example.agdesk.DataLayer.entities.InventoryItem.class, com.example.agdesk.DataLayer.entities.sync.InventorySync.class, com.example.agdesk.DataLayer.entities.User.Users.class, com.example.agdesk.DataLayer.entities.User.UserAuth.class, com.example.agdesk.DataLayer.entities.sync.DbSync.class}, version = 4)
public abstract class AgDeskDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.agdesk.DataLayer.database.AgDeskDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.agdesk.DataLayer.database.AgDeskDatabase.Companion Companion = null;
    
    public AgDeskDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.agdesk.DataLayer.DAOs.TaskDAO taskDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.agdesk.DataLayer.DAOs.AssetDAO assetDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.agdesk.DataLayer.DAOs.InventoryDAO inventoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.agdesk.DataLayer.DAOs.FieldDAO fieldDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.agdesk.DataLayer.DAOs.UserDAO userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.agdesk.DataLayer.DAOs.DbSyncDAO dbSyncDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/agdesk/DataLayer/database/AgDeskDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/agdesk/DataLayer/database/AgDeskDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.agdesk.DataLayer.database.AgDeskDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}