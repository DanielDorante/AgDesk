package com.example.agdesk.DataLayer.DAOs;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.agdesk.DataLayer.Converters.DatabaseConverter;
import com.example.agdesk.DataLayer.entities.Asset.Asset;
import com.example.agdesk.DataLayer.entities.Asset.LargeEquipment;
import com.example.agdesk.DataLayer.entities.Asset.Operations;
import com.example.agdesk.DataLayer.entities.Asset.SmallEquipment;
import com.example.agdesk.DataLayer.entities.Asset.Vehicle;
import com.example.agdesk.DataLayer.entities.sync.AssetSync;
import com.example.agdesk.models.AssetModel;
import com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AssetDAO_Impl implements AssetDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Asset> __insertionAdapterOfAsset;

  private final EntityInsertionAdapter<AssetSync> __insertionAdapterOfAssetSync;

  private final EntityInsertionAdapter<Vehicle> __insertionAdapterOfVehicle;

  private final EntityInsertionAdapter<SmallEquipment> __insertionAdapterOfSmallEquipment;

  private final EntityInsertionAdapter<LargeEquipment> __insertionAdapterOfLargeEquipment;

  private final EntityDeletionOrUpdateAdapter<Asset> __deletionAdapterOfAsset;

  private final EntityDeletionOrUpdateAdapter<Asset> __updateAdapterOfAsset;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSync;

  private final DatabaseConverter __databaseConverter = new DatabaseConverter();

  public AssetDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAsset = new EntityInsertionAdapter<Asset>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Asset` (`uid`,`asset_Prefix`,`asset_Name`,`manufacture`,`part_List`,`location`,`date_Manufactured`,`date_Purchased`,`is_Delete`,`asset_Image`,`farm_Id`,`global_Id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Asset entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getAssetPrefix() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAssetPrefix());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getManufac() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getManufac());
        }
        if (entity.getParts() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getParts());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getLocation());
        }
        if (entity.getDateMade() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getDateMade());
        }
        if (entity.getDateBuy() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getDateBuy());
        }
        final int _tmp = entity.isDel() ? 1 : 0;
        statement.bindLong(9, _tmp);
        if (entity.getImage() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getImage());
        }
        if (entity.getFarmId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getFarmId());
        }
        if (entity.getSyncId() == null) {
          statement.bindNull(12);
        } else {
          statement.bindLong(12, entity.getSyncId());
        }
      }
    };
    this.__insertionAdapterOfAssetSync = new EntityInsertionAdapter<AssetSync>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `asset_sync` (`uid`,`synctimestamp`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AssetSync entity) {
        statement.bindString(1, entity.getUid());
        statement.bindString(2, entity.getSynctime());
      }
    };
    this.__insertionAdapterOfVehicle = new EntityInsertionAdapter<Vehicle>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Vehicles` (`uid`,`vin`,`registration`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Vehicle entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getVin() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getVin());
        }
        if (entity.getReg() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getReg());
        }
      }
    };
    this.__insertionAdapterOfSmallEquipment = new EntityInsertionAdapter<SmallEquipment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `small_Equipment` (`uid`,`serial_Number`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SmallEquipment entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getSerialNo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getSerialNo());
        }
      }
    };
    this.__insertionAdapterOfLargeEquipment = new EntityInsertionAdapter<LargeEquipment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Large_Equipment` (`uid`,`vin`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LargeEquipment entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getVin() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getVin());
        }
      }
    };
    this.__deletionAdapterOfAsset = new EntityDeletionOrUpdateAdapter<Asset>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Asset` WHERE `uid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Asset entity) {
        statement.bindString(1, entity.getUid());
      }
    };
    this.__updateAdapterOfAsset = new EntityDeletionOrUpdateAdapter<Asset>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Asset` SET `uid` = ?,`asset_Prefix` = ?,`asset_Name` = ?,`manufacture` = ?,`part_List` = ?,`location` = ?,`date_Manufactured` = ?,`date_Purchased` = ?,`is_Delete` = ?,`asset_Image` = ?,`farm_Id` = ?,`global_Id` = ? WHERE `uid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Asset entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getAssetPrefix() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAssetPrefix());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getManufac() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getManufac());
        }
        if (entity.getParts() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getParts());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getLocation());
        }
        if (entity.getDateMade() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getDateMade());
        }
        if (entity.getDateBuy() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getDateBuy());
        }
        final int _tmp = entity.isDel() ? 1 : 0;
        statement.bindLong(9, _tmp);
        if (entity.getImage() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getImage());
        }
        if (entity.getFarmId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getFarmId());
        }
        if (entity.getSyncId() == null) {
          statement.bindNull(12);
        } else {
          statement.bindLong(12, entity.getSyncId());
        }
        statement.bindString(13, entity.getUid());
      }
    };
    this.__preparedStmtOfDeleteSync = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM ASSET_SYNC WHERE uid = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAsset(final Asset[] asset, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAsset.insert(asset);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSync(final AssetSync[] sync, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAssetSync.insert(sync);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertVehicle(final Vehicle[] vehicle,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVehicle.insert(vehicle);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSmallEquipment(final SmallEquipment[] smallEquipment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSmallEquipment.insert(smallEquipment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertLargeEquipment(final LargeEquipment[] largeEquipment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLargeEquipment.insert(largeEquipment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAsset(final Asset asset, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAsset.handle(asset);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAsset(final Asset asset, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAsset.handle(asset);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSync(final String delUid, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSync.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, delUid);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteSync.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public List<AssetModel> getAll() {
    final String _sql = "SELECT * FROM Asset";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfAssetPrefix = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Prefix");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Name");
      final int _cursorIndexOfManufac = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacture");
      final int _cursorIndexOfParts = CursorUtil.getColumnIndexOrThrow(_cursor, "part_List");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfDateMade = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Manufactured");
      final int _cursorIndexOfDateBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Purchased");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Image");
      final int _cursorIndexOfFarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
      final int _cursorIndexOfSyncId = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
      final List<AssetModel> _result = new ArrayList<AssetModel>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final AssetModel _item;
        final UUID _tmpUid;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfUid);
        }
        if (_tmp == null) {
          _tmpUid = null;
        } else {
          _tmpUid = __databaseConverter.uuidFromString(_tmp);
        }
        final String _tmpAssetPrefix;
        if (_cursor.isNull(_cursorIndexOfAssetPrefix)) {
          _tmpAssetPrefix = null;
        } else {
          _tmpAssetPrefix = _cursor.getString(_cursorIndexOfAssetPrefix);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpManufac;
        if (_cursor.isNull(_cursorIndexOfManufac)) {
          _tmpManufac = null;
        } else {
          _tmpManufac = _cursor.getString(_cursorIndexOfManufac);
        }
        final String _tmpParts;
        if (_cursor.isNull(_cursorIndexOfParts)) {
          _tmpParts = null;
        } else {
          _tmpParts = _cursor.getString(_cursorIndexOfParts);
        }
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        final Integer _tmpDateMade;
        if (_cursor.isNull(_cursorIndexOfDateMade)) {
          _tmpDateMade = null;
        } else {
          _tmpDateMade = _cursor.getInt(_cursorIndexOfDateMade);
        }
        final Integer _tmpDateBuy;
        if (_cursor.isNull(_cursorIndexOfDateBuy)) {
          _tmpDateBuy = null;
        } else {
          _tmpDateBuy = _cursor.getInt(_cursorIndexOfDateBuy);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final Integer _tmpFarmId;
        if (_cursor.isNull(_cursorIndexOfFarmId)) {
          _tmpFarmId = null;
        } else {
          _tmpFarmId = _cursor.getInt(_cursorIndexOfFarmId);
        }
        final Integer _tmpSyncId;
        if (_cursor.isNull(_cursorIndexOfSyncId)) {
          _tmpSyncId = null;
        } else {
          _tmpSyncId = _cursor.getInt(_cursorIndexOfSyncId);
        }
        _item = new AssetModel(_tmpUid,_tmpAssetPrefix,_tmpName,_tmpManufac,_tmpParts,_tmpLocation,_tmpDateMade,_tmpDateBuy,_tmpImage,_tmpFarmId,null,null,null,_tmpSyncId,null,null);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssetNetworkModel> getOfflineAssets() {
    final String _sql = "\n"
            + "    SELECT \n"
            + "        asset_sync.uid AS uid,\n"
            + "        Asset.asset_Prefix,\n"
            + "        Asset.asset_Name,\n"
            + "        Asset.manufacture,\n"
            + "        Asset.part_List,\n"
            + "        Asset.location,\n"
            + "        Asset.date_Manufactured,\n"
            + "        Asset.date_Purchased,\n"
            + "        Asset.asset_Image,\n"
            + "        Asset.farm_Id,\n"
            + "        Asset.global_Id,\n"
            + "        asset_sync.synctimestamp,\n"
            + "        Large_Equipment.vin AS largeEquipmentVin,  -- Alias for the vin from Large_Equipment\n"
            + "        small_Equipment.serial_Number,\n"
            + "        Vehicles.vin AS vehicleVin,  -- Alias for the vin from Vehicles\n"
            + "        Vehicles.registration\n"
            + "    FROM ASSET_SYNC \n"
            + "    INNER JOIN Asset ON asset_sync.uid = Asset.uid\n"
            + "    LEFT JOIN Large_Equipment ON asset_sync.uid = Large_Equipment.uid\n"
            + "    LEFT JOIN small_Equipment ON asset_sync.uid = small_Equipment.uid\n"
            + "    LEFT JOIN Vehicles ON asset_sync.uid = Vehicles.uid\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = 0;
      final int _cursorIndexOfAssetPrefix = 1;
      final int _cursorIndexOfName = 2;
      final int _cursorIndexOfManufac = 3;
      final int _cursorIndexOfParts = 4;
      final int _cursorIndexOfLocation = 5;
      final int _cursorIndexOfDateMade = 6;
      final int _cursorIndexOfDateBuy = 7;
      final int _cursorIndexOfImage = 8;
      final int _cursorIndexOfFarmId = 9;
      final int _cursorIndexOfSyncId = 10;
      final int _cursorIndexOfSynctime = 11;
      final int _cursorIndexOfLargeEquipmentVin = 12;
      final int _cursorIndexOfSerialNo = 13;
      final int _cursorIndexOfVehicleVin = 14;
      final int _cursorIndexOfReg = 15;
      final List<AssetNetworkModel> _result = new ArrayList<AssetNetworkModel>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final AssetNetworkModel _item;
        final String _tmpUid;
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _tmpUid = null;
        } else {
          _tmpUid = _cursor.getString(_cursorIndexOfUid);
        }
        final String _tmpAssetPrefix;
        if (_cursor.isNull(_cursorIndexOfAssetPrefix)) {
          _tmpAssetPrefix = null;
        } else {
          _tmpAssetPrefix = _cursor.getString(_cursorIndexOfAssetPrefix);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpManufac;
        if (_cursor.isNull(_cursorIndexOfManufac)) {
          _tmpManufac = null;
        } else {
          _tmpManufac = _cursor.getString(_cursorIndexOfManufac);
        }
        final String _tmpParts;
        if (_cursor.isNull(_cursorIndexOfParts)) {
          _tmpParts = null;
        } else {
          _tmpParts = _cursor.getString(_cursorIndexOfParts);
        }
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        final Integer _tmpDateMade;
        if (_cursor.isNull(_cursorIndexOfDateMade)) {
          _tmpDateMade = null;
        } else {
          _tmpDateMade = _cursor.getInt(_cursorIndexOfDateMade);
        }
        final Integer _tmpDateBuy;
        if (_cursor.isNull(_cursorIndexOfDateBuy)) {
          _tmpDateBuy = null;
        } else {
          _tmpDateBuy = _cursor.getInt(_cursorIndexOfDateBuy);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final Integer _tmpFarmId;
        if (_cursor.isNull(_cursorIndexOfFarmId)) {
          _tmpFarmId = null;
        } else {
          _tmpFarmId = _cursor.getInt(_cursorIndexOfFarmId);
        }
        final Integer _tmpSyncId;
        if (_cursor.isNull(_cursorIndexOfSyncId)) {
          _tmpSyncId = null;
        } else {
          _tmpSyncId = _cursor.getInt(_cursorIndexOfSyncId);
        }
        final String _tmpSynctime;
        _tmpSynctime = _cursor.getString(_cursorIndexOfSynctime);
        final Integer _tmpLargeEquipmentVin;
        if (_cursor.isNull(_cursorIndexOfLargeEquipmentVin)) {
          _tmpLargeEquipmentVin = null;
        } else {
          _tmpLargeEquipmentVin = _cursor.getInt(_cursorIndexOfLargeEquipmentVin);
        }
        final Integer _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getInt(_cursorIndexOfSerialNo);
        }
        final Integer _tmpVehicleVin;
        if (_cursor.isNull(_cursorIndexOfVehicleVin)) {
          _tmpVehicleVin = null;
        } else {
          _tmpVehicleVin = _cursor.getInt(_cursorIndexOfVehicleVin);
        }
        final Integer _tmpReg;
        if (_cursor.isNull(_cursorIndexOfReg)) {
          _tmpReg = null;
        } else {
          _tmpReg = _cursor.getInt(_cursorIndexOfReg);
        }
        _item = new AssetNetworkModel(_tmpUid,_tmpAssetPrefix,_tmpName,_tmpManufac,_tmpParts,_tmpLocation,_tmpDateMade,_tmpDateBuy,_tmpImage,_tmpFarmId,_tmpLargeEquipmentVin,_tmpVehicleVin,_tmpSerialNo,_tmpReg,_tmpSyncId,_tmpSynctime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getBySyncId(final int syncId, final Continuation<? super Asset> $completion) {
    final String _sql = "SELECT * FROM Asset WHERE global_Id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, syncId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Asset>() {
      @Override
      @Nullable
      public Asset call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfAssetPrefix = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Prefix");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Name");
          final int _cursorIndexOfManufac = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacture");
          final int _cursorIndexOfParts = CursorUtil.getColumnIndexOrThrow(_cursor, "part_List");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDateMade = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Manufactured");
          final int _cursorIndexOfDateBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Purchased");
          final int _cursorIndexOfIsDel = CursorUtil.getColumnIndexOrThrow(_cursor, "is_Delete");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Image");
          final int _cursorIndexOfFarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
          final int _cursorIndexOfSyncId = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
          final Asset _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpAssetPrefix;
            if (_cursor.isNull(_cursorIndexOfAssetPrefix)) {
              _tmpAssetPrefix = null;
            } else {
              _tmpAssetPrefix = _cursor.getString(_cursorIndexOfAssetPrefix);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpManufac;
            if (_cursor.isNull(_cursorIndexOfManufac)) {
              _tmpManufac = null;
            } else {
              _tmpManufac = _cursor.getString(_cursorIndexOfManufac);
            }
            final String _tmpParts;
            if (_cursor.isNull(_cursorIndexOfParts)) {
              _tmpParts = null;
            } else {
              _tmpParts = _cursor.getString(_cursorIndexOfParts);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final Integer _tmpDateMade;
            if (_cursor.isNull(_cursorIndexOfDateMade)) {
              _tmpDateMade = null;
            } else {
              _tmpDateMade = _cursor.getInt(_cursorIndexOfDateMade);
            }
            final Integer _tmpDateBuy;
            if (_cursor.isNull(_cursorIndexOfDateBuy)) {
              _tmpDateBuy = null;
            } else {
              _tmpDateBuy = _cursor.getInt(_cursorIndexOfDateBuy);
            }
            final boolean _tmpIsDel;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDel);
            _tmpIsDel = _tmp != 0;
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final Integer _tmpFarmId;
            if (_cursor.isNull(_cursorIndexOfFarmId)) {
              _tmpFarmId = null;
            } else {
              _tmpFarmId = _cursor.getInt(_cursorIndexOfFarmId);
            }
            final Integer _tmpSyncId;
            if (_cursor.isNull(_cursorIndexOfSyncId)) {
              _tmpSyncId = null;
            } else {
              _tmpSyncId = _cursor.getInt(_cursorIndexOfSyncId);
            }
            _result = new Asset(_tmpUid,_tmpAssetPrefix,_tmpName,_tmpManufac,_tmpParts,_tmpLocation,_tmpDateMade,_tmpDateBuy,_tmpIsDel,_tmpImage,_tmpFarmId,_tmpSyncId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public List<AssetModel> getAllLargeEquipment() {
    final String _sql = "SELECT * FROM Asset INNER JOIN Large_Equipment ON Asset.uid = Large_Equipment.uid;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfAssetPrefix = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Prefix");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Name");
      final int _cursorIndexOfManufac = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacture");
      final int _cursorIndexOfParts = CursorUtil.getColumnIndexOrThrow(_cursor, "part_List");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfDateMade = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Manufactured");
      final int _cursorIndexOfDateBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Purchased");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Image");
      final int _cursorIndexOfFarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
      final int _cursorIndexOfSyncId = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
      final int _cursorIndexOfVin = CursorUtil.getColumnIndexOrThrow(_cursor, "vin");
      final List<AssetModel> _result = new ArrayList<AssetModel>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final AssetModel _item;
        final UUID _tmpUid;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfUid);
        }
        if (_tmp == null) {
          _tmpUid = null;
        } else {
          _tmpUid = __databaseConverter.uuidFromString(_tmp);
        }
        final String _tmpAssetPrefix;
        if (_cursor.isNull(_cursorIndexOfAssetPrefix)) {
          _tmpAssetPrefix = null;
        } else {
          _tmpAssetPrefix = _cursor.getString(_cursorIndexOfAssetPrefix);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpManufac;
        if (_cursor.isNull(_cursorIndexOfManufac)) {
          _tmpManufac = null;
        } else {
          _tmpManufac = _cursor.getString(_cursorIndexOfManufac);
        }
        final String _tmpParts;
        if (_cursor.isNull(_cursorIndexOfParts)) {
          _tmpParts = null;
        } else {
          _tmpParts = _cursor.getString(_cursorIndexOfParts);
        }
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        final Integer _tmpDateMade;
        if (_cursor.isNull(_cursorIndexOfDateMade)) {
          _tmpDateMade = null;
        } else {
          _tmpDateMade = _cursor.getInt(_cursorIndexOfDateMade);
        }
        final Integer _tmpDateBuy;
        if (_cursor.isNull(_cursorIndexOfDateBuy)) {
          _tmpDateBuy = null;
        } else {
          _tmpDateBuy = _cursor.getInt(_cursorIndexOfDateBuy);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final Integer _tmpFarmId;
        if (_cursor.isNull(_cursorIndexOfFarmId)) {
          _tmpFarmId = null;
        } else {
          _tmpFarmId = _cursor.getInt(_cursorIndexOfFarmId);
        }
        final Integer _tmpSyncId;
        if (_cursor.isNull(_cursorIndexOfSyncId)) {
          _tmpSyncId = null;
        } else {
          _tmpSyncId = _cursor.getInt(_cursorIndexOfSyncId);
        }
        final Integer _tmpVin;
        if (_cursor.isNull(_cursorIndexOfVin)) {
          _tmpVin = null;
        } else {
          _tmpVin = _cursor.getInt(_cursorIndexOfVin);
        }
        _item = new AssetModel(_tmpUid,_tmpAssetPrefix,_tmpName,_tmpManufac,_tmpParts,_tmpLocation,_tmpDateMade,_tmpDateBuy,_tmpImage,_tmpFarmId,_tmpVin,null,null,_tmpSyncId,null,null);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssetModel> getAllSmallEquipment() {
    final String _sql = "SELECT * FROM Asset INNER JOIN small_Equipment ON Asset.uid = small_Equipment.uid;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfAssetPrefix = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Prefix");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Name");
      final int _cursorIndexOfManufac = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacture");
      final int _cursorIndexOfParts = CursorUtil.getColumnIndexOrThrow(_cursor, "part_List");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfDateMade = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Manufactured");
      final int _cursorIndexOfDateBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Purchased");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Image");
      final int _cursorIndexOfFarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
      final int _cursorIndexOfSyncId = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "serial_Number");
      final List<AssetModel> _result = new ArrayList<AssetModel>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final AssetModel _item;
        final UUID _tmpUid;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfUid);
        }
        if (_tmp == null) {
          _tmpUid = null;
        } else {
          _tmpUid = __databaseConverter.uuidFromString(_tmp);
        }
        final String _tmpAssetPrefix;
        if (_cursor.isNull(_cursorIndexOfAssetPrefix)) {
          _tmpAssetPrefix = null;
        } else {
          _tmpAssetPrefix = _cursor.getString(_cursorIndexOfAssetPrefix);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpManufac;
        if (_cursor.isNull(_cursorIndexOfManufac)) {
          _tmpManufac = null;
        } else {
          _tmpManufac = _cursor.getString(_cursorIndexOfManufac);
        }
        final String _tmpParts;
        if (_cursor.isNull(_cursorIndexOfParts)) {
          _tmpParts = null;
        } else {
          _tmpParts = _cursor.getString(_cursorIndexOfParts);
        }
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        final Integer _tmpDateMade;
        if (_cursor.isNull(_cursorIndexOfDateMade)) {
          _tmpDateMade = null;
        } else {
          _tmpDateMade = _cursor.getInt(_cursorIndexOfDateMade);
        }
        final Integer _tmpDateBuy;
        if (_cursor.isNull(_cursorIndexOfDateBuy)) {
          _tmpDateBuy = null;
        } else {
          _tmpDateBuy = _cursor.getInt(_cursorIndexOfDateBuy);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final Integer _tmpFarmId;
        if (_cursor.isNull(_cursorIndexOfFarmId)) {
          _tmpFarmId = null;
        } else {
          _tmpFarmId = _cursor.getInt(_cursorIndexOfFarmId);
        }
        final Integer _tmpSyncId;
        if (_cursor.isNull(_cursorIndexOfSyncId)) {
          _tmpSyncId = null;
        } else {
          _tmpSyncId = _cursor.getInt(_cursorIndexOfSyncId);
        }
        final Integer _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getInt(_cursorIndexOfSerialNo);
        }
        _item = new AssetModel(_tmpUid,_tmpAssetPrefix,_tmpName,_tmpManufac,_tmpParts,_tmpLocation,_tmpDateMade,_tmpDateBuy,_tmpImage,_tmpFarmId,null,_tmpSerialNo,null,_tmpSyncId,null,null);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssetModel> getAllVehicles() {
    final String _sql = "SELECT * FROM Asset INNER JOIN Vehicles ON Asset.uid = Vehicles.uid;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfAssetPrefix = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Prefix");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Name");
      final int _cursorIndexOfManufac = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacture");
      final int _cursorIndexOfParts = CursorUtil.getColumnIndexOrThrow(_cursor, "part_List");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfDateMade = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Manufactured");
      final int _cursorIndexOfDateBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "date_Purchased");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Image");
      final int _cursorIndexOfFarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
      final int _cursorIndexOfSyncId = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
      final int _cursorIndexOfVin = CursorUtil.getColumnIndexOrThrow(_cursor, "vin");
      final int _cursorIndexOfReg = CursorUtil.getColumnIndexOrThrow(_cursor, "registration");
      final List<AssetModel> _result = new ArrayList<AssetModel>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final AssetModel _item;
        final UUID _tmpUid;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfUid)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfUid);
        }
        if (_tmp == null) {
          _tmpUid = null;
        } else {
          _tmpUid = __databaseConverter.uuidFromString(_tmp);
        }
        final String _tmpAssetPrefix;
        if (_cursor.isNull(_cursorIndexOfAssetPrefix)) {
          _tmpAssetPrefix = null;
        } else {
          _tmpAssetPrefix = _cursor.getString(_cursorIndexOfAssetPrefix);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpManufac;
        if (_cursor.isNull(_cursorIndexOfManufac)) {
          _tmpManufac = null;
        } else {
          _tmpManufac = _cursor.getString(_cursorIndexOfManufac);
        }
        final String _tmpParts;
        if (_cursor.isNull(_cursorIndexOfParts)) {
          _tmpParts = null;
        } else {
          _tmpParts = _cursor.getString(_cursorIndexOfParts);
        }
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        final Integer _tmpDateMade;
        if (_cursor.isNull(_cursorIndexOfDateMade)) {
          _tmpDateMade = null;
        } else {
          _tmpDateMade = _cursor.getInt(_cursorIndexOfDateMade);
        }
        final Integer _tmpDateBuy;
        if (_cursor.isNull(_cursorIndexOfDateBuy)) {
          _tmpDateBuy = null;
        } else {
          _tmpDateBuy = _cursor.getInt(_cursorIndexOfDateBuy);
        }
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        final Integer _tmpFarmId;
        if (_cursor.isNull(_cursorIndexOfFarmId)) {
          _tmpFarmId = null;
        } else {
          _tmpFarmId = _cursor.getInt(_cursorIndexOfFarmId);
        }
        final Integer _tmpSyncId;
        if (_cursor.isNull(_cursorIndexOfSyncId)) {
          _tmpSyncId = null;
        } else {
          _tmpSyncId = _cursor.getInt(_cursorIndexOfSyncId);
        }
        final Integer _tmpVin;
        if (_cursor.isNull(_cursorIndexOfVin)) {
          _tmpVin = null;
        } else {
          _tmpVin = _cursor.getInt(_cursorIndexOfVin);
        }
        final Integer _tmpReg;
        if (_cursor.isNull(_cursorIndexOfReg)) {
          _tmpReg = null;
        } else {
          _tmpReg = _cursor.getInt(_cursorIndexOfReg);
        }
        _item = new AssetModel(_tmpUid,_tmpAssetPrefix,_tmpName,_tmpManufac,_tmpParts,_tmpLocation,_tmpDateMade,_tmpDateBuy,_tmpImage,_tmpFarmId,_tmpVin,null,_tmpReg,_tmpSyncId,null,null);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getActiveOperationsByUUid(final String uid,
      final Continuation<? super List<Operations>> $completion) {
    final String _sql = "SELECT * FROM Operations WHERE Asset_Id = ? AND End_Date_Time IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, uid);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Operations>>() {
      @Override
      @NonNull
      public List<Operations> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "Log_id");
          final int _cursorIndexOfSyncId = CursorUtil.getColumnIndexOrThrow(_cursor, "Global_id");
          final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "Start_Date_Time");
          final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "End_Date_Time");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "Location");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "Notes");
          final int _cursorIndexOfIsDelete = CursorUtil.getColumnIndexOrThrow(_cursor, "isDelete");
          final int _cursorIndexOfAssetUid = CursorUtil.getColumnIndexOrThrow(_cursor, "Asset_Id");
          final int _cursorIndexOfUserid = CursorUtil.getColumnIndexOrThrow(_cursor, "User_ID");
          final List<Operations> _result = new ArrayList<Operations>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Operations _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final Integer _tmpSyncId;
            if (_cursor.isNull(_cursorIndexOfSyncId)) {
              _tmpSyncId = null;
            } else {
              _tmpSyncId = _cursor.getInt(_cursorIndexOfSyncId);
            }
            final String _tmpStart;
            _tmpStart = _cursor.getString(_cursorIndexOfStart);
            final String _tmpEnd;
            if (_cursor.isNull(_cursorIndexOfEnd)) {
              _tmpEnd = null;
            } else {
              _tmpEnd = _cursor.getString(_cursorIndexOfEnd);
            }
            final String _tmpLocation;
            _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final boolean _tmpIsDelete;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDelete);
            _tmpIsDelete = _tmp != 0;
            final String _tmpAssetUid;
            _tmpAssetUid = _cursor.getString(_cursorIndexOfAssetUid);
            final String _tmpUserid;
            _tmpUserid = _cursor.getString(_cursorIndexOfUserid);
            _item = new Operations(_tmpUid,_tmpSyncId,_tmpStart,_tmpEnd,_tmpLocation,_tmpNotes,_tmpIsDelete,_tmpAssetUid,_tmpUserid);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
