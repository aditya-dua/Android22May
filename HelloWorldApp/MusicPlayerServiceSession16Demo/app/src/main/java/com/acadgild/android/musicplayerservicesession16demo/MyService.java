package com.acadgild.android.musicplayerservicesession16demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by AdityaDua on 07/07/17.
 */

public class MyService extends Service {

    MediaPlayer mp;
    int pos=0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
       mp =MediaPlayer.create(getApplicationContext(),R.raw.song);
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(pos==0){mp.start();}
        else{
            mp.start();
            mp.seekTo(pos);}
        mp.setLooping(false);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if(mp.isPlaying()){
            pos=mp.getCurrentPosition();
        }
        mp.pause();
        super.onDestroy();
    }
}
