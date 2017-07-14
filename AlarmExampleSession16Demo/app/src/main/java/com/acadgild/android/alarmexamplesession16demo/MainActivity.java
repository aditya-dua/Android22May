package com.acadgild.android.alarmexamplesession16demo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends Activity {

    private static  MainActivity inst;
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private TextView alarmTextView;
    private Button stopBtn;

    public static  MainActivity instance(){

        return inst;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTimePicker =(TimePicker)findViewById(R.id.alarmtimePicker);
        ToggleButton alarmToggle=(ToggleButton)findViewById(R.id.alarmToggleButton);
        alarmManager =(AlarmManager) getSystemService(ALARM_SERVICE);
        stopBtn=(Button)findViewById(R.id.button);

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this,AlarmService.class));

            }
        });
        alarmToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ToggleButton)v).isChecked()){
                    Calendar calendar=Calendar.getInstance();
                    calendar.set(Calendar.MINUTE,alarmTimePicker.getCurrentMinute());

                    Intent myIntent=new Intent(MainActivity.this,AlarmReceiver.class);
                    pendingIntent = PendingIntent.getActivity(MainActivity.this,0,myIntent,0);
                    alarmManager.set(AlarmManager.RTC,calendar.getTimeInMillis(),pendingIntent);
                }else{
                    alarmManager.cancel(pendingIntent);
                    setAlarmText("Alarm Off");
                }
            }
        });



    }
    public void setAlarmText(String alarmText){
        alarmTextView.setText(alarmText);
        stopBtn.setVisibility(View.VISIBLE);

    }
}
