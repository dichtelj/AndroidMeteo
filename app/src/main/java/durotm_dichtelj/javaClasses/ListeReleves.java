package durotm_dichtelj.javaClasses;

import android.widget.Toast;

import org.json.JSONArray;

import java.util.Arrays;
import java.util.List;

import durotm_dichtelj.myapplication.ListeRelevesActivity;

/**
 * Created by Jonathan on 11/02/2016.
 */
public class ListeReleves {
    private String GET_RELEVES = "http://intranet.iut-valence.fr/~durotm/a_publier/tps/meteo/api/mesures";

    public JsonHandler releves = new JsonHandler();

    public List<Releve> listeReleves;

    @Override
    protected String doInBackground(String id) {
        String value = id;

        listeReleves = null;
        this.GET_RELEVES += "/" + value;
        return json.toString();
    }

    protected void onPostExecute(String file_url) {

        if (file_url != null) {
            Toast.makeText(ListeRelevesActivity.this, "Liste des stations récupérée", Toast.LENGTH_SHORT).show();
        }
    }
}
}
