package com.acadgild.menuexamplesession8;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by AdityaDua on 12/06/17.
 */

public class ToolbarClass extends AppCompatActivity{

    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_toolbar);
        loadToolbar();
    }

    public void loadToolbar(){
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("My First ToolBar");
        toolbar.setSubtitle("SubTitle");
       // setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* to navigate back to the previous activity if you want */
               // Intent
                Toast.makeText(getApplicationContext(),"Clicked the toolbar",Toast.LENGTH_LONG).show();
            }
        });

    }
}
