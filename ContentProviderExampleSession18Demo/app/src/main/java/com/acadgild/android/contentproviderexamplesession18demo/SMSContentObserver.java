package com.acadgild.android.contentproviderexamplesession18demo;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by AdityaDua on 10/07/17.
 */

public class SMSContentObserver  extends ContentObserver{

    Context context;
    Handler handler;
    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public SMSContentObserver( Context context,Handler handler) {
        super(handler);
        this.context=context;
        this.handler=handler;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);

        Toast.makeText(context,"In On change",Toast.LENGTH_LONG).show();

        Uri uri=Uri.parse("content://sms/inbox");

        Cursor cursor = context.getContentResolver().query(uri,null,null,null,"date ASC");

        if(cursor !=null){
           // Log.i("Total count",Integer.toString(cursor.getCount()));
           // Toast.makeText(context,cursor.getCount(),Toast.LENGTH_LONG).show();
            StringBuilder builder = new StringBuilder();
            //cursor.moveToFirst();
            cursor.moveToLast();
                builder.append
                        ("Sender Number ::"+cursor.getString(cursor.getColumnIndex("address")));
                builder.append
                        ("Message ::"+cursor.getString(cursor.getColumnIndex("body"))+"\n");


            cursor.close();
            String str = builder.toString();

            handler.obtainMessage(1,str).sendToTarget();

        }
    }
}
