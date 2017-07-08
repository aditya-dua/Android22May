package com.acadgild.android.notificationdemosession17;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button simpleNotificationbtn,bigTextNotification,bigPictureNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleNotificationbtn =(Button) findViewById(R.id.simple_notification);
        simpleNotificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleNotification();
            }
        });
        bigTextNotification = (Button) findViewById(R.id.bigtextnotification);
        bigTextNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigTextNotification();
            }
        });

        bigPictureNotification =(Button) findViewById(R.id.bigPictureNotification);
        bigPictureNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigPictureNotification();
            }
        });
    }

    private void simpleNotification(){
        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Notifictaion Text")
                .setContentTitle("Title");

        NotificationManager mNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotification.notify(1,mbuilder.build());

    }

    private void bigTextNotification(){
        Bitmap icon1= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Big Text Notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(icon1);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText("Mahindra Groups's Chairman Anand Mahindra today tendered a public apology over the manner in which an employee of Tech Mahindra was asked to quit.\n" +
                "\n" +
                "Tech Mahindra top brass also apologised after an audio" +
                " clip went viral, which purportedly involved a conversation " +
                "of an HR executive of the company asking an employee to put " +
                "in his papers by next morning, as part of corporate decision.");
        bigText.setBigContentTitle("TechM HR Policy");
        bigText.setSummaryText("Just For Testing");

        mBuilder.setStyle(bigText);

        Intent resultIntent= new Intent(MainActivity.this,NextActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NextActivity.class);

        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100,mBuilder.build());
    }

    private void bigPictureNotification(){
        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Big Picture")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(icon1)
                .setContentText("Big Picture Notification Text");

        NotificationCompat.BigPictureStyle bigPictureStyle= new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(icon1);
        bigPictureStyle.setBigContentTitle("Notification");

        mBuilder.setStyle(bigPictureStyle);


        Intent result= new Intent(this,NextActivity.class);

        TaskStackBuilder stack=TaskStackBuilder.create(this);
        stack.addParentStack(NextActivity.class);
        stack.addNextIntent(result);

        PendingIntent resultPI=stack.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPI);

        NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        nm.notify(100,mBuilder.build());

    }
}

