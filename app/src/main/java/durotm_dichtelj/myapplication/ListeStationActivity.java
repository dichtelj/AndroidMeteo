package durotm_dichtelj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        List<Station> stations = new ArrayList<Station>();
        stations.add(new Station("TRUC","MACHIN",5.40,1.4,54));
        return stations;
    }
}






  
