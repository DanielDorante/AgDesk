package com.example.agdesk.DataLayer.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.agdesk.models.FieldsModel
import com.example.agdesk.models.InventoryModel
import com.example.agdesk.models.TaskModel
import com.google.android.gms.maps.model.LatLng
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

import com.example.agdesk.DataLayer.Converters.DatabaseConverter

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "fields.db"
        private const val DATABASE_VERSION = 1

        // Fields table
        private const val TABLE_FIELDS = "fields"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_POINTS = "points"

        // Tasks table
        private const val TABLE_TASKS = "tasks"
        private const val COLUMN_TASK_ID = "task_id"
        private const val COLUMN_TASK_NAME = "task_name"
        private const val COLUMN_TASK_DATE = "task_date"
        private const val COLUMN_TASK_TIME = "task_time"

        // Inside the companion object
        private const val TABLE_INVENTORY = "inventory"
        private const val COLUMN_INVENTORY_ID = "inventory_id"
        private const val COLUMN_INVENTORY_NAME = "inventory_name"
        private const val COLUMN_INVENTORY_QUANTITY = "inventory_quantity"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Create Fields table
        val createTable = "CREATE TABLE $TABLE_FIELDS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_POINTS TEXT)"
        db?.execSQL(createTable)

        // Create Tasks table
        val createTasksTable = "CREATE TABLE $TABLE_TASKS (" +
                "$COLUMN_TASK_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_TASK_NAME TEXT, " +
                "$COLUMN_TASK_DATE TEXT, " +
                "$COLUMN_TASK_TIME TEXT)"
        db?.execSQL(createTasksTable)

        // Create Inventory table
        val createInventoryTable = "CREATE TABLE $TABLE_INVENTORY (" +
                "$COLUMN_INVENTORY_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_INVENTORY_NAME TEXT, " +
                "$COLUMN_INVENTORY_QUANTITY TEXT)"
        db?.execSQL(createInventoryTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_FIELDS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TASKS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_INVENTORY")
        onCreate(db)
    }

    // Fields operations
    fun saveField(name: String, points: List<LatLng>) {



        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_POINTS, points.joinToString(";") { "${it.latitude},${it.longitude}" }) // Convert LatLng list to a string




        db.insert(TABLE_FIELDS, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getFields(): List<FieldsModel> {
        val fields = mutableListOf<FieldsModel>()
        val db = readableDatabase
        val cursor = db.query(TABLE_FIELDS, arrayOf(COLUMN_NAME, COLUMN_POINTS), null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val pointsString = cursor.getString(cursor.getColumnIndex(COLUMN_POINTS))
                val points = pointsString.split(";").map {
                    val latLng = it.split(",")
                    LatLng(latLng[0].toDouble(), latLng[1].toDouble())
                }
                fields.add(FieldsModel(name, points.toMutableList()))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return fields
    }

    // Task operations

    // Add a task to the database
    fun addTask(name: String, date: String, time: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TASK_NAME, name)
            put(COLUMN_TASK_DATE, date)
            put(COLUMN_TASK_TIME, time)
        }
        db.insert(TABLE_TASKS, null, values)
        db.close()
    }

    // Get all tasks
    @SuppressLint("Range")
    fun getAllTasks(): List<TaskModel> {
        val tasks = mutableListOf<TaskModel>()
        val db = readableDatabase
        val cursor = db.query(TABLE_TASKS, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_TASK_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_NAME))
                val date = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DATE))
                val time = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_TIME))
                tasks.add(TaskModel(id, name, date, time))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return tasks
    }

    // Get weekly tasks
    @SuppressLint("Range")
    fun getWeeklyTasks(): List<TaskModel> {
        val tasks = mutableListOf<TaskModel>()
        val db = readableDatabase

        // Get the current date and the date 7 days from now
        val calendar = Calendar.getInstance()
        val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)

        calendar.add(Calendar.DAY_OF_YEAR, 7)
        val nextWeekDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)

        // Query for tasks between the current date and 7 days later
        val cursor = db.query(
            TABLE_TASKS,
            null,
            "$COLUMN_TASK_DATE BETWEEN ? AND ?",
            arrayOf(currentDate, nextWeekDate),
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
                tasks.add(TaskModel(id, name, date, time))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return tasks
    }

    // Get monthly tasks
    @SuppressLint("Range")
    fun getMonthlyTasks(): List<TaskModel> {
        val tasks = mutableListOf<TaskModel>()
        val db = readableDatabase

        // Get the current date and the date 30 days from now
        val calendar = Calendar.getInstance()
        val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)

        calendar.add(Calendar.DAY_OF_YEAR, 30)
        val nextMonthDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)

        // Query for tasks between the current date and 30 days later
        val cursor = db.query(
            TABLE_TASKS,
            null,
            "$COLUMN_TASK_DATE BETWEEN ? AND ?",
            arrayOf(currentDate, nextMonthDate),
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
                tasks.add(TaskModel(id, name, date, time))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return tasks
    }

    fun addInventory(inventory: InventoryModel) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_INVENTORY_NAME, inventory.name)
            put(COLUMN_INVENTORY_QUANTITY, inventory.quantity)
        }
        db.insert(TABLE_INVENTORY, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllInventories(): List<InventoryModel> {
        val inventories = mutableListOf<InventoryModel>()
        val db = readableDatabase
        val cursor = db.query(TABLE_INVENTORY, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_INVENTORY_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_INVENTORY_NAME))
                val quantity = cursor.getString(cursor.getColumnIndex(COLUMN_INVENTORY_QUANTITY))
                inventories.add(InventoryModel(id, name, quantity))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return inventories
    }

}
