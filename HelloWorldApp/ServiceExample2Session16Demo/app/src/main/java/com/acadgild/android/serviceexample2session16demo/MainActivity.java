package com.acadgild.android.serviceexample2session16demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start,stop;
        start=(Button)findViewById(R.id.button);
        stop=(Button)findViewById(R.id.button2);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       switch(v.getId()){
           case R.id.button :
               Intent i = new Intent(MainActivity.this,MyService.class);
                    startService(i);
                            break;
           case R.id.button2 :
               Intent stop = new Intent(MainActivity.this,MyService.class);
                    stopService(stop);
                            break;
           default:
                        break;
       }
    }
}
