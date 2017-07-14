package com.acadgild.android.eventhandlingsession23demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userNameEdt,passwordEdt;
    Button loginBtn,resetBtn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //(EditText) => We are typecasting the value of an Interger and converting it to EditText in Java.
        // All the views from XML are saved as an INTEGER value...
        // So we first find the Int value by using the id of the view...
        userNameEdt = (EditText)findViewById(R.id.UserNameeditText);
        passwordEdt = (EditText)findViewById(R.id.passwordeditText);
        textView = (TextView)findViewById(R.id.textView4);
        textView.setVisibility(TextView.INVISIBLE);
        loginBtn = (Button)findViewById(R.id.button);
        resetBtn = (Button)findViewById(R.id.button2);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName= userNameEdt.getText().toString();
                String passWord=passwordEdt.getText().toString();

                if(userName.equalsIgnoreCase("aditya.dua") && passWord.equals("aditya")){
                    Toast.makeText(getApplicationContext(),"Hi "+userName+",\n Welcome",Toast.LENGTH_LONG).show();
                    textView.setVisibility(TextView.VISIBLE);
                    textView.setText("Login Status :: Success");
                    textView.setTextColor(Color.GREEN);
                    Log.i("Login Success","aditya.dua logged INNN");
                }else{
                    passwordEdt.setTextColor(Color.RED);
                    userNameEdt.setTextColor(Color.RED);
                    textView.setVisibility(TextView.VISIBLE);
                    textView.setText("Login Status :: Failure");
                    textView.setTextColor(Color.RED);
                    Log.e("Login Failure","Not Logged IN ! Please check for Network");
                }


            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameEdt.setText("");
                passwordEdt.setText("");
                Toast.makeText(getApplicationContext(),"Text clear ! Please login",Toast.LENGTH_SHORT).show();
            }
        });

        // Listener is ONCLICK =>

        //userNameEdt.setText("UserName Will be entered here");
        //userNameEdt.setTextColor(Color.BLUE);
       // Toast.makeText(getApplicationContext(),userNameEdt.getText().toString()+" Is the Value"
    }
}
