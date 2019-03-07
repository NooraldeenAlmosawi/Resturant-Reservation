package com.banwan.resturantreservation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Reservation extends AppCompatActivity {
    int persons;
    TextView lbl_name, lbl_person, lbl_time, lbl_date;
    Button btn_Minus, btn_Plus;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_reservation);
        lbl_name = findViewById (R.id.lbl_resturant_name);
        lbl_person = findViewById (R.id.lbl_persons);
        lbl_date = findViewById (R.id.lbl_Date);
        lbl_time = findViewById (R.id.lbl_Time);
        btn_Minus = findViewById (R.id.btn_minus);
        btn_Plus = findViewById (R.id.btn_plus);
        lbl_person.setText (persons==0?"1 Person":persons+" Persons");
        iv = findViewById (R.id.imageView);
        SharedPreferences sp_Name = getSharedPreferences ("Res_Name", 0);
        SharedPreferences sp_Date = getSharedPreferences ("Date", 0);
        SharedPreferences sp_Time = getSharedPreferences ("Time", 0);
        lbl_name.setText (sp_Name.getString ("Res_Name", ""));
        lbl_date.setText (sp_Date.getString ("Date", ""));
        lbl_time.setText (sp_Time.getString ("Time", ""));
        iv.setImageResource (R.drawable.t1);
    }

    public void Increasing_Persons(View v) {
        if (persons < 6) {
            persons++;
            lbl_person.setText (persons + " Persons");
            Context c = iv.getContext ();
            int id = c.getResources ().getIdentifier ("t" + persons, "drawable", c.getPackageName ());
            iv.setImageResource (id);
        }
    }

    public void Decreasing_Persons(View v) {
        if (persons > 1) {
            persons--;
            if (persons == 1)
                lbl_person.setText (persons + " Person");
            else
                lbl_person.setText (persons + " Persons");
            Context c = iv.getContext ();
            int id = c.getResources ().getIdentifier ("t" + persons, "drawable", c.getPackageName ());
            iv.setImageResource (id);
        }
    }

    public void Show_Clock(View v) {
        Intent intent = new Intent (Reservation.this, Clock.class);
        startActivity (intent);
    }

    public void Show_Date(View v) {
        Intent intent = new Intent (Reservation.this, Date.class);
        startActivity (intent);
    }

    public void dialogBox(View v) {
        SharedPreferences sp_Name = getSharedPreferences ("Res_Name", 0);
        SharedPreferences sp_Date = getSharedPreferences ("Date", 0);
        SharedPreferences sp_Time = getSharedPreferences ("Time", 0);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder (this);

        alertDialogBuilder.setMessage (

                " اسم المطعم: " + sp_Name.getString ("Res_Name", "") + "\n" +
                " وقت الحجز: " + sp_Time.getString ("Time", "") + "\n" +
                " تاريخ الحجز: " + sp_Date.getString ("Date", ""));


        alertDialogBuilder.setPositiveButton ("تاكيد",
                new DialogInterface.OnClickListener () {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent intent = new Intent (Reservation.this, MainActivity.class);
                        startActivity (intent);
                    }
                });

        alertDialogBuilder.setNegativeButton ("الغاء",
                new DialogInterface.OnClickListener () {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish ();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create ();
        alertDialog.show ();
    }
}
