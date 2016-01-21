package durotm_dichtelj.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import durotm_dichtelj.javaClasses.Preferences;
import durotm_dichtelj.javaClasses.Station;


public class HomeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        TextView nomStation = (TextView) findViewById(R.id.nomStation);
        TextView libelleStation = (TextView) findViewById(R.id.libelleStation);
        TextView latitude = (TextView) findViewById(R.id.latitude);
        TextView longitude = (TextView) findViewById(R.id.longitude);
        TextView altitude = (TextView) findViewById(R.id.altitude);
        Button listeStation = (Button) findViewById(R.id.listeStation);
        SharedPreferences prefs = getSharedPreferences(Preferences.SAVE_PREF, Context.MODE_PRIVATE);
        Boolean fav = prefs.getBoolean(Preferences.SAVE_PREF,false);
        listeStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListeStationActivity.class);
                startActivity(intent);
            }
        });
    }
}


