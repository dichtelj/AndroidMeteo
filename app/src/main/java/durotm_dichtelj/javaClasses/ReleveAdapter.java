package durotm_dichtelj.javaClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import durotm_dichtelj.myapplication.R;


/**
 * Created by Jonathan on 11/02/2016.
 */
public class ReleveAdapter {
    public class releveAdapter extends BaseAdapter {

        List<Releve> listeReleves = getReleves();

        @Override
        public int getCount() {
            return listeReleves.size();
        }

        @Override
        public Object getItem(int position) {
            return listeReleves.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) LayoutInflater.from(parent.getContext());
                convertView = inflater.inflate(R.layout.releve_layout, parent, false);
            }

            TextView txtStationReleve = (TextView) convertView.findViewById(R.id.txtStationListReleveStationActivity);
            TextView txtDateReleve = (TextView) convertView.findViewById(R.id.txtDateListReleveStationActivity);
            TextView txtTempIntReleve = (TextView) convertView.findViewById(R.id.txtTempIntListReleveStationActivity);
            TextView txtTempExtReleve = (TextView) convertView.findViewById(R.id.txtTempExtListReleveStationActivity);
            TextView txtPressionReleve = (TextView) convertView.findViewById(R.id.txtPressionListReleveStationActivity);
            TextView txtLuxReleve = (TextView) convertView.findViewById(R.id.txtLuminositeListReleveStationActivity);
            TextView txtHygroReleve = (TextView) convertView.findViewById(R.id.txtHygrometrieListReleveStationActivity);
            TextView txtVitVReleve = (TextView) convertView.findViewById(R.id.txtVitesseVentListReleveStationActivity);
            TextView txtDivVReleve = (TextView) convertView.findViewById(R.id.txtDirectionVentListReleveStationActivity);

            TextView txtStationReleveValue = (TextView) convertView.findViewById(R.id.txtvalueStationListReleveStationActivity);
            TextView txtDateReleveValue = (TextView) convertView.findViewById(R.id.txtvalueDateListReleveStationActivity);
            TextView txtTempIntReleveValue = (TextView) convertView.findViewById(R.id.txtvalueTempIntListReleveStationActivity);
            TextView txtTempExtReleveValue = (TextView) convertView.findViewById(R.id.txtvalueTempExtListReleveStationActivity);
            TextView txtPressionReleveValue = (TextView) convertView.findViewById(R.id.txtvaluePressionListReleveStationActivity);
            TextView txtLuxReleveValue = (TextView) convertView.findViewById(R.id.txtvalueLuminositeListReleveStationActivity);
            TextView txtHygroReleveValue = (TextView) convertView.findViewById(R.id.txtvalueHygrometrieListReleveStationActivity);
            TextView txtVitVReleveValue = (TextView) convertView.findViewById(R.id.txtvalueVitesseVentListReleveStationActivity);
            TextView txtDivVReleveValue = (TextView) convertView.findViewById(R.id.txtvalueDirectionVentListReleveStationActivity);

            Releve unReleve = listeReleves.get(position);

            if (unReleve.getStation() != null) {
                txtStationReleve.setVisibility(View.VISIBLE);
                txtStationReleve.setText(R.string.txtStationListReleveStationActivity);
                txtStationReleveValue.setText(unReleve.getStation());
            } else {
                txtStationReleve.setVisibility(View.VISIBLE);
                txtStationReleve.setText(R.string.txtStationListReleveStationActivity);
                txtStationReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            if (unReleve.getQuand() != null) {
                txtDateReleve.setVisibility(View.VISIBLE);
                txtDateReleve.setText(R.string.txtDateListReleveStationActivity);
                txtDateReleveValue.setText(unReleve.getQuand());
            } else {
                txtDateReleve.setVisibility(View.VISIBLE);
                txtDateReleve.setText(R.string.txtDateListReleveStationActivity);
                txtDateReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            if (unReleve.getTemp1() != null) {
                txtTempIntReleve.setVisibility(View.VISIBLE);
                txtTempIntReleve.setText(R.string.txtTempIntListReleveStationActivity);
                txtTempIntReleveValue.setText(unReleve.getTemp1() + " °C");
            } else {
                txtTempIntReleve.setVisibility(View.VISIBLE);
                txtTempIntReleve.setText(R.string.txtTempIntListReleveStationActivity);
                txtTempIntReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            if (unReleve.getTemp2() != null) {
                txtTempExtReleve.setVisibility(View.VISIBLE);
                txtTempExtReleve.setText(R.string.txtTempExtListReleveStationActivity);
                txtTempExtReleveValue.setText(unReleve.getTemp2() + " °C");
            } else {
                txtTempExtReleve.setVisibility(View.VISIBLE);
                txtTempExtReleve.setText(R.string.txtTempExtListReleveStationActivity);
                txtTempExtReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            if (unReleve.getPressure() != null) {
                txtPressionReleve.setVisibility(View.VISIBLE);
                txtPressionReleve.setText(R.string.txtPressionListReleveStationActivity);
                txtPressionReleveValue.setText(unReleve.getPressure() + " hPa");
            } else {
                txtPressionReleve.setVisibility(View.VISIBLE);
                txtPressionReleve.setText(R.string.txtPressionListReleveStationActivity);
                txtPressionReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            if (unReleve.getLux() != null) {
                txtLuxReleve.setVisibility(View.VISIBLE);
                txtLuxReleve.setText(R.string.txtLuminositeListReleveStationActivity);
                txtLuxReleveValue.setText(unReleve.getLux() + " lux");
            } else {
                txtLuxReleve.setVisibility(View.VISIBLE);
                txtLuxReleve.setText(R.string.txtLuminositeListReleveStationActivity);
                txtLuxReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            if (unReleve.getHygro() != null) {
                txtHygroReleve.setVisibility(View.VISIBLE);
                txtHygroReleve.setText(R.string.txtHygrometrieListReleveStationActivity);
                txtHygroReleveValue.setText(unReleve.getHygro() + " %");
            } else {
                txtHygroReleve.setVisibility(View.VISIBLE);
                txtHygroReleve.setText(R.string.txtHygrometrieListReleveStationActivity);
                txtHygroReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            if (unReleve.getWindSpeed() != null) {
                txtVitVReleve.setVisibility(View.VISIBLE);
                txtVitVReleve.setText(R.string.txtVitesseVentListReleveStationActivity);
                txtVitVReleveValue.setText(unReleve.getWindSpeed() + " m/s");
            } else {
                txtVitVReleve.setVisibility(View.VISIBLE);
                txtVitVReleve.setText(R.string.txtVitesseVentListReleveStationActivity);
                txtVitVReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            if (unReleve.getWindDir() != null) {
                txtDivVReleve.setVisibility(View.VISIBLE);
                txtDivVReleve.setText(R.string.txtDirectionVentListReleveStationActivity);
                txtDivVReleveValue.setText(unReleve.getWindDir() + " °");
            } else {
                txtDivVReleve.setVisibility(View.VISIBLE);
                txtDivVReleve.setText(R.string.txtDirectionVentListReleveStationActivity);
                txtDivVReleveValue.setText(R.string.txtNoDataListReleveStationActivity);
            }

            return convertView;
        }

        public List<Releve> getReleves() {
            String monJSON = null;
            List<Releve> listeReleves = new ArrayList<Releve>();
            try {
                monJSON = new JsonHandler().execute().get();
                if (monJSON == null) {
                    return listeReleves;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Gson unGson = new Gson();

            try {
                for (int i = 0; i <= json.length() - 1; i++) {
                    JSONObject monObjetJSON = json.getJSONObject(i);
                    String monStringJSON = monObjetJSON.toString();
                    Releve unReleve = unGson.fromJson(monStringJSON, Releve.class);
                    listeReleves.add(unReleve);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return listeReleves;
        }
    }
}
