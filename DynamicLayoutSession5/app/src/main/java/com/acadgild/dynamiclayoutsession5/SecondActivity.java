package com.acadgild.dynamiclayoutsession5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * Created by AdityaDua on 02/06/17.
 */

public class SecondActivity extends Activity implements Animation.AnimationListener{

    TextView txtMessage;
    Button btnAnim;
    Animation animFadeIn,animFadeOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        txtMessage =(TextView) findViewById(R.id.textView2);
        btnAnim =(Button) findViewById(R.id.button2);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        animFadeOut=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

        animFadeIn.setAnimationListener(this);
        btnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMessage.setVisibility(View.VISIBLE);
                txtMessage.startAnimation(animFadeIn);
            }
        });


    }

    @Override
    public void onAnimationStart(Animation animation) {

        Toast.makeText(getApplicationContext(),"Animiation Started",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //THis will be used when the animation has ended
        if(animation==animFadeIn){
            Toast.makeText(getApplicationContext(),"Animation Stopped",Toast.LENGTH_LONG).show();
            txtMessage.startAnimation(animFadeOut);
            animFadeOut.start();
            txtMessage.setVisibility(View.GONE);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
