package com.adityadua.thirdpartyglideintegrationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by AdityaDua on 21/07/17.
 */

public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_layout);
        String imageURL="http://vignette4.wikia.nocookie.net/kungfupanda/images/7/7b/Lei-lei.jpg/revision/latest?cb=20151104195038";

        ImageView imageView = (ImageView) findViewById(R.id.imageview);

        Glide.with(this).load(imageURL)
                .thumbnail(.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
