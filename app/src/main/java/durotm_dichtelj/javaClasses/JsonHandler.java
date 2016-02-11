package durotm_dichtelj.javaClasses;

import android.util.Base64;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class JsonHandler {
    static InputStream is = null;
    static JSONObject jObj = null;
    static JSONArray jArray = null;
    static String json = "";

    public JsonHandler() {
    }

    public JSONObject getJSONObjectFromUrl(String url) {
        try {
            URL urlUser = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlUser.openConnection();
            String user = "username:password";
            String encoded = Base64.encodeToString(user.getBytes(), Base64.DEFAULT);
            con.setRequestProperty("Authorization", "basic " + encoded);
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "utf-8");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.connect();
            is = con.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return jObj;
    }

    public JSONObject HttpRequest(String url, List<String> params, List<String> values) {
        URL urlUser;
        String query = null;
        HttpURLConnection con = null;
        try {
            for (int i = 0; i < params.size(); i++) {
                query = String.format(params.get(i) + "=%s", URLEncoder.encode(values.get(i), "UTF-8"));
            }
            urlUser = new URL(url + "?" + query);
            Log.i("url", urlUser.toString());
            String user = "username:password";
            String encoded = Base64.encodeToString(user.getBytes(), Base64.DEFAULT);
            con.setRequestProperty("Authorization", "basic " + encoded);
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "utf-8");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.connect();
            is = con.getInputStream();
            Log.d("content", is.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return jObj;

    }

    public JSONArray getJSONArrayFromUrl(String url) {
        try {
            URL urlUser = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlUser.openConnection();

            String user = "username:password";
            String encoded = Base64.encodeToString(user.getBytes(), Base64.DEFAULT);

            con.setRequestProperty("Authorization", "basic " + encoded);
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "utf-8");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.connect();

            is = con.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        try {
            jArray = new JSONArray(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return jArray;
    }

    public JSONArray arrayHttpRequest(String url, List<String> params,List<String> values) {
        URL urlUser;
        String query = null;
        HttpURLConnection con = null;
        try {
            if (params != null) {
                query = "";
                for (int i = 0; i < params.size(); i++) {
                    if (!query.equals("")) {
                        query += "&";
                    }
                    query += String.format(params.get(i) + "=%s", URLEncoder.encode(values.get(i), "UTF-8"));
                }
            }
            if (query != null) {
                urlUser = new URL(url + "?" + query);
            } else {
                urlUser = new URL(url);
            }
            Log.i("url", urlUser.toString());
            con = (HttpURLConnection) urlUser.openConnection();
            String user = "username:password";
            String encoded = Base64.encodeToString(user.getBytes(), Base64.DEFAULT);
            con.setRequestProperty("Authorization", "basic " + encoded);
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "utf-8");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.connect();
            is = con.getInputStream();
            Log.d("content", is.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                Log.d("content", line);
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        try {
            jArray = new JSONArray(json);

        } catch (JSONException e) {
            try {
                JSONObject jObj = new JSONObject(json);
            } catch (Exception f) {
                Log.e("JSON Parser", "Error parsing data " + f.toString());
                return jArray = null;
            }
            return jArray = null;
        }
        return jArray;
    }


}
