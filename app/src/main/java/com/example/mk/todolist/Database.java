package com.example.mk.todolist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mk on 8/16/2016.
 */
public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ToDoList.db";

    //Table Varaibles
    public static final String TABLE_NAME = "todolist";
    public static final String COLUMN_NAME_ENTRY_ID = "TaskID";
    public static final String COLUMN_NAME_TaskName = "TaskName";
    public static final String COLUMN_NAME_Description = "Description";
    public static final String COLUMN_NAME_Date = "Date";
    public static final String COLUMN_NAME_Improtance = "Improtance";


    //Create DB SQL

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Database.TABLE_NAME + " (" +
                    Database.COLUMN_NAME_ENTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    Database.COLUMN_NAME_TaskName + " TEXT" + "," +
                    Database.COLUMN_NAME_Description + " TEXT" + "," +
                    Database.COLUMN_NAME_Date + " TEXT" + "," +
                    Database.COLUMN_NAME_Improtance + " TEXT" +
                    " );";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

        /* TODO : Impelment  methode and modify */



    private void DeleteElementsFromTable(String TaskNAme) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from " + TABLE_NAME + " where " + COLUMN_NAME_TaskName + "='" + TaskNAme + "'");


    }

    public void ReadAllDB() {
        String[] allColumns = {COLUMN_NAME_ENTRY_ID, COLUMN_NAME_TaskName, COLUMN_NAME_Description, COLUMN_NAME_Date, COLUMN_NAME_Improtance};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Database.TABLE_NAME, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            long taskNames = cursor.getColumnIndexOrThrow(COLUMN_NAME_TaskName);
            String s = Long.toString(taskNames);
            Log.d("tagtag", s);
        }


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
