package yem.com.jsonapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by DanKravitz on 29/01/2017.
 */
public class JSONHttp extends JSONObject {

    private static final String URL_JSON = "http://www.json-generator.com/api/json/get/ccLAsEcOSq?indent=2";
    private JSONObject mJsonObject = null;
    private String json = "";

    public JSONObject getJSONFromUrl() {

        try {
            URL url;
            url = new URL(URL_JSON);
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            json = builder.toString();
            reader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            mJsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mJsonObject;
    }
}
