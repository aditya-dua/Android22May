package com.acadgild.android.databaseexample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.webkit.ConsoleMessage;

import com.acadgild.android.databaseexample.utils.Constants;

/**
 * Created by AdityaDua on 16/06/17.
 */
public class TablesClass extends SQLiteOpenHelper {

    /** Create table command go here:: Context  **/
    Context context;

    public TablesClass(Context context, String name, String nullCoumnHack, int version) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table1="CREATE TABLE IF NOT EXISTS "+
                Constants.BOOK_RECORD+"("+
                Constants.ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                Constants.BOOK_ID+" TEXT, "+
                Constants.BOOK_NAME+" TEXT, "+
                Constants.BOOK_AUTHOR+" TEXT)";
        Log.i("Query for Table ::",table1);
        db.execSQL(table1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
