package com.acadgild.sharedprefexamplesession11;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.StringSearch;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // I need the name : to be set over here
    // Objects of all my views

    SharedPreferences sharedPreferences;
    EditText name,email;

    public static final String mypreference="mypref";
    public static final String Name="nameKey";
    public static final String Email="emailKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =(EditText) findViewById(R.id.editText);
        email=(EditText) findViewById(R.id.editText2);
        Button save=(Button)findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Saved Clicked",Toast.LENGTH_SHORT).show();
                String n=name.getText().toString();
                String e=email.getText().toString();

                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(Name,n);
                editor.putString(Email,e);
                editor.commit();
                Toast.makeText(getApplicationContext(),"SP Saved",Toast.LENGTH_SHORT).show();

            }
        });
        Button reset=(Button)findViewById(R.id.button2);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Reset Clicked",Toast.LENGTH_SHORT).show();
                name=(EditText)findViewById(R.id.editText);
                name.setText("");

                email=(EditText)findViewById(R.id.editText2);
                email.setText("");

            }
        });

        Button retrive=(Button)findViewById(R.id.button3);
        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Retriving Values Clicked",Toast.LENGTH_SHORT).show();
                name =(EditText) findViewById(R.id.editText);
                email=(EditText) findViewById(R.id.editText2);

                sharedPreferences =getSharedPreferences(mypreference, Context.MODE_PRIVATE);

                if(sharedPreferences.contains(Name) && sharedPreferences.contains(Email)){
                    TextView tv = (TextView)findViewById(R.id.textView);
                    tv.setText("Name : "+sharedPreferences.getString(Name,"")+
                            "Email :"+sharedPreferences.getString(Email,"")
                    );

                }

            }
        });
        sharedPreferences =getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(Name)){
            TextView tv = (TextView)findViewById(R.id.textView);
            tv.setText("Hi "+sharedPreferences.getString(Name,null)+",");
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));
        }

    }




}
