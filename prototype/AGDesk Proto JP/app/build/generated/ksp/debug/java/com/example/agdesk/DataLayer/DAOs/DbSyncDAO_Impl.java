package com.example.agdesk.DataLayer.DAOs;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.agdesk.DataLayer.entities.sync.DbSync;
import com.example.agdesk.models.networkModels.SyncRequest;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DbSyncDAO_Impl implements DbSyncDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DbSync> __insertionAdapterOfDbSync;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncTimestamp;

  public DbSyncDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDbSync = new EntityInsertionAdapter<DbSync>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `DbSync` (`dbInfoId`,`lastSyncTimeStamp`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DbSync entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getSynctime());
      }
    };
    this.__preparedStmtOfUpdateSyncTimestamp = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE DbSync SET lastSyncTimeStamp = ? WHERE dbInfoId = 1";
        return _query;
      }
    };
  }

  @Override
  public Object insertSyncInfo(final DbSync dbSync, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDbSync.insert(dbSync);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSyncTimestamp(final String timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncTimestamp.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, timestamp);
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
          __preparedStmtOfUpdateSyncTimestamp.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getLastSyncInfo(final Continuation<? super SyncRequest> $completion) {
    final String _sql = "SELECT * FROM DbSync WHERE dbInfoId = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SyncRequest>() {
      @Override
      @Nullable
      public SyncRequest call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLastSyncTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTimeStamp");
          final SyncRequest _result;
          if (_cursor.moveToFirst()) {
            final Long _tmpLastSyncTimeStamp;
            if (_cursor.isNull(_cursorIndexOfLastSyncTimeStamp)) {
              _tmpLastSyncTimeStamp = null;
            } else {
              _tmpLastSyncTimeStamp = _cursor.getLong(_cursorIndexOfLastSyncTimeStamp);
            }
            _result = new SyncRequest(_tmpLastSyncTimeStamp);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
