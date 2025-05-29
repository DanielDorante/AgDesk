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
import com.example.agdesk.DataLayer.entities.Task;
import com.example.agdesk.DataLayer.entities.sync.TaskSync;
import com.example.agdesk.models.UIModels.TaskModel;
import com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TaskDAO_Impl implements TaskDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfTask;

  private final EntityInsertionAdapter<TaskSync> __insertionAdapterOfTaskSync;

  private final EntityDeletionOrUpdateAdapter<Task> __deletionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __updateAdapterOfTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSync;

  private final DatabaseConverter __databaseConverter = new DatabaseConverter();

  public TaskDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Task` (`uid`,`taskName`,`description`,`time_stamp`,`is_Delete`,`due_Date`,`expire_Date`,`status`,`priority`,`assigned_To`,`farm_Id`,`global_Id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDesc() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDesc());
        }
        if (entity.getTimestamp() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getTimestamp());
        }
        final Integer _tmp = entity.getDel() == null ? null : (entity.getDel() ? 1 : 0);
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp);
        }
        if (entity.getDue() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getDue());
        }
        if (entity.getExp() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getExp());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getStatus());
        }
        if (entity.getPriority() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getPriority());
        }
        if (entity.getAssigned() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getAssigned());
        }
        if (entity.getFarm() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getFarm());
        }
        if (entity.getSyncid() == null) {
          statement.bindNull(12);
        } else {
          statement.bindLong(12, entity.getSyncid());
        }
      }
    };
    this.__insertionAdapterOfTaskSync = new EntityInsertionAdapter<TaskSync>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `task_sync` (`uid`,`synctimestamp`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TaskSync entity) {
        statement.bindString(1, entity.getUid());
        statement.bindLong(2, entity.getSynctime());
      }
    };
    this.__deletionAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Task` WHERE `uid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        statement.bindString(1, entity.getUid());
      }
    };
    this.__updateAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Task` SET `uid` = ?,`taskName` = ?,`description` = ?,`time_stamp` = ?,`is_Delete` = ?,`due_Date` = ?,`expire_Date` = ?,`status` = ?,`priority` = ?,`assigned_To` = ?,`farm_Id` = ?,`global_Id` = ? WHERE `uid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Task entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDesc() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDesc());
        }
        if (entity.getTimestamp() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getTimestamp());
        }
        final Integer _tmp = entity.getDel() == null ? null : (entity.getDel() ? 1 : 0);
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, _tmp);
        }
        if (entity.getDue() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getDue());
        }
        if (entity.getExp() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getExp());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getStatus());
        }
        if (entity.getPriority() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getPriority());
        }
        if (entity.getAssigned() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getAssigned());
        }
        if (entity.getFarm() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getFarm());
        }
        if (entity.getSyncid() == null) {
          statement.bindNull(12);
        } else {
          statement.bindLong(12, entity.getSyncid());
        }
        statement.bindString(13, entity.getUid());
      }
    };
    this.__preparedStmtOfDeleteSync = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM task_sync WHERE uid = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertTask(final Task[] task, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTask.insert(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSync(final TaskSync[] sync, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTaskSync.insert(sync);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTask(final Task task, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTask.handle(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTask(final Task task, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTask.handle(task);
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
  public Object getAll(final Continuation<? super List<TaskModel>> $completion) {
    final String _sql = "SELECT * FROM TASK";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TaskModel>>() {
      @Override
      @NonNull
      public List<TaskModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "taskName");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "time_stamp");
          final int _cursorIndexOfDel = CursorUtil.getColumnIndexOrThrow(_cursor, "is_Delete");
          final int _cursorIndexOfDue = CursorUtil.getColumnIndexOrThrow(_cursor, "due_Date");
          final int _cursorIndexOfExp = CursorUtil.getColumnIndexOrThrow(_cursor, "expire_Date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfAssignedId = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_To");
          final int _cursorIndexOfFarm = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
          final List<TaskModel> _result = new ArrayList<TaskModel>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TaskModel _item;
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
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDesc;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmpDesc = null;
            } else {
              _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            }
            final Date _tmpTimestamp;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            if (_tmp_1 == null) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = __databaseConverter.fromUnix(_tmp_1);
            }
            final Boolean _tmpDel;
            final Integer _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDel)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(_cursorIndexOfDel);
            }
            _tmpDel = _tmp_2 == null ? null : _tmp_2 != 0;
            final Date _tmpDue;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfDue)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfDue);
            }
            if (_tmp_3 == null) {
              _tmpDue = null;
            } else {
              _tmpDue = __databaseConverter.fromUnix(_tmp_3);
            }
            final Date _tmpExp;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfExp)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfExp);
            }
            if (_tmp_4 == null) {
              _tmpExp = null;
            } else {
              _tmpExp = __databaseConverter.fromUnix(_tmp_4);
            }
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            final Integer _tmpPriority;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmpPriority = null;
            } else {
              _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            }
            final Long _tmpAssignedId;
            if (_cursor.isNull(_cursorIndexOfAssignedId)) {
              _tmpAssignedId = null;
            } else {
              _tmpAssignedId = _cursor.getLong(_cursorIndexOfAssignedId);
            }
            final Long _tmpFarm;
            if (_cursor.isNull(_cursorIndexOfFarm)) {
              _tmpFarm = null;
            } else {
              _tmpFarm = _cursor.getLong(_cursorIndexOfFarm);
            }
            _item = new TaskModel(_tmpUid,_tmpName,_tmpDesc,_tmpTimestamp,_tmpDel,_tmpDue,_tmpExp,_tmpStatus,_tmpPriority,_tmpAssignedId,null,_tmpFarm);
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

  @Override
  public Object getOfflineTasks(final Continuation<? super List<TaskNetworkModel>> $completion) {
    final String _sql = "SELECT * FROM TASK_SYNC INNER JOIN TASK ON TASK.uid = TASK_SYNC.uid";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TaskNetworkModel>>() {
      @Override
      @NonNull
      public List<TaskNetworkModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfSynctime = CursorUtil.getColumnIndexOrThrow(_cursor, "synctimestamp");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "taskName");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "time_stamp");
          final int _cursorIndexOfIsDel = CursorUtil.getColumnIndexOrThrow(_cursor, "is_Delete");
          final int _cursorIndexOfDue = CursorUtil.getColumnIndexOrThrow(_cursor, "due_Date");
          final int _cursorIndexOfExp = CursorUtil.getColumnIndexOrThrow(_cursor, "expire_Date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfAssignedId = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_To");
          final int _cursorIndexOfFarm = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
          final int _cursorIndexOfSyncId = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
          final List<TaskNetworkModel> _result = new ArrayList<TaskNetworkModel>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TaskNetworkModel _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final Long _tmpSynctime;
            if (_cursor.isNull(_cursorIndexOfSynctime)) {
              _tmpSynctime = null;
            } else {
              _tmpSynctime = _cursor.getLong(_cursorIndexOfSynctime);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDesc;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmpDesc = null;
            } else {
              _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            }
            final Long _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            final Boolean _tmpIsDel;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsDel)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsDel);
            }
            _tmpIsDel = _tmp == null ? null : _tmp != 0;
            final Long _tmpDue;
            if (_cursor.isNull(_cursorIndexOfDue)) {
              _tmpDue = null;
            } else {
              _tmpDue = _cursor.getLong(_cursorIndexOfDue);
            }
            final Long _tmpExp;
            if (_cursor.isNull(_cursorIndexOfExp)) {
              _tmpExp = null;
            } else {
              _tmpExp = _cursor.getLong(_cursorIndexOfExp);
            }
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            final Integer _tmpPriority;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmpPriority = null;
            } else {
              _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            }
            final Long _tmpAssignedId;
            if (_cursor.isNull(_cursorIndexOfAssignedId)) {
              _tmpAssignedId = null;
            } else {
              _tmpAssignedId = _cursor.getLong(_cursorIndexOfAssignedId);
            }
            final Long _tmpFarm;
            if (_cursor.isNull(_cursorIndexOfFarm)) {
              _tmpFarm = null;
            } else {
              _tmpFarm = _cursor.getLong(_cursorIndexOfFarm);
            }
            final Long _tmpSyncId;
            if (_cursor.isNull(_cursorIndexOfSyncId)) {
              _tmpSyncId = null;
            } else {
              _tmpSyncId = _cursor.getLong(_cursorIndexOfSyncId);
            }
            _item = new TaskNetworkModel(_tmpUid,_tmpName,_tmpDesc,_tmpTimestamp,_tmpIsDel,_tmpDue,_tmpExp,_tmpStatus,_tmpPriority,_tmpAssignedId,null,_tmpFarm,_tmpSyncId,_tmpSynctime);
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

  @Override
  public Object getTimeframe(final long timeFrame,
      final Continuation<? super List<TaskModel>> $completion) {
    final String _sql = "SELECT * FROM TASK WHERE due_Date < ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, timeFrame);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TaskModel>>() {
      @Override
      @NonNull
      public List<TaskModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "taskName");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "time_stamp");
          final int _cursorIndexOfDel = CursorUtil.getColumnIndexOrThrow(_cursor, "is_Delete");
          final int _cursorIndexOfDue = CursorUtil.getColumnIndexOrThrow(_cursor, "due_Date");
          final int _cursorIndexOfExp = CursorUtil.getColumnIndexOrThrow(_cursor, "expire_Date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfAssignedId = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_To");
          final int _cursorIndexOfFarm = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
          final List<TaskModel> _result = new ArrayList<TaskModel>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TaskModel _item;
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
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDesc;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmpDesc = null;
            } else {
              _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            }
            final Date _tmpTimestamp;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            if (_tmp_1 == null) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = __databaseConverter.fromUnix(_tmp_1);
            }
            final Boolean _tmpDel;
            final Integer _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDel)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(_cursorIndexOfDel);
            }
            _tmpDel = _tmp_2 == null ? null : _tmp_2 != 0;
            final Date _tmpDue;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfDue)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfDue);
            }
            if (_tmp_3 == null) {
              _tmpDue = null;
            } else {
              _tmpDue = __databaseConverter.fromUnix(_tmp_3);
            }
            final Date _tmpExp;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfExp)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfExp);
            }
            if (_tmp_4 == null) {
              _tmpExp = null;
            } else {
              _tmpExp = __databaseConverter.fromUnix(_tmp_4);
            }
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            final Integer _tmpPriority;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmpPriority = null;
            } else {
              _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            }
            final Long _tmpAssignedId;
            if (_cursor.isNull(_cursorIndexOfAssignedId)) {
              _tmpAssignedId = null;
            } else {
              _tmpAssignedId = _cursor.getLong(_cursorIndexOfAssignedId);
            }
            final Long _tmpFarm;
            if (_cursor.isNull(_cursorIndexOfFarm)) {
              _tmpFarm = null;
            } else {
              _tmpFarm = _cursor.getLong(_cursorIndexOfFarm);
            }
            _item = new TaskModel(_tmpUid,_tmpName,_tmpDesc,_tmpTimestamp,_tmpDel,_tmpDue,_tmpExp,_tmpStatus,_tmpPriority,_tmpAssignedId,null,_tmpFarm);
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

  @Override
  public Object getBySyncId(final long syncId, final Continuation<? super Task> $completion) {
    final String _sql = "SELECT * FROM Task WHERE global_Id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, syncId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Task>() {
      @Override
      @Nullable
      public Task call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "taskName");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "time_stamp");
          final int _cursorIndexOfDel = CursorUtil.getColumnIndexOrThrow(_cursor, "is_Delete");
          final int _cursorIndexOfDue = CursorUtil.getColumnIndexOrThrow(_cursor, "due_Date");
          final int _cursorIndexOfExp = CursorUtil.getColumnIndexOrThrow(_cursor, "expire_Date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfAssigned = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_To");
          final int _cursorIndexOfFarm = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
          final int _cursorIndexOfSyncid = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
          final Task _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDesc;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmpDesc = null;
            } else {
              _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            }
            final Long _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            final Boolean _tmpDel;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfDel)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfDel);
            }
            _tmpDel = _tmp == null ? null : _tmp != 0;
            final Long _tmpDue;
            if (_cursor.isNull(_cursorIndexOfDue)) {
              _tmpDue = null;
            } else {
              _tmpDue = _cursor.getLong(_cursorIndexOfDue);
            }
            final Long _tmpExp;
            if (_cursor.isNull(_cursorIndexOfExp)) {
              _tmpExp = null;
            } else {
              _tmpExp = _cursor.getLong(_cursorIndexOfExp);
            }
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            final Integer _tmpPriority;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmpPriority = null;
            } else {
              _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            }
            final Long _tmpAssigned;
            if (_cursor.isNull(_cursorIndexOfAssigned)) {
              _tmpAssigned = null;
            } else {
              _tmpAssigned = _cursor.getLong(_cursorIndexOfAssigned);
            }
            final Long _tmpFarm;
            if (_cursor.isNull(_cursorIndexOfFarm)) {
              _tmpFarm = null;
            } else {
              _tmpFarm = _cursor.getLong(_cursorIndexOfFarm);
            }
            final Long _tmpSyncid;
            if (_cursor.isNull(_cursorIndexOfSyncid)) {
              _tmpSyncid = null;
            } else {
              _tmpSyncid = _cursor.getLong(_cursorIndexOfSyncid);
            }
            _result = new Task(_tmpUid,_tmpName,_tmpDesc,_tmpTimestamp,_tmpDel,_tmpDue,_tmpExp,_tmpStatus,_tmpPriority,_tmpAssigned,_tmpFarm,_tmpSyncid);
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
  public Object getByUid(final String uid, final Continuation<? super Task> $completion) {
    final String _sql = "SELECT * FROM Task WHERE uid = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, uid);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Task>() {
      @Override
      @Nullable
      public Task call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "taskName");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "time_stamp");
          final int _cursorIndexOfDel = CursorUtil.getColumnIndexOrThrow(_cursor, "is_Delete");
          final int _cursorIndexOfDue = CursorUtil.getColumnIndexOrThrow(_cursor, "due_Date");
          final int _cursorIndexOfExp = CursorUtil.getColumnIndexOrThrow(_cursor, "expire_Date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfAssigned = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_To");
          final int _cursorIndexOfFarm = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
          final int _cursorIndexOfSyncid = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
          final Task _result;
          if (_cursor.moveToFirst()) {
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDesc;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmpDesc = null;
            } else {
              _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            }
            final Long _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            final Boolean _tmpDel;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfDel)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfDel);
            }
            _tmpDel = _tmp == null ? null : _tmp != 0;
            final Long _tmpDue;
            if (_cursor.isNull(_cursorIndexOfDue)) {
              _tmpDue = null;
            } else {
              _tmpDue = _cursor.getLong(_cursorIndexOfDue);
            }
            final Long _tmpExp;
            if (_cursor.isNull(_cursorIndexOfExp)) {
              _tmpExp = null;
            } else {
              _tmpExp = _cursor.getLong(_cursorIndexOfExp);
            }
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            final Integer _tmpPriority;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmpPriority = null;
            } else {
              _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            }
            final Long _tmpAssigned;
            if (_cursor.isNull(_cursorIndexOfAssigned)) {
              _tmpAssigned = null;
            } else {
              _tmpAssigned = _cursor.getLong(_cursorIndexOfAssigned);
            }
            final Long _tmpFarm;
            if (_cursor.isNull(_cursorIndexOfFarm)) {
              _tmpFarm = null;
            } else {
              _tmpFarm = _cursor.getLong(_cursorIndexOfFarm);
            }
            final Long _tmpSyncid;
            if (_cursor.isNull(_cursorIndexOfSyncid)) {
              _tmpSyncid = null;
            } else {
              _tmpSyncid = _cursor.getLong(_cursorIndexOfSyncid);
            }
            _result = new Task(_tmpUid,_tmpName,_tmpDesc,_tmpTimestamp,_tmpDel,_tmpDue,_tmpExp,_tmpStatus,_tmpPriority,_tmpAssigned,_tmpFarm,_tmpSyncid);
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
  public Object getUserTasks(final int id,
      final Continuation<? super List<TaskModel>> $completion) {
    final String _sql = "SELECT * FROM Task WHERE assigned_To = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TaskModel>>() {
      @Override
      @NonNull
      public List<TaskModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "taskName");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "time_stamp");
          final int _cursorIndexOfDel = CursorUtil.getColumnIndexOrThrow(_cursor, "is_Delete");
          final int _cursorIndexOfDue = CursorUtil.getColumnIndexOrThrow(_cursor, "due_Date");
          final int _cursorIndexOfExp = CursorUtil.getColumnIndexOrThrow(_cursor, "expire_Date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfAssignedId = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_To");
          final int _cursorIndexOfFarm = CursorUtil.getColumnIndexOrThrow(_cursor, "farm_Id");
          final List<TaskModel> _result = new ArrayList<TaskModel>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TaskModel _item;
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
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDesc;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmpDesc = null;
            } else {
              _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            }
            final Date _tmpTimestamp;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            if (_tmp_1 == null) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = __databaseConverter.fromUnix(_tmp_1);
            }
            final Boolean _tmpDel;
            final Integer _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDel)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(_cursorIndexOfDel);
            }
            _tmpDel = _tmp_2 == null ? null : _tmp_2 != 0;
            final Date _tmpDue;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfDue)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfDue);
            }
            if (_tmp_3 == null) {
              _tmpDue = null;
            } else {
              _tmpDue = __databaseConverter.fromUnix(_tmp_3);
            }
            final Date _tmpExp;
            final Long _tmp_4;
            if (_cursor.isNull(_cursorIndexOfExp)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getLong(_cursorIndexOfExp);
            }
            if (_tmp_4 == null) {
              _tmpExp = null;
            } else {
              _tmpExp = __databaseConverter.fromUnix(_tmp_4);
            }
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            final Integer _tmpPriority;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmpPriority = null;
            } else {
              _tmpPriority = _cursor.getInt(_cursorIndexOfPriority);
            }
            final Long _tmpAssignedId;
            if (_cursor.isNull(_cursorIndexOfAssignedId)) {
              _tmpAssignedId = null;
            } else {
              _tmpAssignedId = _cursor.getLong(_cursorIndexOfAssignedId);
            }
            final Long _tmpFarm;
            if (_cursor.isNull(_cursorIndexOfFarm)) {
              _tmpFarm = null;
            } else {
              _tmpFarm = _cursor.getLong(_cursorIndexOfFarm);
            }
            _item = new TaskModel(_tmpUid,_tmpName,_tmpDesc,_tmpTimestamp,_tmpDel,_tmpDue,_tmpExp,_tmpStatus,_tmpPriority,_tmpAssignedId,null,_tmpFarm);
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
