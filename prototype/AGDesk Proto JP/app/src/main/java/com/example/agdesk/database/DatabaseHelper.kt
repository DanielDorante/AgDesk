package com.example.agdesk.database

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.agdesk.models.FieldsModel
import com.example.agdesk.models.InventoryModel
import com.example.agdesk.models.TaskModel
import com.google.android.gms.maps.model.LatLng
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import android.content.ContentValues
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.UserModel


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "agdesk.db"
        private const val DATABASE_VERSION = 1

        // User table
        private const val TABLE_USERS = "users"
        private const val COLUMN_USER_ID = "user_id"
        private const val COLUMN_USER_NAME = "user_name"
        private const val COLUMN_USER_EMAIL = "user_email"
        private const val COLUMN_USER_PASSWORD = "user_password"

        // Fields table
        private const val TABLE_FIELDS = "fields"
        private const val COLUMN_ID = "id"
        private const val FIELD_USER_ID = "field_user_id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_POINTS = "points"

        // Tasks table
        private const val TABLE_TASKS = "tasks"
        private const val COLUMN_TASK_ID = "task_id"
        private const val TASK_USER_ID = "task_user_id"
        private const val COLUMN_TASK_NAME = "task_name"
        private const val COLUMN_TASK_DATE = "task_date"
        private const val COLUMN_TASK_TIME = "task_time"

        // Inside the companion object inventory
        private const val TABLE_INVENTORY = "inventory"
        private const val COLUMN_INVENTORY_ID = "inventory_id"
        private const val INVENTORY_USER_ID = "inventory_user_id"
        private const val COLUMN_INVENTORY_NAME = "inventory_name"
        private const val COLUMN_INVENTORY_QUANTITY = "inventory_quantity"

        // Asset table
        private const val TABLE_ASSETS = "assets"
        private const val COLUMN_ASSET_ID = "id"
        private const val COLUMN_ASSET_PREFIX = "assetPrefix"
        private const val COLUMN_ASSET_NAME = "name"
        private const val COLUMN_ASSET_MANUFAC = "manufac"
        private const val COLUMN_ASSET_PARTS = "parts"
        private const val COLUMN_ASSET_LOCATION = "location"
        private const val COLUMN_ASSET_DATE_MADE = "dateMade"
        private const val COLUMN_ASSET_DATE_BUY = "dateBuy"
        private const val COLUMN_ASSET_IMAGE = "image"
        private const val COLUMN_ASSET_FARM_ID = "farmId"
        private const val COLUMN_ASSET_VIN = "vin"
        private const val COLUMN_ASSET_SERIAL_NO = "serialNo"
        private const val COLUMN_ASSET_REG = "reg"
        private const val COLUMN_ASSET_SYNC_ID = "syncId"
        private const val COLUMN_ASSET_CHECKOUT_STATUS = "checkoutStatus"
        private const val COLUMN_ASSET_CHECKOUT_BY = "checkoutBy"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Create Users table
        val createUserTable = "CREATE TABLE $TABLE_USERS (" +
                "$COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USER_NAME TEXT, " +
                "$COLUMN_USER_EMAIL TEXT UNIQUE, " +
                "$COLUMN_USER_PASSWORD TEXT)"
        db?.execSQL(createUserTable)

        // Create Fields table
        val createFieldsTable = "CREATE TABLE $TABLE_FIELDS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$FIELD_USER_ID INTEGER, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_POINTS TEXT)"
        db?.execSQL(createFieldsTable)

        // Create Tasks table
        val createTasksTable = "CREATE TABLE $TABLE_TASKS (" +
                "$COLUMN_TASK_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$TASK_USER_ID INTEGER, " +
                "$COLUMN_TASK_NAME TEXT, " +
                "$COLUMN_TASK_DATE TEXT, " +
                "$COLUMN_TASK_TIME TEXT)"
        db?.execSQL(createTasksTable)

        // Create Inventory table
        val createInventoryTable = "CREATE TABLE $TABLE_INVENTORY (" +
                "$COLUMN_INVENTORY_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$INVENTORY_USER_ID INTEGER, " +
                "$COLUMN_INVENTORY_NAME TEXT, " +
                "$COLUMN_INVENTORY_QUANTITY TEXT)"
        db?.execSQL(createInventoryTable)

        val createAssetTable = "CREATE TABLE $TABLE_ASSETS (" +
                "$COLUMN_ASSET_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_ASSET_PREFIX TEXT, " +
                "$COLUMN_ASSET_NAME TEXT, " +
                "$COLUMN_ASSET_MANUFAC TEXT, " +
                "$COLUMN_ASSET_PARTS TEXT, " +
                "$COLUMN_ASSET_LOCATION TEXT, " +
                "$COLUMN_ASSET_DATE_MADE INTEGER, " +
                "$COLUMN_ASSET_DATE_BUY INTEGER, " +
                "$COLUMN_ASSET_IMAGE TEXT, " +
                "$COLUMN_ASSET_FARM_ID INTEGER, " +
                "$COLUMN_ASSET_VIN INTEGER, " +
                "$COLUMN_ASSET_SERIAL_NO INTEGER, " +
                "$COLUMN_ASSET_REG INTEGER, " +
                "$COLUMN_ASSET_SYNC_ID INTEGER, " +
                "$COLUMN_ASSET_CHECKOUT_STATUS INTEGER, " + // 0 = false, 1 = true
                "$COLUMN_ASSET_CHECKOUT_BY TEXT)"
        db?.execSQL(createAssetTable)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_FIELDS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TASKS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_INVENTORY")
        onCreate(db)
    }

    // Method to add a new user to the database
    fun createUser(user: UserModel): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_USER_NAME, user.name)
            put(COLUMN_USER_EMAIL, user.email)
            put(COLUMN_USER_PASSWORD, user.password)
        }
        val result = db.insert(TABLE_USERS, null, values)
        db.close()
        return result // returns the row ID of the newly inserted row, or -1 if an error occurred
    }

    // Method to retrieve all users from the database
    @SuppressLint("Range")
    fun getAllUsers(): List<UserModel> {
        val users = mutableListOf<UserModel>()
        val db = readableDatabase
        val cursor = db.query(TABLE_USERS, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME))
                val email = cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL))
                val password = cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD))
                users.add(UserModel(id, name, email, password))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return users
    }

    // Fields operations
    fun saveField(userId: String, name: String, points: List<LatLng>) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(FIELD_USER_ID, userId)
            put(COLUMN_NAME, name)
            put(COLUMN_POINTS, points.joinToString(";") { "${it.latitude},${it.longitude}" })
        }
        db.insert(TABLE_FIELDS, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getFields(userId: String): List<FieldsModel> {
        val fields = mutableListOf<FieldsModel>()
        val db = readableDatabase
        val cursor = db.query(TABLE_FIELDS, arrayOf(COLUMN_NAME, COLUMN_POINTS), "$FIELD_USER_ID=?", arrayOf(userId), null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val pointsString = cursor.getString(cursor.getColumnIndex(COLUMN_POINTS))
                val points = pointsString.split(";").map {
                    val latLng = it.split(",")
                    LatLng(latLng[0].toDouble(), latLng[1].toDouble())
                }
                fields.add(FieldsModel(name, userId, points.toMutableList()))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return fields
    }

    // Task operations

    // Add a task to the database
    fun addTask(userId: String, name: String, date: String, time: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(TASK_USER_ID, userId)
            put(COLUMN_TASK_NAME, name)
            put(COLUMN_TASK_DATE, date)
            put(COLUMN_TASK_TIME, time)
        }
        db.insert(TABLE_TASKS, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllTasks(userId: String): List<TaskModel> {
        val tasks = mutableListOf<TaskModel>()
        val db = readableDatabase
        val cursor = db.query(TABLE_TASKS, null, "$TASK_USER_ID=?", arrayOf(userId), null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_TASK_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_NAME))
                val date = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DATE))
                val time = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_TIME))
                tasks.add(TaskModel(id, userId, name, date, time))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return tasks
    }

    // Get weekly tasks
    @SuppressLint("Range")
    fun getWeeklyTasks(userId: String): List<TaskModel> {
        val tasks = mutableListOf<TaskModel>()
        val db = readableDatabase

        // Get the current date and the date 7 days from now
        val calendar = Calendar.getInstance()
        val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)

        calendar.add(Calendar.DAY_OF_YEAR, 7)
        val nextWeekDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)

        // Query for tasks between the current date and 7 days later for the given userId
        val cursor = db.query(
            TABLE_TASKS,
            null,
            "$TASK_USER_ID=? AND $COLUMN_TASK_DATE BETWEEN ? AND ?",
            arrayOf(userId, currentDate, nextWeekDate),
            null,
            null,
            null
        )

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_TASK_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_NAME))
                val date = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DATE))
                val time = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_TIME))
                tasks.add(TaskModel(id, userId, name, date, time))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return tasks
    }


    // Get monthly tasks
    @SuppressLint("Range")
    fun getMonthlyTasks(userId: String): List<TaskModel> {
        val tasks = mutableListOf<TaskModel>()
        val db = readableDatabase

        // Get the current date and the date 30 days from now
        val calendar = Calendar.getInstance()
        val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)

        calendar.add(Calendar.DAY_OF_YEAR, 30)
        val nextMonthDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)

        // Query for tasks between the current date and 30 days later for the given userId
        val cursor = db.query(
            TABLE_TASKS,
            null,
            "$TASK_USER_ID=? AND $COLUMN_TASK_DATE BETWEEN ? AND ?",
            arrayOf(userId, currentDate, nextMonthDate),
            null,
            null,
            null
        )

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_TASK_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_NAME))
                val date = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DATE))
                val time = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_TIME))
                tasks.add(TaskModel(id, userId, name, date, time))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return tasks
    }


    // Inventory operations
    fun addInventory(inventory: InventoryModel): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(INVENTORY_USER_ID, inventory.userId)
            put(COLUMN_INVENTORY_NAME, inventory.name)
            put(COLUMN_INVENTORY_QUANTITY, inventory.quantity)
        }
        val result = db.insert(TABLE_INVENTORY, null, values)
        db.close()
        return result;
    }

    @SuppressLint("Range")
    fun getAllInventories(userId: String): List<InventoryModel> {
        val inventories = mutableListOf<InventoryModel>()
        val db = readableDatabase
        val cursor = db.query(TABLE_INVENTORY, null, "$INVENTORY_USER_ID=?", arrayOf(userId), null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_INVENTORY_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_INVENTORY_NAME))
                val quantity = cursor.getString(cursor.getColumnIndex(COLUMN_INVENTORY_QUANTITY))
                inventories.add(InventoryModel(id, userId, name, quantity))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return inventories
    }

    fun insertAsset(asset: AssetModel): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_ASSET_PREFIX, asset.assetPrefix)
            put(COLUMN_ASSET_NAME, asset.name)
            put(COLUMN_ASSET_MANUFAC, asset.manufac)
            put(COLUMN_ASSET_PARTS, asset.parts)
            put(COLUMN_ASSET_LOCATION, asset.location)
            put(COLUMN_ASSET_DATE_MADE, asset.dateMade)
            put(COLUMN_ASSET_DATE_BUY, asset.dateBuy)
            put(COLUMN_ASSET_IMAGE, asset.image)
            put(COLUMN_ASSET_FARM_ID, asset.farmId)
            put(COLUMN_ASSET_VIN, asset.vin)
            put(COLUMN_ASSET_SERIAL_NO, asset.serialNo)
            put(COLUMN_ASSET_REG, asset.reg)
            put(COLUMN_ASSET_SYNC_ID, asset.syncId)
            put(COLUMN_ASSET_CHECKOUT_STATUS, if (asset.checkoutStatus == true) 1 else 0)
            put(COLUMN_ASSET_CHECKOUT_BY, asset.checkoutBy)
        }
        val result = db.insert(TABLE_ASSETS, null, values)
        db.close()
        return result
    }

    @SuppressLint("Range")
    fun getAllAssets(): List<AssetModel> {
        val assets = mutableListOf<AssetModel>()
        val db = readableDatabase
        val cursor = db.query(TABLE_ASSETS, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val asset = AssetModel(
                    id = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_ID)),
                    assetPrefix = cursor.getString(cursor.getColumnIndex(COLUMN_ASSET_PREFIX)),
                    name = cursor.getString(cursor.getColumnIndex(COLUMN_ASSET_NAME)),
                    manufac = cursor.getString(cursor.getColumnIndex(COLUMN_ASSET_MANUFAC)),
                    parts = cursor.getString(cursor.getColumnIndex(COLUMN_ASSET_PARTS)),
                    location = cursor.getString(cursor.getColumnIndex(COLUMN_ASSET_LOCATION)),
                    dateMade = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_DATE_MADE)),
                    dateBuy = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_DATE_BUY)),
                    image = cursor.getString(cursor.getColumnIndex(COLUMN_ASSET_IMAGE)),
                    farmId = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_FARM_ID)),
                    vin = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_VIN)),
                    serialNo = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_SERIAL_NO)),
                    reg = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_REG)),
                    syncId = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_SYNC_ID)),
                    checkoutStatus = cursor.getInt(cursor.getColumnIndex(COLUMN_ASSET_CHECKOUT_STATUS)) == 1,
                    checkoutBy = cursor.getString(cursor.getColumnIndex(COLUMN_ASSET_CHECKOUT_BY))
                )
                assets.add(asset)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return assets
    }

    fun updateAsset(asset: AssetModel): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_ASSET_PREFIX, asset.assetPrefix)
            put(COLUMN_ASSET_NAME, asset.name)
            put(COLUMN_ASSET_MANUFAC, asset.manufac)
            put(COLUMN_ASSET_PARTS, asset.parts)
            put(COLUMN_ASSET_LOCATION, asset.location)
            put(COLUMN_ASSET_DATE_MADE, asset.dateMade)
            put(COLUMN_ASSET_DATE_BUY, asset.dateBuy)
            put(COLUMN_ASSET_IMAGE, asset.image)
            put(COLUMN_ASSET_FARM_ID, asset.farmId)
            put(COLUMN_ASSET_VIN, asset.vin)
            put(COLUMN_ASSET_SERIAL_NO, asset.serialNo)
            put(COLUMN_ASSET_REG, asset.reg)
            put(COLUMN_ASSET_SYNC_ID, asset.syncId)
            put(COLUMN_ASSET_CHECKOUT_STATUS, if (asset.checkoutStatus == true) 1 else 0)
            put(COLUMN_ASSET_CHECKOUT_BY, asset.checkoutBy)
        }

        val result = db.update(
            TABLE_ASSETS,
            values,
            "$COLUMN_ASSET_ID=?",
            arrayOf(asset.id.toString())
        )
        db.close()
        return result // returns number of rows affected
    }


}