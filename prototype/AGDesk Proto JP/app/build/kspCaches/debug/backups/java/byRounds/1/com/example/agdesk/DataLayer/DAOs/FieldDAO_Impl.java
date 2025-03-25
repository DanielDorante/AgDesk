package com.example.agdesk.DataLayer.DAOs;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.agdesk.DataLayer.Converters.DatabaseConverter;
import com.example.agdesk.DataLayer.entities.Fields;
import com.example.agdesk.DataLayer.entities.sync.FieldSync;
import com.example.agdesk.models.FieldsModel;
import com.google.android.gms.maps.model.LatLng;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FieldDAO_Impl implements FieldDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Fields> __insertionAdapterOfFields;

  private final DatabaseConverter __databaseConverter = new DatabaseConverter();

  private final EntityInsertionAdapter<FieldSync> __insertionAdapterOfFieldSync;

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
        statement.bindString(1, entity.getUid());
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
    this.__insertionAdapterOfFieldSync = new EntityInsertionAdapter<FieldSync>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Field_Sync` (`uid`,`synctimestamp`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FieldSync entity) {
        statement.bindString(1, entity.getUid());
        statement.bindString(2, entity.getSynctime());
      }
    };
  }

  @Override
  public Object insertFields(final Fields[] fields, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFields.insert(fields);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSync(final FieldSync[] sync, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFieldSync.insert(sync);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllFields(final Continuation<? super List<FieldsModel>> $completion) {
    final String _sql = "SELECT name, points FROM Fields";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<FieldsModel>>() {
      @Override
      @NonNull
      public List<FieldsModel> call() throws Exception {
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
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
