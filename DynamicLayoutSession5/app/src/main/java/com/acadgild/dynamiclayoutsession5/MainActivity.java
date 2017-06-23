package com.acadgild.dynamiclayoutsession5;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    //Debugging In Android ::

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Because : the layout which will be created will be set in the application.
        //setContentView(R.layout.activity_main);

        //Create a View Dynamically
        //this => context which talks about the creation of layout or till the scope of layout
        // so it is till this activity.

        setContentView(R.layout.activity_main);

       }

    public void clickHappened(View v){
        Button btn = (Button) findViewById(R.id.button);
        btn.setBackground(getResources().getDrawable(R.drawable.shape));


        ImageView imageView = new ImageView(this);
        //Center Inside : Cnetre with Ascpect ratio..
        //Please read about all others :
        // https://developer.android.com/reference/android/widget/ImageView.ScaleType.html
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(500,500));
        //Creation of View is DONE !
        // Now we will fetch the image and show.
        try{
            InputStream inputStream=getAssets().open("android_noughat.jpg");
            //THis will create an Android Drawable from Input Stream.
            Drawable d=Drawable.createFromStream(inputStream,null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            Log.e("IO Exception","In Catch block :: IO Error Occured");
            e.printStackTrace();
        }


        //setContentView(imageView);


    }
}

/**
 *
 * So we need to debug when we are not getting the expected output
 * We break the code into differentparts to check if the flow is going properly
 * from one MEthd to other ..
 * BREAKPOINTS...
 *
 *
 */
