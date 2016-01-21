package durotm_dichtelj.javaClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import durotm_dichtelj.myapplication.R;

/**
 * Created by dichtelj on 17/12/2015.
 */
public class StationAdapter extends ArrayAdapter<Station> {
    public StationAdapter(Context context, List<Station> stations) {
        super(context, 0, stations);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        //Android nous fournit un convertView null lorsqu'il nous demande de la créer
        //dans le cas contraire, cela veux dire qu'il nous fournit une vue recyclée
        if(convertView == null){
            //Nous récupérons notre row_tweet via un LayoutInflater,
            //qui va charger un layout xml dans un objet View
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.list_view_layout,parent, false);
        }

        StationHolder viewHolder = (StationHolder) convertView.getTag();
        if(viewHolder == null) {
            viewHolder = new StationHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nomStation);
            viewHolder.libelle = (TextView) convertView.findViewById(R.id.libelleStation);
            viewHolder.latitude = (TextView) convertView.findViewById(R.id.latitude);
            viewHolder.longitude = (TextView) convertView.findViewById(R.id.longitude);
            viewHolder.altitude = (TextView) convertView.findViewById(R.id.altitude);
            convertView.setTag(viewHolder);
        }
        return convertView;
    }
    class StationHolder{
        public TextView nom;
        public TextView libelle;
        public TextView latitude;
        public TextView longitude;
        public TextView altitude;
    }
}
