package durotm_dichtelj.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.*;

import org.json.JSONArray;

import durotm_dichtelj.javaClasses.ReleveAdapter;

/**
 * Created by Jonathan on 11/02/2016.
 */
public class ListeRelevesActivity extends Activity{
    public JSONArray json;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.releve_layout);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");

        ReleveAdapter releves = new ReleveAdapter();

        ListView lv = (ListView) findViewById(R.id.lvListReleveStationActivity);

        lv.setAdapter(releves);
    }
}
