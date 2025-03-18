package com.example.agdesk.DataLayer.DAOs;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.example.agdesk.DataLayer.entities.Asset;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AssetDAO_Impl implements AssetDAO {
  private final RoomDatabase __db;

  public AssetDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public List<Asset> getAll() {
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
      final int _cursorIndexOfIsDel = CursorUtil.getColumnIndexOrThrow(_cursor, "is_Delete");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "asset_Image");
      final int _cursorIndexOfFarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
      final int _cursorIndexOfSyncId = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
      final List<Asset> _result = new ArrayList<Asset>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Asset _item;
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
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
        _item = new Asset(_tmpUid,_tmpAssetPrefix,_tmpName,_tmpManufac,_tmpParts,_tmpLocation,_tmpDateMade,_tmpDateBuy,_tmpIsDel,_tmpImage,_tmpFarmId,_tmpSyncId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
