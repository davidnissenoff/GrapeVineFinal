package com.example.davidnissenoff.grapevine6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbOperations extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "post_info.db";
    private static final String CREATE_QUERY = "create table " + PostContract.PostEntry.TABLE_NAME +
            "("+ PostContract.PostEntry.NAME+ " text,"+ PostContract.PostEntry.PRICE+" integer,"+
            PostContract.PostEntry.POST+" text);";

    DbOperations(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("Database operations", "Database created...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created...");
    }
    public void addInformations(SQLiteDatabase db, String name, int price, String post){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PostContract.PostEntry.NAME, name);
        contentValues.put(PostContract.PostEntry.PRICE, price);
        contentValues.put(PostContract.PostEntry.POST, post);
        db.insert(PostContract.PostEntry.TABLE_NAME, null, contentValues);
        Log.d("Database operations", "One row inserted...");
    }
    public Cursor getInformations(SQLiteDatabase db){
        String[] projections = {PostContract.PostEntry.NAME, PostContract.PostEntry.PRICE, PostContract.PostEntry.POST};
        Cursor cursor = db.query(PostContract.PostEntry.TABLE_NAME, projections, null, null, null, null, null);

        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
