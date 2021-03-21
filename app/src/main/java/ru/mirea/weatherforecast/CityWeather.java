package ru.mirea.weatherforecast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CityWeather extends AppCompatActivity {

    TextView city;
    String selected;
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_activity);

        Intent i = getIntent();
        selected = i.getStringExtra("CityName");

        city = findViewById(R.id.city_nmae);
        city.setText(selected);
        List<String> cities = null;
        try {
            cities = jsonParsing(selected);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lineChart = (LineChart) findViewById(R.id.linechart);
        

    }

    List jsonParsing(String selected) throws JSONException, IOException {

        StringBuilder sb = new StringBuilder();
        InputStream is = getAssets().open(selected + ".json");
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String str;
        while ((str = br.readLine()) != null){

            sb.append(str);

        }
        br.close();
        List<String> temperature = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(sb.toString());
        for(int i = 0; i < jsonArray.length(); i++){

            String value = jsonArray.get(i).toString();
            temperature.add(value);

        }

        return temperature;

    }

}
