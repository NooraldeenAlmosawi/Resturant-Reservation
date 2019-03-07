package com.banwan.resturantreservation;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import static com.banwan.resturantreservation.R.array.resturants_array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner resturants_menu;
    String name;
    ImageView iv;
    Button btnRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        resturants_menu = findViewById (R.id.spin_Resturants);
        iv = findViewById (R.id.imageView2);
        resturants_menu.setOnItemSelectedListener (this);
        ArrayAdapter aa = ArrayAdapter.createFromResource (this,
                resturants_array, android.R.layout.simple_spinner_item);
        aa.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        resturants_menu.setAdapter (aa);
        FloatingActionButton fab = findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Snackbar.make (view, "راسلنا    :MMBN@ihec.com ", Snackbar.LENGTH_LONG)
                        .setAction ("Action", null).show ();

                btnRes = findViewById (R.id.button2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate (R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            {

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder (this);

                alertDialogBuilder.setMessage (" مع تحيات محمد+محمد+بلال+نور  ");

                alertDialogBuilder.setPositiveButton ("تم",
                        new DialogInterface.OnClickListener () {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        });


                AlertDialog alertDialog = alertDialogBuilder.create ();
                alertDialog.show ();
            }
            return true;
        }

        return super.onOptionsItemSelected (item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        name = (String) parent.getItemAtPosition (position);
        switch (name) {
            case "صاج الريف":
                iv.setImageResource (R.drawable.saj);
                break;
            case "صمد":
                iv.setImageResource (R.drawable.samad);
                break;
            case "شميساني":
                iv.setImageResource (R.drawable.shmesani);
                break;
            case "توست":
                iv.setImageResource (R.drawable.toast);
                break;
            case "ويست برغر":
                iv.setImageResource (R.drawable.west);
                break;
            case "ورق النعناع":
                iv.setImageResource (R.drawable.na3na3);
                break;
            case "بارلي":
                iv.setImageResource (R.drawable.barley);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Show_Reservation(View v) {
        SharedPreferences sp = getApplicationContext ().getSharedPreferences ("Res_Name", 0);
        SharedPreferences.Editor e = sp.edit ();
        e.putString ("Res_Name", name);
        e.commit ();
        Intent intent = new Intent (MainActivity.this, Reservation.class);
        startActivity (intent);
    }


}
