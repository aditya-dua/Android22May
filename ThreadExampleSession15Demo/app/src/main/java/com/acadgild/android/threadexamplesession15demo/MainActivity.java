package com.acadgild.android.threadexamplesession15demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private int mDelay=500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mProgressBar=(ProgressBar)findViewById(R.id.progressBar);

        final Button button = (Button) findViewById(R.id.loadbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button Clicked",Toast.LENGTH_LONG).show();
                new LoadIconTask().execute(R.mipmap.ic_launcher);
            }
        });
        final Button button2 =(Button) findViewById(R.id.otherbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"I'm Working ! ",Toast.LENGTH_LONG).show();

            }
        });

    }

    class LoadIconTask extends AsyncTask<Integer,Integer,Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
            //publishProgress();
        }

        @Override
        protected Bitmap doInBackground(Integer[] params) {
            // dont use buttons , textview or update them from here.
            Bitmap tmp= BitmapFactory.decodeResource(getResources(),params[0]);
            for(int i =1;i<10;i++){
                try {
                    Thread.sleep(mDelay);
                    publishProgress(i*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return tmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mProgressBar.setVisibility(ProgressBar.INVISIBLE);
            mImageView.setImageBitmap(bitmap);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mProgressBar.setProgress(values[0]);
        }
    }
}
