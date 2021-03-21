package ru.mirea.weatherforecast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityWeather extends AppCompatActivity {

    TextView city;
    String selected;
    ListView listView;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_activity);

        Intent i = getIntent();
        selected = i.getStringExtra("CityName");

        city = findViewById(R.id.city_nmae);
        city.setText(selected);

        List<String> temp = null;
        try {
            temp = jsonParsing(selected);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listView = findViewById(R.id.list_view);
        adapter = new ListViewAdapter(this, temp);
        listView.setAdapter(adapter);

    }

    List jsonParsing(String selected) throws JSONException, IOException {

        List<String> temperature = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(getApplicationContext().getAssets().open(selected + ".json"));
        for(int i = 0; i < jsonArray.length(); i++){

            JSONObject object = jsonArray.getJSONObject(i);
            String value = object.;
            temperature.add(value);
            Log.d("TAGA", value);

        }

        return temperature;

    }

}
