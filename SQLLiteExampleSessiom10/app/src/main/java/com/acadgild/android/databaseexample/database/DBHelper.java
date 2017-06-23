package com.acadgild.android.databaseexample.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.acadgild.android.databaseexample.model.BookData;
import com.acadgild.android.databaseexample.utils.Constants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by AdityaDua on 16/06/17.
 */

public class DBHelper {
    private SQLiteDatabase db;
    private final Context context;
    private final TablesClass dbHelper;
    private static DBHelper db_helper=null;
    private static int no;
    public static DBHelper getInstance(Context context){

        try {
            if (db_helper == null) {
                db_helper = new DBHelper(context);
            }
        }catch (Exception e){
            Log.i("DB Already Open","");
        }
        return db_helper;
    }

    public DBHelper(Context c){
        context=c;
        dbHelper=new TablesClass(context, Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
    }

    /**
     * Open a Database
     */
    public void open(){
        try{
            db=dbHelper.getWritableDatabase();
        }catch (Exception e){
            Log.e("Error while opening DB","Error below");
            e.printStackTrace();
            db=dbHelper.getReadableDatabase();
        }

    }

    /**
     * Close a Database
     */
    public void close(){
        if(db.isOpen()){
            db.close();
        }
    }
    /**
     * To check if Database is Open...
     */
    public boolean dbOpenCheck(){
        try{
            return db.isOpen();
        }catch (Exception e){
            return  false;
        }
    }
    /**
     * Inserting Values in DB
     * Android came up with the concept of ContentValues
     * for each column , you have a key value pair mapping
     * for ex :
     *
     * Name : insert inot database
     * I will create a Content Values object ::
     * cv.put("name","Aditya");
     * cv.put("age",25);
     */
    public long insertContentValues(String tabName, ContentValues content){
        long id=0;

        try{
            db.beginTransaction();
            id=db.insert(tabName,null,content);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
        return id;
    }
    /**
     * To select the Row : cursors
     */

    public Cursor getTableRecords(String tablename,String[] columns,String where,String orderby){
        Cursor cursor = db.query(false,tablename,columns,where,null,null,null,orderby,null);
        return  cursor;
    }
    /**
     * Return the count of all elements in the table.
     */
    public int getFullCount(String table,String where){
        Cursor cursor = db.query(false,table,null,where,null,null,null,null,null);

        try{
            if(cursor!=null){
                cursor.moveToFirst();
                no=cursor.getCount();
                cursor.close();
            }
        }finally {
            cursor.close();
        }
        return no;
    }
    /**
     * Delete a Row
     */
    public void deleteRecords(String table,String whereClause,String[] whereArgs){
        try{

            db.beginTransaction();
            db.delete(table,whereClause,whereArgs);
            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
    }

    /**
     * Get a Row based on where clause.
     */
    public String getValue(String table,String column,String where){
        // select * from student where rollNo=1 orderby Id;
        /**
         *  distinct : false
         *  column=null
         *  where
         *  selectionargs=rollNo value
         *  groupby = null
         *  having = null
         *
         */

        Cursor result=db.query(false,table,new String[] {column},where,null,null,null,Constants.ID,null);

        String value ="";

        if(result.moveToFirst()){
            value=result.getString(0);
        }else{
            return null;
        }
        return value;
    }

    /**
     * Get Multiple Values
     */

    public String[] getValues(boolean distinct,String table,String column,String where,
                          String orderBy){

        ArrayList<String> savedAns=new ArrayList<String>();
        Cursor result;
        String[] y;
        result=db.query(distinct,table,new String [] {column},where,null,null,null,orderBy,null);
        /**
         * Whenever we perform DB operation in Java ,
         * we always move to first element to start iterating
         */

        if(result.moveToFirst()){
            do {
                savedAns.add(result.getString(result.getColumnIndex(column)));
            }while(result.moveToNext());
        }else{
            return null;

        }
        y=savedAns.toArray(new String[result.getCount()]);
        return y;
    }

    public int updateRecords(String table, ContentValues values,String whereClause,String[] whereArgs){
        /** How many Rows have been updated  ?**/
        int a=0;
        try{
            db.beginTransaction();
            a=db.update(table,values,whereClause,whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();

        }
        finally {
            db.endTransaction();
        }
        return a;
    }
    /**
     * Fetch the entire BookData
     */
    public List<BookData> getAllBooks(){
        List<BookData> books=new LinkedList<BookData>();

        String query = "SELECT * FROM "+Constants.BOOK_RECORD;

        Cursor cursor=db.rawQuery(query,null);

        BookData book= null;

        if(cursor.moveToFirst()){
            do{
                book=new BookData();
                book.setId(cursor.getString(0).toString());
                book.setAuthorName(cursor.getString(1));
                book.setBookId(cursor.getString(2));
                book.setBookName(cursor.getString(3));

                books.add(book);
            }while(cursor.moveToNext());
        }


        return books;
    }
}
