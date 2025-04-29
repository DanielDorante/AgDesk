package com.example.agdesk.DataLayer.DAOs;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.agdesk.DataLayer.entities.InventoryItem;
import com.example.agdesk.DataLayer.entities.Supplier;
import com.example.agdesk.DataLayer.entities.sync.InventorySync;
import com.example.agdesk.models.InventoryModel;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
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
public final class InventoryDAO_Impl implements InventoryDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InventoryItem> __insertionAdapterOfInventoryItem;

  private final EntityInsertionAdapter<InventorySync> __insertionAdapterOfInventorySync;

  private final EntityDeletionOrUpdateAdapter<InventoryItem> __deletionAdapterOfInventoryItem;

  private final EntityDeletionOrUpdateAdapter<InventoryItem> __updateAdapterOfInventoryItem;

  public InventoryDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInventoryItem = new EntityInsertionAdapter<InventoryItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `InventoryItem` (`uid`,`item_Name`,`stock_Keeping_Unit`,`category`,`quantity`,`cost_Price`,`sell_Price`,`global_Id`,`name`,`email`,`phone`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InventoryItem entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getSku() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getSku());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getQuantity() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getQuantity());
        }
        if (entity.getCostPrice() == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.getCostPrice());
        }
        if (entity.getSalePrice() == null) {
          statement.bindNull(7);
        } else {
          statement.bindDouble(7, entity.getSalePrice());
        }
        if (entity.getSyncid() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getSyncid());
        }
        final Supplier _tmpSupplier = entity.getSupplier();
        if (_tmpSupplier != null) {
          if (_tmpSupplier.getName() == null) {
            statement.bindNull(9);
          } else {
            statement.bindString(9, _tmpSupplier.getName());
          }
          if (_tmpSupplier.getEmail() == null) {
            statement.bindNull(10);
          } else {
            statement.bindString(10, _tmpSupplier.getEmail());
          }
          if (_tmpSupplier.getPhone() == null) {
            statement.bindNull(11);
          } else {
            statement.bindLong(11, _tmpSupplier.getPhone());
          }
        } else {
          statement.bindNull(9);
          statement.bindNull(10);
          statement.bindNull(11);
        }
      }
    };
    this.__insertionAdapterOfInventorySync = new EntityInsertionAdapter<InventorySync>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `inventory_Sync` (`uid`,`synctimestamp`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InventorySync entity) {
        statement.bindString(1, entity.getUid());
        statement.bindString(2, entity.getSynctime());
      }
    };
    this.__deletionAdapterOfInventoryItem = new EntityDeletionOrUpdateAdapter<InventoryItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `InventoryItem` WHERE `uid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InventoryItem entity) {
        statement.bindString(1, entity.getUid());
      }
    };
    this.__updateAdapterOfInventoryItem = new EntityDeletionOrUpdateAdapter<InventoryItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `InventoryItem` SET `uid` = ?,`item_Name` = ?,`stock_Keeping_Unit` = ?,`category` = ?,`quantity` = ?,`cost_Price` = ?,`sell_Price` = ?,`global_Id` = ?,`name` = ?,`email` = ?,`phone` = ? WHERE `uid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InventoryItem entity) {
        statement.bindString(1, entity.getUid());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getSku() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getSku());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getQuantity() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getQuantity());
        }
        if (entity.getCostPrice() == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.getCostPrice());
        }
        if (entity.getSalePrice() == null) {
          statement.bindNull(7);
        } else {
          statement.bindDouble(7, entity.getSalePrice());
        }
        if (entity.getSyncid() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getSyncid());
        }
        final Supplier _tmpSupplier = entity.getSupplier();
        if (_tmpSupplier != null) {
          if (_tmpSupplier.getName() == null) {
            statement.bindNull(9);
          } else {
            statement.bindString(9, _tmpSupplier.getName());
          }
          if (_tmpSupplier.getEmail() == null) {
            statement.bindNull(10);
          } else {
            statement.bindString(10, _tmpSupplier.getEmail());
          }
          if (_tmpSupplier.getPhone() == null) {
            statement.bindNull(11);
          } else {
            statement.bindLong(11, _tmpSupplier.getPhone());
          }
        } else {
          statement.bindNull(9);
          statement.bindNull(10);
          statement.bindNull(11);
        }
        statement.bindString(12, entity.getUid());
      }
    };
  }

  @Override
  public Object Insert(final InventoryItem inventoryItem,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInventoryItem.insert(inventoryItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSync(final InventorySync[] sync,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInventorySync.insert(sync);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteItem(final InventoryItem inventoryItem,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfInventoryItem.handle(inventoryItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateItem(final InventoryItem inventoryItem,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfInventoryItem.handle(inventoryItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<InventoryModel>> $completion) {
    final String _sql = "SELECT * FROM InventoryItem";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<InventoryModel>>() {
      @Override
      @NonNull
      public List<InventoryModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "item_Name");
          final int _cursorIndexOfSku = CursorUtil.getColumnIndexOrThrow(_cursor, "stock_Keeping_Unit");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfCostPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "cost_Price");
          final int _cursorIndexOfSalePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "sell_Price");
          final int _cursorIndexOfSyncid = CursorUtil.getColumnIndexOrThrow(_cursor, "global_Id");
          final int _cursorIndexOfName_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final List<InventoryModel> _result = new ArrayList<InventoryModel>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final InventoryModel _item;
            final String _tmpUid;
            if (_cursor.isNull(_cursorIndexOfUid)) {
              _tmpUid = null;
            } else {
              _tmpUid = _cursor.getString(_cursorIndexOfUid);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Integer _tmpSku;
            if (_cursor.isNull(_cursorIndexOfSku)) {
              _tmpSku = null;
            } else {
              _tmpSku = _cursor.getInt(_cursorIndexOfSku);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
            }
            final Double _tmpCostPrice;
            if (_cursor.isNull(_cursorIndexOfCostPrice)) {
              _tmpCostPrice = null;
            } else {
              _tmpCostPrice = _cursor.getDouble(_cursorIndexOfCostPrice);
            }
            final Double _tmpSalePrice;
            if (_cursor.isNull(_cursorIndexOfSalePrice)) {
              _tmpSalePrice = null;
            } else {
              _tmpSalePrice = _cursor.getDouble(_cursorIndexOfSalePrice);
            }
            final Integer _tmpSyncid;
            if (_cursor.isNull(_cursorIndexOfSyncid)) {
              _tmpSyncid = null;
            } else {
              _tmpSyncid = _cursor.getInt(_cursorIndexOfSyncid);
            }
            final com.example.agdesk.models.Supplier _tmpSupplier;
            if (!(_cursor.isNull(_cursorIndexOfName_1) && _cursor.isNull(_cursorIndexOfEmail) && _cursor.isNull(_cursorIndexOfPhone))) {
              final String _tmpName_1;
              if (_cursor.isNull(_cursorIndexOfName_1)) {
                _tmpName_1 = null;
              } else {
                _tmpName_1 = _cursor.getString(_cursorIndexOfName_1);
              }
              final String _tmpEmail;
              if (_cursor.isNull(_cursorIndexOfEmail)) {
                _tmpEmail = null;
              } else {
                _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
              }
              final Integer _tmpPhone;
              if (_cursor.isNull(_cursorIndexOfPhone)) {
                _tmpPhone = null;
              } else {
                _tmpPhone = _cursor.getInt(_cursorIndexOfPhone);
              }
              _tmpSupplier = new com.example.agdesk.models.Supplier(_tmpName_1,_tmpEmail,_tmpPhone);
            } else {
              _tmpSupplier = null;
            }
            _item = new InventoryModel(_tmpUid,_tmpName,_tmpSku,_tmpCategory,_tmpQuantity,_tmpCostPrice,_tmpSalePrice,_tmpSupplier,_tmpSyncid);
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
