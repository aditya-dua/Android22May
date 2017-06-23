package com.acadgild.intentdemosession6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 05/06/17.
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        /**
         * Here Intent will create a object of the intent that called this activity.
         * and will show help me fetch all the Key Value pairs that were saved in the previous applciation
         *
         */
        Intent intent=getIntent();
        String UserName= intent.getStringExtra("userName");
        String role=intent.getStringExtra("role");
        if(role.equals("Mentor")){
            TextView textView = (TextView)findViewById(R.id.textView2);
            textView.setText("User : "+UserName+"  Role :"+role);

        }

        else
        {
            Toast.makeText(getApplicationContext(),"Login Success ! ",Toast.LENGTH_LONG).show();
        }

        String userString=intent.getExtras().getString("UName");
        int age=intent.getExtras().getInt("age");
        Toast.makeText(getApplicationContext(),"UserName :"+userString+" age :"+age,Toast.LENGTH_LONG).show();


    }
}
