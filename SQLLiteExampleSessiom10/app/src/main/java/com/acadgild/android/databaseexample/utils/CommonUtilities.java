package com.acadgild.android.databaseexample.utils;

import android.content.Context;

import com.acadgild.android.databaseexample.database.DBHelper;
import com.acadgild.android.databaseexample.database.TablesClass;

/**
 * Created by AdityaDua on 16/06/17.
 */

public class CommonUtilities {

    /**
     * If it would have been Java , we would have , created DB connection , closed
     * existing connection and so-on..
     * But here this work is manged by SQL Lite itself..
     * object of DB Helper => Singleton Class
     *
     */

    /**
     * Bank : 1 transaction which transferring x amount from a's to b's.
     * 1 Method to get the connection.
     * DBHelper : Singleton : Design Pattern
     * Those classes which can have only 1 object.
     * X x = new X();
     * if this class is not able to access X();
     *
     * @param mContext
     * @return
     */

    public static DBHelper getDBObject(Context mContext){
        DBHelper dbHelper = DBHelper.getInstance(mContext);
        return dbHelper;
    }


}
