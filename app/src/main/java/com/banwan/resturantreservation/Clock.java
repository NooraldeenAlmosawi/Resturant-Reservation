package com.banwan.resturantreservation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

public class Clock extends AppCompatActivity {
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        tp = findViewById(R.id.editText);
        tp.is24HourView();
    }

    public void Show_Reservation(View v){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("Time",0);
        SharedPreferences.Editor e = sp.edit();
        e.putString("Time",tp.getCurrentHour()+":"+tp.getCurrentMinute());
        e.commit();
        Intent intent = new Intent(Clock.this,Reservation.class);
        startActivity(intent);
    }
}
