package com.acadgild.intentdemosession6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openWebPage =(Button)findViewById(R.id.button2);
        openWebPage.setOnClickListener(this);

        Button openActivity=(Button)findViewById(R.id.button);
        openActivity.setOnClickListener(this);

        Button startCam=(Button)findViewById(R.id.button3);
        startCam.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        /**
         * This will be for browser or a viewer
         *
         */
        switch (v.getId()){
            case R.id.button : openSecondActivity();
                                  break;
            case R.id.button2 :
                                EditText url=(EditText)findViewById(R.id.role);
                                String URL="http://www.google.com/#q="+url.getText().toString();
                                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                                startActivity(webIntent);
                                break;
            case R.id.button3 : startCamera();
                                break;

        }

    }

    private void openSecondActivity(){
        Intent openPage= new Intent(MainActivity.this,SecondActivity.class);
        /**
         * To Pass data to another activity I will use the method
         * It will be a KEY and VALUE PAir.
         *
         */
        EditText etRole=(EditText)findViewById(R.id.role);
        openPage.putExtra("userName","Aditya");
        openPage.putExtra("role",etRole.getText().toString());
        /**
         * Using Bundles :::
         */
        Bundle databundle=new Bundle();
        databundle.putString("UName","ACADGILD-USER");
        databundle.putInt("age",12);
        //byte[] image = getResources().getd
        openPage.putExtras(databundle);

        startActivity(openPage);
    }
    private void startCamera(){

        /**
         * START ACTIVITY FOR RESULT :
         * my intent will return something then i will pass startActivityfor Result
         *
         * Catch whatever : camera : image : Video
         * Intent : startActivityForResult
         * => Intent
         * => RequestCode
         *
         * onActivityResult : requestcode :: resultCode and intent
         *
         *ACTION_IMAGE_CAPTURE : ANdroid Team
         * Internal File Storage : For each Application :: Like Whatsapp
         * DownLoad into the users phone
         *
         *
         */
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
       if (requestCode==100 && resultCode==RESULT_OK){
           Bitmap photoImage=(Bitmap) intent.getExtras().get("data");
           ImageView image = (ImageView)findViewById(R.id.imageView);
           image.setImageBitmap(photoImage);
       }
    }
}
