package com.example.davidnissenoff.grapevine6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.davidnissenoff.grapevine6.PostContract.PostEntry.ITEM;
import static com.example.davidnissenoff.grapevine6.PostContract.PostEntry.NAME;
import static com.example.davidnissenoff.grapevine6.PostContract.PostEntry.POST;
import static com.example.davidnissenoff.grapevine6.PostContract.PostEntry.PRICE;
import static com.example.davidnissenoff.grapevine6.PostContract.PostEntry.TABLE_NAME;

public class DbOperations extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "post_info.db";
    private static final String KEY_ID = "_id";
    private SQLiteDatabase sqLiteDatabase;
    private static final String CREATE_QUERY = "create table " + TABLE_NAME +
            "("+ KEY_ID + " integer primary key autoincrement," + NAME+ " text,"+ PostContract.PostEntry.PRICE+" integer,"+
            PostContract.PostEntry.POST+" text," + ITEM +" text);";

    DbOperations(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("Database operations", "Database created...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created...");
    }
    public void addInformations(SQLiteDatabase db, String name, int price, String post, String item){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(PostContract.PostEntry.PRICE, price);
        contentValues.put(PostContract.PostEntry.POST, post);
        contentValues.put(ITEM, item);
        db.insert(TABLE_NAME, null, contentValues);
        Log.d("Database operations", "One row inserted...");
    }

    public Cursor getInformations(SQLiteDatabase db){
        String[] projections = {NAME, PostContract.PostEntry.PRICE, PostContract.PostEntry.POST, ITEM};
        Cursor cursor = db.query(TABLE_NAME, projections, null, null, null, null, null);

        return cursor;
    }
    public void delete_byID(long id){
        sqLiteDatabase.delete(TABLE_NAME, KEY_ID+"="+id, null);
    }
    public void deleteFrom(String del){

        sqLiteDatabase.execSQL("delete from " + TABLE_NAME + KEY_ID + del);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
