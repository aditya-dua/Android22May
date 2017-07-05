package com.acadgild.android.simplethreadexamplesession15;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap mBitmap;
    private int delay = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        Button btn = (Button)findViewById(R.id.loadbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage();
            }
        });
        Button btn1=(Button) findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"It's Working",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadImage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mBitmap  = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(mBitmap);
                    }
                });
            }
        }).start();
    }
}
