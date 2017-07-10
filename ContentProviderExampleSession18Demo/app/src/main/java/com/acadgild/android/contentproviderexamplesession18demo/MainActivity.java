package com.acadgild.android.contentproviderexamplesession18demo;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SMSContentObserver contentObserver;
    TextView tv_number , tv_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_number =(TextView) findViewById(R.id.textView2);
        tv_message=(TextView)findViewById(R.id.textView3);
        contentObserver =new SMSContentObserver(this,handler);
        Uri uri= Uri.parse("content://sms");
        getContentResolver().registerContentObserver(uri,true,contentObserver);

    }
    Handler handler = new Handler(){

        public  void handleMessage(android.os.Message msg){
            switch (msg.what){
                case 1 :
                    String str = (String) msg.obj;
                    tv_message.setText(str);
                    break;
                default: break;
            }
        };
    };
}
