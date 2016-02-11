package durotm_dichtelj.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import durotm_dichtelj.javaClasses.JsonHandler;
import durotm_dichtelj.javaClasses.ListeReleves;
import durotm_dichtelj.javaClasses.Station;

public class MainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        String uneStation = null;
        try {
            uneStation = new getStationFromJSON().execute().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Station station = new Gson().fromJson(uneStation, Station.class);

        TextView nomStation = (TextView) findViewById(R.id.nomStation);
        TextView libelleStation = (TextView) findViewById(R.id.libelleStation);
        TextView longitude = (TextView) findViewById(R.id.longitude);
        TextView latitude = (TextView) findViewById(R.id.latitude);
        TextView altitude = (TextView) findViewById(R.id.altitude);

        nomStation.setText(station.getNom());
        libelleStation.setText(station.getLibelle());
        longitude.setText(station.getLongitude());
        latitude.setText(station.getLatitude());
        altitude.setText(station.getAltitude());

    }

    public void toListStationActivity(View view) {
        Intent intent = new Intent(this, ListeStationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.listeStation:
                toListStationActivity(v);
        }
    }

    public class getStationFromJSON extends AsyncTask<String, String, String> {

        public SharedPreferences preferences;
        private JsonHandler jsonParser = new JsonHandler();
        private static final String GET_ONE_STATION = "";

        @Override
        protected String doInBackground(String... args) {
            preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
            List<String> params = Arrays.asList("id");
            List<String> values = Arrays.asList(preferences.getString("preferences", "Montélimar"));
            JSONObject json = jsonParser.HttpRequest(GET_ONE_STATION, params, values);
            return json.toString();
        }
    }
}