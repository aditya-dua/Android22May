package com.acadgild.sendsmsruntimepermissionsession13;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextPhone,editTextMessage;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone =(EditText)findViewById(R.id.editText);
        editTextMessage=(EditText)findViewById(R.id.editText2);
        tv = (TextView)findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(editTextPhone.getText().toString(),null,editTextMessage.getText().toString(),null,null);
                tv.setText("SMS Send !!!");
            }
        });

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"Permission Not granted , Requesting",Toast.LENGTH_LONG).show();

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},123);
            button.setEnabled(false);
        }else {
            Toast.makeText(getApplicationContext(),"Permission granted !",Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==123){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                tv.setText("Permission Granted , Please click Send!");
                button.setEnabled(true);
            }else{
                tv.setText("Permission Not Granted");
                button.setEnabled(false);
            }

        }

    }
}
