package com.banwan.resturantreservation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date extends AppCompatActivity {

    DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_date);
        dp = findViewById (R.id.editText2);

    }

    public void Show_Reservation(View v) {
        SharedPreferences sp = getApplicationContext ().getSharedPreferences ("Date", 0);
        SharedPreferences.Editor e = sp.edit ();
        e.putString ("Date", dp.getDayOfMonth () + "/" + (dp.getMonth () + 1));
        e.commit ();
        Intent intent = new Intent (Date.this, Reservation.class);
        startActivity (intent);
    }
}
