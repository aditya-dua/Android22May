package com.acadgild.menuexamplesession8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button optnBtn = (Button)findViewById(R.id.optionMenuButton);
        optnBtn.setOnClickListener(this);

        Button conBtn=(Button)findViewById(R.id.contextMenuButton);
        conBtn.setOnClickListener(this);

        Button toolBtn=(Button)findViewById(R.id.toolbutton);
        toolBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.optionMenuButton :
                Intent optionIntent = new Intent(getApplicationContext(),OptionMenu.class);
                startActivity(optionIntent);
                break;
            case R.id.contextMenuButton :
                Intent contextIntent=new Intent(getApplicationContext(),ContextMenu.class);
                startActivity(contextIntent);
            case R.id.toolbutton:
                Toast.makeText(getApplicationContext(),"In ToolBar",Toast.LENGTH_SHORT).show();
                Intent toolbarIntent=new Intent(getApplicationContext(),ToolbarClass.class);
                startActivity(toolbarIntent);
            default:
                break;

        }
    }
}
