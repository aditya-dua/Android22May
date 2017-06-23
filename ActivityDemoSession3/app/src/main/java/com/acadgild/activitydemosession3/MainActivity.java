package com.acadgild.activitydemosession3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"In Oncreate() method",Toast.LENGTH_LONG).show();

        TextView hwTextView = (TextView)findViewById(R.id.textView);
        hwTextView.setText("Text Changed by Aditya");
        hwTextView.setTextColor(getResources().getColor(R.color.colorPrimary));


    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"In OnPause() method",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"In OnStart() method",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"In OnResume() method",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"In OnRestart() method",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"In OnStop() method",Toast.LENGTH_LONG).show();
        onDestroy();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"In OnDestroy() method",Toast.LENGTH_LONG).show();
       // Toast.makeText(getApplicationContext(),"In OnDestroy() method",Toast.LENGTH_LONG).show();

    }
}
