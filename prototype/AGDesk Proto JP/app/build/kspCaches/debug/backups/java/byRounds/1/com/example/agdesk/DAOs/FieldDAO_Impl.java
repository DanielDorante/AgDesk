package com.example.agdesk.DAOs;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.agdesk.Converters.DatabaseConverter;
import com.example.agdesk.entities.Fields;
import com.example.agdesk.models.FieldsModel;
import com.google.android.gms.maps.model.LatLng;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FieldDAO_Impl implements FieldDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Fields> __insertionAdapterOfFields;

  private final DatabaseConverter __databaseConverter = new DatabaseConverter();

  public FieldDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFields = new EntityInsertionAdapter<Fields>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Fields` (`uid`,`name`,`points`,`global_Id`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Fields entity) {
        if (entity.getUid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getUid());
        }
        statement.bindString(2, entity.getName());
        final String _tmp = __databaseConverter.fromLatLng(entity.getPoints());
        statement.bindString(3, _tmp);
        if (entity.getSyncid() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getSyncid());
        }
      }
    };
  }

  @Override
  public void insertFields(final Fields... fields) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFields.insert(fields);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<FieldsModel> getAllFields() {
    final String _sql = "SELECT name, points FROM Fields";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = 0;
      final int _cursorIndexOfPoints = 1;
      final List<FieldsModel> _result = new ArrayList<FieldsModel>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final FieldsModel _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final List<LatLng> _tmpPoints;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfPoints);
        _tmpPoints = __databaseConverter.toLatLng(_tmp);
        _item = new FieldsModel(_tmpName,_tmpPoints);
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
