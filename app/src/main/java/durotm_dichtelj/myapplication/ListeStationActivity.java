package durotm_dichtelj.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import durotm_dichtelj.javaClasses.JsonHandler;
import durotm_dichtelj.javaClasses.ListeReleves;
import durotm_dichtelj.javaClasses.Station;
import durotm_dichtelj.javaClasses.StationAdapter;


public class ListeStationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.station_list_layout);
        ListView listeStation = (ListView) findViewById(R.id.listView);
        StationAdapter adapter = new StationAdapter(ListeStationActivity.this, recupererStations());
        listeStation.setAdapter(adapter);
    }

    public List<Station> recupererStations() {
        String jSon = null;
        List<Station> stations = new ArrayList<Station>();
        try {
            jSon = new JsonHandler().execute().get();
            if (jSon == null) {
                return stations;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();

        try {
            for (int i = 0; i <= json.length() - 1; i++) {
                JSONObject monObjetJSON = json.getJSONObject(i);
                String monStringJSON = monObjetJSON.toString();
                Station uneStation = gson.fromJson(monStringJSON, Station.class);
                stations.add(uneStation);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stations;
    }
}






  
