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
import com.example.agdesk.DataLayer.DAOs.UserDAO;
import com.example.agdesk.DataLayer.DAOs.UserDAO_Impl;
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

  private volatile UserDAO _userDAO;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Asset` (`uid` TEXT NOT NULL, `asset_Prefix` TEXT, `asset_Name` TEXT, `manufacture` TEXT, `part_List` TEXT, `location` TEXT, `date_Manufactured` INTEGER, `date_Purchased` INTEGER, `is_Delete` INTEGER NOT NULL, `asset_Image` TEXT, `farm_Id` INTEGER, `global_Id` INTEGER, PRIMARY KEY(`uid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `asset_sync` (`uid` TEXT NOT NULL, `synctimestamp` TEXT NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Operations` (`Log_id` TEXT NOT NULL, `Global_id` INTEGER, `Start_Date_Time` TEXT NOT NULL, `End_Date_Time` TEXT, `Location` TEXT NOT NULL, `Notes` TEXT, `isDelete` INTEGER NOT NULL, `Asset_Id` TEXT NOT NULL, `User_ID` TEXT NOT NULL, PRIMARY KEY(`Log_id`), FOREIGN KEY(`Asset_Id`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`Asset_Id`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Damage` (`Damage_Id` TEXT NOT NULL, `Global_id` INTEGER, `Damage_Observed_Date` TEXT NOT NULL, `Damage_Occurred_Date` TEXT NOT NULL, `Damage_Type` TEXT NOT NULL, `Damage_Severity` TEXT NOT NULL, `Notes` TEXT NOT NULL, `Damage_Image` TEXT, `Scheduled_Maintenance_Date` INTEGER, `Is_Delete` INTEGER, `Asset_Id` TEXT NOT NULL, PRIMARY KEY(`Damage_Id`), FOREIGN KEY(`Asset_Id`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Expense` (`Expense_id` TEXT NOT NULL, `Global_id` INTEGER, `Cost` INTEGER NOT NULL, `receipt_Number` INTEGER NOT NULL, `is_Delete` INTEGER, `Maintenance_Id` TEXT NOT NULL, `Asset_Id` TEXT NOT NULL, `Lodged_by_id` INTEGER NOT NULL, PRIMARY KEY(`Expense_id`), FOREIGN KEY(`Asset_Id`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`Lodged_by_id`) REFERENCES `Users`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Vehicles` (`uid` TEXT NOT NULL, `vin` INTEGER, `registration` INTEGER, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `small_Equipment` (`uid` TEXT NOT NULL, `serial_Number` INTEGER, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Large_Equipment` (`uid` TEXT NOT NULL, `vin` INTEGER, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Asset`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Task` (`uid` TEXT NOT NULL, `taskName` TEXT, `description` TEXT, `time_stamp` INTEGER, `is_Delete` INTEGER, `due_Date` INTEGER, `expire_Date` INTEGER, `status` INTEGER, `priority` INTEGER, `assigned_To` INTEGER, `farm_Id` INTEGER, `global_Id` INTEGER, PRIMARY KEY(`uid`), FOREIGN KEY(`assigned_To`) REFERENCES `Users`(`id`) ON UPDATE CASCADE ON DELETE SET NULL )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `task_sync` (`uid` TEXT NOT NULL, `synctimestamp` TEXT NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Task`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Fields` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `points` TEXT NOT NULL, `global_Id` INTEGER, PRIMARY KEY(`uid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Field_Sync` (`uid` TEXT NOT NULL, `synctimestamp` TEXT NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `Fields`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `InventoryItem` (`uid` TEXT NOT NULL, `item_Name` TEXT, `stock_Keeping_Unit` INTEGER, `category` TEXT, `quantity` TEXT, `cost_Price` REAL, `sell_Price` REAL, `global_Id` INTEGER, `name` TEXT, `email` TEXT, `phone` INTEGER, PRIMARY KEY(`uid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `inventory_Sync` (`uid` TEXT NOT NULL, `synctimestamp` TEXT NOT NULL, PRIMARY KEY(`uid`), FOREIGN KEY(`uid`) REFERENCES `InventoryItem`(`uid`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Users` (`placeholder` TEXT, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `UserAuth` (`placeholder` TEXT, `id` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`id`) REFERENCES `Users`(`id`) ON UPDATE CASCADE ON DELETE SET NULL )");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bafc1ab8e3da95221fd3dcd7141e6c63')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `Asset`");
        db.execSQL("DROP TABLE IF EXISTS `asset_sync`");
        db.execSQL("DROP TABLE IF EXISTS `Operations`");
        db.execSQL("DROP TABLE IF EXISTS `Damage`");
        db.execSQL("DROP TABLE IF EXISTS `Expense`");
        db.execSQL("DROP TABLE IF EXISTS `Vehicles`");
        db.execSQL("DROP TABLE IF EXISTS `small_Equipment`");
        db.execSQL("DROP TABLE IF EXISTS `Large_Equipment`");
        db.execSQL("DROP TABLE IF EXISTS `Task`");
        db.execSQL("DROP TABLE IF EXISTS `task_sync`");
        db.execSQL("DROP TABLE IF EXISTS `Fields`");
        db.execSQL("DROP TABLE IF EXISTS `Field_Sync`");
        db.execSQL("DROP TABLE IF EXISTS `InventoryItem`");
        db.execSQL("DROP TABLE IF EXISTS `inventory_Sync`");
        db.execSQL("DROP TABLE IF EXISTS `Users`");
        db.execSQL("DROP TABLE IF EXISTS `UserAuth`");
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
        final HashMap<String, TableInfo.Column> _columnsOperations = new HashMap<String, TableInfo.Column>(9);
        _columnsOperations.put("Log_id", new TableInfo.Column("Log_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOperations.put("Global_id", new TableInfo.Column("Global_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOperations.put("Start_Date_Time", new TableInfo.Column("Start_Date_Time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOperations.put("End_Date_Time", new TableInfo.Column("End_Date_Time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOperations.put("Location", new TableInfo.Column("Location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOperations.put("Notes", new TableInfo.Column("Notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOperations.put("isDelete", new TableInfo.Column("isDelete", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOperations.put("Asset_Id", new TableInfo.Column("Asset_Id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOperations.put("User_ID", new TableInfo.Column("User_ID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOperations = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysOperations.add(new TableInfo.ForeignKey("Asset", "CASCADE", "CASCADE", Arrays.asList("Asset_Id"), Arrays.asList("uid")));
        _foreignKeysOperations.add(new TableInfo.ForeignKey("Asset", "CASCADE", "CASCADE", Arrays.asList("Asset_Id"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesOperations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOperations = new TableInfo("Operations", _columnsOperations, _foreignKeysOperations, _indicesOperations);
        final TableInfo _existingOperations = TableInfo.read(db, "Operations");
        if (!_infoOperations.equals(_existingOperations)) {
          return new RoomOpenHelper.ValidationResult(false, "Operations(com.example.agdesk.DataLayer.entities.Asset.Operations).\n"
                  + " Expected:\n" + _infoOperations + "\n"
                  + " Found:\n" + _existingOperations);
        }
        final HashMap<String, TableInfo.Column> _columnsDamage = new HashMap<String, TableInfo.Column>(11);
        _columnsDamage.put("Damage_Id", new TableInfo.Column("Damage_Id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Global_id", new TableInfo.Column("Global_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Damage_Observed_Date", new TableInfo.Column("Damage_Observed_Date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Damage_Occurred_Date", new TableInfo.Column("Damage_Occurred_Date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Damage_Type", new TableInfo.Column("Damage_Type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Damage_Severity", new TableInfo.Column("Damage_Severity", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Notes", new TableInfo.Column("Notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Damage_Image", new TableInfo.Column("Damage_Image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Scheduled_Maintenance_Date", new TableInfo.Column("Scheduled_Maintenance_Date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Is_Delete", new TableInfo.Column("Is_Delete", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDamage.put("Asset_Id", new TableInfo.Column("Asset_Id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDamage = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysDamage.add(new TableInfo.ForeignKey("Asset", "CASCADE", "CASCADE", Arrays.asList("Asset_Id"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesDamage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDamage = new TableInfo("Damage", _columnsDamage, _foreignKeysDamage, _indicesDamage);
        final TableInfo _existingDamage = TableInfo.read(db, "Damage");
        if (!_infoDamage.equals(_existingDamage)) {
          return new RoomOpenHelper.ValidationResult(false, "Damage(com.example.agdesk.DataLayer.entities.Asset.Damage).\n"
                  + " Expected:\n" + _infoDamage + "\n"
                  + " Found:\n" + _existingDamage);
        }
        final HashMap<String, TableInfo.Column> _columnsExpense = new HashMap<String, TableInfo.Column>(8);
        _columnsExpense.put("Expense_id", new TableInfo.Column("Expense_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("Global_id", new TableInfo.Column("Global_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("Cost", new TableInfo.Column("Cost", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("receipt_Number", new TableInfo.Column("receipt_Number", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("is_Delete", new TableInfo.Column("is_Delete", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("Maintenance_Id", new TableInfo.Column("Maintenance_Id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("Asset_Id", new TableInfo.Column("Asset_Id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpense.put("Lodged_by_id", new TableInfo.Column("Lodged_by_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExpense = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysExpense.add(new TableInfo.ForeignKey("Asset", "CASCADE", "CASCADE", Arrays.asList("Asset_Id"), Arrays.asList("uid")));
        _foreignKeysExpense.add(new TableInfo.ForeignKey("Users", "CASCADE", "CASCADE", Arrays.asList("Lodged_by_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesExpense = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExpense = new TableInfo("Expense", _columnsExpense, _foreignKeysExpense, _indicesExpense);
        final TableInfo _existingExpense = TableInfo.read(db, "Expense");
        if (!_infoExpense.equals(_existingExpense)) {
          return new RoomOpenHelper.ValidationResult(false, "Expense(com.example.agdesk.DataLayer.entities.Asset.Expense).\n"
                  + " Expected:\n" + _infoExpense + "\n"
                  + " Found:\n" + _existingExpense);
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
        final HashSet<TableInfo.ForeignKey> _foreignKeysTask = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTask.add(new TableInfo.ForeignKey("Users", "SET NULL", "CASCADE", Arrays.asList("assigned_To"), Arrays.asList("id")));
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
        _columnsInventorySync.put("synctimestamp", new TableInfo.Column("synctimestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(2);
        _columnsUsers.put("placeholder", new TableInfo.Column("placeholder", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("Users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "Users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "Users(com.example.agdesk.DataLayer.entities.User.Users).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsUserAuth = new HashMap<String, TableInfo.Column>(2);
        _columnsUserAuth.put("placeholder", new TableInfo.Column("placeholder", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserAuth.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserAuth = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysUserAuth.add(new TableInfo.ForeignKey("Users", "SET NULL", "CASCADE", Arrays.asList("id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUserAuth = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserAuth = new TableInfo("UserAuth", _columnsUserAuth, _foreignKeysUserAuth, _indicesUserAuth);
        final TableInfo _existingUserAuth = TableInfo.read(db, "UserAuth");
        if (!_infoUserAuth.equals(_existingUserAuth)) {
          return new RoomOpenHelper.ValidationResult(false, "UserAuth(com.example.agdesk.DataLayer.entities.User.UserAuth).\n"
                  + " Expected:\n" + _infoUserAuth + "\n"
                  + " Found:\n" + _existingUserAuth);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "bafc1ab8e3da95221fd3dcd7141e6c63", "aeb7db0fbbb75c72b54613fa12535da0");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Asset","asset_sync","Operations","Damage","Expense","Vehicles","small_Equipment","Large_Equipment","Task","task_sync","Fields","Field_Sync","InventoryItem","inventory_Sync","Users","UserAuth");
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
      _db.execSQL("DELETE FROM `Operations`");
      _db.execSQL("DELETE FROM `Damage`");
      _db.execSQL("DELETE FROM `Expense`");
      _db.execSQL("DELETE FROM `Vehicles`");
      _db.execSQL("DELETE FROM `small_Equipment`");
      _db.execSQL("DELETE FROM `Large_Equipment`");
      _db.execSQL("DELETE FROM `Task`");
      _db.execSQL("DELETE FROM `task_sync`");
      _db.execSQL("DELETE FROM `Fields`");
      _db.execSQL("DELETE FROM `Field_Sync`");
      _db.execSQL("DELETE FROM `InventoryItem`");
      _db.execSQL("DELETE FROM `inventory_Sync`");
      _db.execSQL("DELETE FROM `Users`");
      _db.execSQL("DELETE FROM `UserAuth`");
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
    _typeConvertersMap.put(UserDAO.class, UserDAO_Impl.getRequiredConverters());
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

  @Override
  public UserDAO userDao() {
    if (_userDAO != null) {
      return _userDAO;
    } else {
      synchronized(this) {
        if(_userDAO == null) {
          _userDAO = new UserDAO_Impl(this);
        }
        return _userDAO;
      }
    }
  }
}
