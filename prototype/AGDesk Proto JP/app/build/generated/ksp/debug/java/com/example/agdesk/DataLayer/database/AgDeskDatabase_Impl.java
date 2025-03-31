package com.example.agdesk.DataLayer.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.agdesk.DataLayer.DAOs.AssetDAO;
import com.example.agdesk.DataLayer.DAOs.AssetDAO_Impl;
import com.example.agdesk.DataLayer.DAOs.FieldDAO;
import com.example.agdesk.DataLayer.DAOs.FieldDAO_Impl;
import com.example.agdesk.DataLayer.DAOs.InventoryDAO;
import com.example.agdesk.DataLayer.DAOs.InventoryDAO_Impl;
import com.example.agdesk.DataLayer.DAOs.TaskDAO;
import com.example.agdesk.DataLayer.DAOs.TaskDAO_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AgDeskDatabase_Impl extends AgDeskDatabase {
  private volatile TaskDAO _taskDAO;

  private volatile AssetDAO _assetDAO;

  private volatile InventoryDAO _inventoryDAO;

  private volatile FieldDAO _fieldDAO;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Asset` (`uid` TEXT NOT NULL, `asset_Prefix` TEXT, `asset_Name` TEXT, `manufacture` TEXT, `part_List` TEXT, `location` TEXT, `date_Manufactured` INTEGER, `date_Purchased` INTEGER, `is_Delete` INTEGER NOT NULL, `asset_Image` TEXT, `farm_Id` INTEGER, `global_Id` INTEGER, PRIMARY KEY(`uid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `asset_sync` (`uid` TEXT NOT NULL, `synctimestamp` TEXT NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Vehicles` (`uid` TEXT NOT NULL, `vin` INTEGER, `registration` INTEGER, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `small_Equipment` (`uid` TEXT NOT NULL, `serial_Number` INTEGER, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Large_Equipment` (`uid` TEXT NOT NULL, `vin` INTEGER, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Task` (`uid` TEXT NOT NULL, `taskName` TEXT, `description` TEXT, `time_stamp` INTEGER, `is_Delete` INTEGER, `due_Date` INTEGER, `expire_Date` INTEGER, `status` INTEGER, `priority` INTEGER, `assigned_To` INTEGER, `farm_Id` INTEGER, `global_Id` INTEGER, PRIMARY KEY(`uid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `task_sync` (`uid` TEXT NOT NULL, `synctimestamp` TEXT NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Task`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Fields` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `points` TEXT NOT NULL, `global_Id` INTEGER, PRIMARY KEY(`uid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Field_Sync` (`uid` TEXT NOT NULL, `synctimestamp` TEXT NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Fields`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `InventoryItem` (`uid` TEXT NOT NULL, `item_Name` TEXT, `stock_Keeping_Unit` INTEGER, `category` TEXT, `quantity` TEXT, `cost_Price` REAL, `sell_Price` REAL, `global_Id` INTEGER, `name` TEXT, `email` TEXT, `phone` INTEGER, PRIMARY KEY(`uid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `inventory_Sync` (`uid` TEXT NOT NULL, `synctimestamp` INTEGER NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `InventoryItem`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e6675ec4b5867edefa7d426e930361a5')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `Asset`");
        db.execSQL("DROP TABLE IF EXISTS `asset_sync`");
        db.execSQL("DROP TABLE IF EXISTS `Vehicles`");
        db.execSQL("DROP TABLE IF EXISTS `small_Equipment`");
        db.execSQL("DROP TABLE IF EXISTS `Large_Equipment`");
        db.execSQL("DROP TABLE IF EXISTS `Task`");
        db.execSQL("DROP TABLE IF EXISTS `task_sync`");
        db.execSQL("DROP TABLE IF EXISTS `Fields`");
        db.execSQL("DROP TABLE IF EXISTS `Field_Sync`");
        db.execSQL("DROP TABLE IF EXISTS `InventoryItem`");
        db.execSQL("DROP TABLE IF EXISTS `inventory_Sync`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsAsset = new HashMap<String, TableInfo.Column>(12);
        _columnsAsset.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("asset_Prefix", new TableInfo.Column("asset_Prefix", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("asset_Name", new TableInfo.Column("asset_Name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("manufacture", new TableInfo.Column("manufacture", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("part_List", new TableInfo.Column("part_List", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("date_Manufactured", new TableInfo.Column("date_Manufactured", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("date_Purchased", new TableInfo.Column("date_Purchased", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("is_Delete", new TableInfo.Column("is_Delete", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("asset_Image", new TableInfo.Column("asset_Image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("farm_Id", new TableInfo.Column("farm_Id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsset.put("global_Id", new TableInfo.Column("global_Id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAsset = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAsset = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAsset = new TableInfo("Asset", _columnsAsset, _foreignKeysAsset, _indicesAsset);
        final TableInfo _existingAsset = TableInfo.read(db, "Asset");
        if (!_infoAsset.equals(_existingAsset)) {
          return new RoomOpenHelper.ValidationResult(false, "Asset(com.example.agdesk.DataLayer.entities.Asset.Asset).\n"
                  + " Expected:\n" + _infoAsset + "\n"
                  + " Found:\n" + _existingAsset);
        }
        final HashMap<String, TableInfo.Column> _columnsAssetSync = new HashMap<String, TableInfo.Column>(2);
        _columnsAssetSync.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssetSync.put("synctimestamp", new TableInfo.Column("synctimestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssetSync = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAssetSync.add(new TableInfo.ForeignKey("Asset", "CASCADE", "CASCADE", Arrays.asList("uid"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesAssetSync = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssetSync = new TableInfo("asset_sync", _columnsAssetSync, _foreignKeysAssetSync, _indicesAssetSync);
        final TableInfo _existingAssetSync = TableInfo.read(db, "asset_sync");
        if (!_infoAssetSync.equals(_existingAssetSync)) {
          return new RoomOpenHelper.ValidationResult(false, "asset_sync(com.example.agdesk.DataLayer.entities.sync.AssetSync).\n"
                  + " Expected:\n" + _infoAssetSync + "\n"
                  + " Found:\n" + _existingAssetSync);
        }
        final HashMap<String, TableInfo.Column> _columnsVehicles = new HashMap<String, TableInfo.Column>(3);
        _columnsVehicles.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVehicles.put("vin", new TableInfo.Column("vin", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVehicles.put("registration", new TableInfo.Column("registration", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVehicles = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysVehicles.add(new TableInfo.ForeignKey("Asset", "CASCADE", "CASCADE", Arrays.asList("uid"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesVehicles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVehicles = new TableInfo("Vehicles", _columnsVehicles, _foreignKeysVehicles, _indicesVehicles);
        final TableInfo _existingVehicles = TableInfo.read(db, "Vehicles");
        if (!_infoVehicles.equals(_existingVehicles)) {
          return new RoomOpenHelper.ValidationResult(false, "Vehicles(com.example.agdesk.DataLayer.entities.Asset.Vehicle).\n"
                  + " Expected:\n" + _infoVehicles + "\n"
                  + " Found:\n" + _existingVehicles);
        }
        final HashMap<String, TableInfo.Column> _columnsSmallEquipment = new HashMap<String, TableInfo.Column>(2);
        _columnsSmallEquipment.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSmallEquipment.put("serial_Number", new TableInfo.Column("serial_Number", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSmallEquipment = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSmallEquipment.add(new TableInfo.ForeignKey("Asset", "CASCADE", "CASCADE", Arrays.asList("uid"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesSmallEquipment = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSmallEquipment = new TableInfo("small_Equipment", _columnsSmallEquipment, _foreignKeysSmallEquipment, _indicesSmallEquipment);
        final TableInfo _existingSmallEquipment = TableInfo.read(db, "small_Equipment");
        if (!_infoSmallEquipment.equals(_existingSmallEquipment)) {
          return new RoomOpenHelper.ValidationResult(false, "small_Equipment(com.example.agdesk.DataLayer.entities.Asset.SmallEquipment).\n"
                  + " Expected:\n" + _infoSmallEquipment + "\n"
                  + " Found:\n" + _existingSmallEquipment);
        }
        final HashMap<String, TableInfo.Column> _columnsLargeEquipment = new HashMap<String, TableInfo.Column>(2);
        _columnsLargeEquipment.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLargeEquipment.put("vin", new TableInfo.Column("vin", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLargeEquipment = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysLargeEquipment.add(new TableInfo.ForeignKey("Asset", "CASCADE", "CASCADE", Arrays.asList("uid"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesLargeEquipment = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLargeEquipment = new TableInfo("Large_Equipment", _columnsLargeEquipment, _foreignKeysLargeEquipment, _indicesLargeEquipment);
        final TableInfo _existingLargeEquipment = TableInfo.read(db, "Large_Equipment");
        if (!_infoLargeEquipment.equals(_existingLargeEquipment)) {
          return new RoomOpenHelper.ValidationResult(false, "Large_Equipment(com.example.agdesk.DataLayer.entities.Asset.LargeEquipment).\n"
                  + " Expected:\n" + _infoLargeEquipment + "\n"
                  + " Found:\n" + _existingLargeEquipment);
        }
        final HashMap<String, TableInfo.Column> _columnsTask = new HashMap<String, TableInfo.Column>(12);
        _columnsTask.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("taskName", new TableInfo.Column("taskName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("time_stamp", new TableInfo.Column("time_stamp", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("is_Delete", new TableInfo.Column("is_Delete", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("due_Date", new TableInfo.Column("due_Date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("expire_Date", new TableInfo.Column("expire_Date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("status", new TableInfo.Column("status", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("priority", new TableInfo.Column("priority", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("assigned_To", new TableInfo.Column("assigned_To", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("farm_Id", new TableInfo.Column("farm_Id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("global_Id", new TableInfo.Column("global_Id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTask = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTask = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTask = new TableInfo("Task", _columnsTask, _foreignKeysTask, _indicesTask);
        final TableInfo _existingTask = TableInfo.read(db, "Task");
        if (!_infoTask.equals(_existingTask)) {
          return new RoomOpenHelper.ValidationResult(false, "Task(com.example.agdesk.DataLayer.entities.Task).\n"
                  + " Expected:\n" + _infoTask + "\n"
                  + " Found:\n" + _existingTask);
        }
        final HashMap<String, TableInfo.Column> _columnsTaskSync = new HashMap<String, TableInfo.Column>(2);
        _columnsTaskSync.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskSync.put("synctimestamp", new TableInfo.Column("synctimestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTaskSync = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTaskSync.add(new TableInfo.ForeignKey("Task", "CASCADE", "CASCADE", Arrays.asList("uid"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesTaskSync = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTaskSync = new TableInfo("task_sync", _columnsTaskSync, _foreignKeysTaskSync, _indicesTaskSync);
        final TableInfo _existingTaskSync = TableInfo.read(db, "task_sync");
        if (!_infoTaskSync.equals(_existingTaskSync)) {
          return new RoomOpenHelper.ValidationResult(false, "task_sync(com.example.agdesk.DataLayer.entities.sync.TaskSync).\n"
                  + " Expected:\n" + _infoTaskSync + "\n"
                  + " Found:\n" + _existingTaskSync);
        }
        final HashMap<String, TableInfo.Column> _columnsFields = new HashMap<String, TableInfo.Column>(4);
        _columnsFields.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFields.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFields.put("points", new TableInfo.Column("points", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFields.put("global_Id", new TableInfo.Column("global_Id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFields = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFields = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFields = new TableInfo("Fields", _columnsFields, _foreignKeysFields, _indicesFields);
        final TableInfo _existingFields = TableInfo.read(db, "Fields");
        if (!_infoFields.equals(_existingFields)) {
          return new RoomOpenHelper.ValidationResult(false, "Fields(com.example.agdesk.DataLayer.entities.Fields).\n"
                  + " Expected:\n" + _infoFields + "\n"
                  + " Found:\n" + _existingFields);
        }
        final HashMap<String, TableInfo.Column> _columnsFieldSync = new HashMap<String, TableInfo.Column>(2);
        _columnsFieldSync.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFieldSync.put("synctimestamp", new TableInfo.Column("synctimestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFieldSync = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysFieldSync.add(new TableInfo.ForeignKey("Fields", "CASCADE", "CASCADE", Arrays.asList("uid"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesFieldSync = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFieldSync = new TableInfo("Field_Sync", _columnsFieldSync, _foreignKeysFieldSync, _indicesFieldSync);
        final TableInfo _existingFieldSync = TableInfo.read(db, "Field_Sync");
        if (!_infoFieldSync.equals(_existingFieldSync)) {
          return new RoomOpenHelper.ValidationResult(false, "Field_Sync(com.example.agdesk.DataLayer.entities.sync.FieldSync).\n"
                  + " Expected:\n" + _infoFieldSync + "\n"
                  + " Found:\n" + _existingFieldSync);
        }
        final HashMap<String, TableInfo.Column> _columnsInventoryItem = new HashMap<String, TableInfo.Column>(11);
        _columnsInventoryItem.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("item_Name", new TableInfo.Column("item_Name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("stock_Keeping_Unit", new TableInfo.Column("stock_Keeping_Unit", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("quantity", new TableInfo.Column("quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("cost_Price", new TableInfo.Column("cost_Price", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("sell_Price", new TableInfo.Column("sell_Price", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("global_Id", new TableInfo.Column("global_Id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryItem.put("phone", new TableInfo.Column("phone", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInventoryItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInventoryItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInventoryItem = new TableInfo("InventoryItem", _columnsInventoryItem, _foreignKeysInventoryItem, _indicesInventoryItem);
        final TableInfo _existingInventoryItem = TableInfo.read(db, "InventoryItem");
        if (!_infoInventoryItem.equals(_existingInventoryItem)) {
          return new RoomOpenHelper.ValidationResult(false, "InventoryItem(com.example.agdesk.DataLayer.entities.InventoryItem).\n"
                  + " Expected:\n" + _infoInventoryItem + "\n"
                  + " Found:\n" + _existingInventoryItem);
        }
        final HashMap<String, TableInfo.Column> _columnsInventorySync = new HashMap<String, TableInfo.Column>(2);
        _columnsInventorySync.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventorySync.put("synctimestamp", new TableInfo.Column("synctimestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInventorySync = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysInventorySync.add(new TableInfo.ForeignKey("InventoryItem", "CASCADE", "CASCADE", Arrays.asList("uid"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesInventorySync = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInventorySync = new TableInfo("inventory_Sync", _columnsInventorySync, _foreignKeysInventorySync, _indicesInventorySync);
        final TableInfo _existingInventorySync = TableInfo.read(db, "inventory_Sync");
        if (!_infoInventorySync.equals(_existingInventorySync)) {
          return new RoomOpenHelper.ValidationResult(false, "inventory_Sync(com.example.agdesk.DataLayer.entities.sync.InventorySync).\n"
                  + " Expected:\n" + _infoInventorySync + "\n"
                  + " Found:\n" + _existingInventorySync);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e6675ec4b5867edefa7d426e930361a5", "61c760145f6f52bddf8d5bf8216cf267");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Asset","asset_sync","Vehicles","small_Equipment","Large_Equipment","Task","task_sync","Fields","Field_Sync","InventoryItem","inventory_Sync");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Asset`");
      _db.execSQL("DELETE FROM `asset_sync`");
      _db.execSQL("DELETE FROM `Vehicles`");
      _db.execSQL("DELETE FROM `small_Equipment`");
      _db.execSQL("DELETE FROM `Large_Equipment`");
      _db.execSQL("DELETE FROM `Task`");
      _db.execSQL("DELETE FROM `task_sync`");
      _db.execSQL("DELETE FROM `Fields`");
      _db.execSQL("DELETE FROM `Field_Sync`");
      _db.execSQL("DELETE FROM `InventoryItem`");
      _db.execSQL("DELETE FROM `inventory_Sync`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TaskDAO.class, TaskDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(AssetDAO.class, AssetDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(InventoryDAO.class, InventoryDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(FieldDAO.class, FieldDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public TaskDAO taskDao() {
    if (_taskDAO != null) {
      return _taskDAO;
    } else {
      synchronized(this) {
        if(_taskDAO == null) {
          _taskDAO = new TaskDAO_Impl(this);
        }
        return _taskDAO;
      }
    }
  }

  @Override
  public AssetDAO assetDao() {
    if (_assetDAO != null) {
      return _assetDAO;
    } else {
      synchronized(this) {
        if(_assetDAO == null) {
          _assetDAO = new AssetDAO_Impl(this);
        }
        return _assetDAO;
      }
    }
  }

  @Override
  public InventoryDAO inventoryDao() {
    if (_inventoryDAO != null) {
      return _inventoryDAO;
    } else {
      synchronized(this) {
        if(_inventoryDAO == null) {
          _inventoryDAO = new InventoryDAO_Impl(this);
        }
        return _inventoryDAO;
      }
    }
  }

  @Override
  public FieldDAO fieldDao() {
    if (_fieldDAO != null) {
      return _fieldDAO;
    } else {
      synchronized(this) {
        if(_fieldDAO == null) {
          _fieldDAO = new FieldDAO_Impl(this);
        }
        return _fieldDAO;
      }
    }
  }
}
