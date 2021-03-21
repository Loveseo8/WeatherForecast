package ru.mirea.weatherforecast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.json.JSONArray;
import org.json.JSONException;

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
    int selected1;
    LineChart lineChart;
    Button btn;
    double add = 0;
    List<String> cities = null;
    Spinner spinner;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_activity);


        Intent i = getIntent();
        selected = i.getStringExtra("CityName");

        switch(selected){

            case "Алмазный":
                add = 0.27;
                break;

            case "Западный":
                add = 1.12;
                break;

            case "Курортный":
                add = 0.32;
                break;

            case "Лесной":
                add = -2.23;
                break;

            case "Научный":
                add = -0.23;
                break;

            case "Полярный":
                add = 0.24;
                break;

            case "Портовый":
                add = 1.75;
                break;

            case "Приморский":
                add = 2.4;
                break;

            case "Садовый":
                add = -0.27;
                break;

            case "Северный":
                add = 1.75;
                break;

            case "Степной":
                add = 2.22;
                break;

            case "Таежный":
                add = 1.75;
                break;

            case "Южный":
                add = 2.22;
                break;


        }

        city = findViewById(R.id.city_nmae);
        city.setText(selected);
        try {
            cities = jsonParsing(selected);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lineChart = (LineChart) findViewById(R.id.linechart);

        ArrayList<Entry> entries = new ArrayList<>();
        for (int m = 0; m < cities.size(); m++) {
            entries.add(new Entry(m + 1, (float) Double.parseDouble(cities.get(m))));
        }



        LineDataSet dataset = new LineDataSet(entries, "Температура за год");

        LineData data = new LineData(dataset);
        lineChart.setData(data);

        lineChart.invalidate();

        spinner = findViewById(R.id.year);
        String[] years = {"1", "2", "3", "4", "5", "6 ", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, years);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btn = findViewById(R.id.btn);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected1 = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        for(int n = 0; n < 365; n++){

            cities.add(cities.get(6935 + n) + add);

        }



            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ArrayList<Entry> entries = new ArrayList<>();

                    for (int m = getStart(selected1); m < getEnd(selected1); m++) {
                        Log.d("TAGA", String.valueOf(selected1));
                        entries.add(new Entry(m + 1, (float) Double.parseDouble(cities.get(m))));
                    }

                    LineDataSet dataset = new LineDataSet(entries, "Температура");

                    LineData data = new LineData(dataset);
                    lineChart.setData(data);

                    lineChart.invalidate();
                }
            });

        }

         int getStart(int selected){

        int start = 0;

        switch (selected) {

            case 1:
                start = 0;
                break;

            case 2:
                start = 365;
                break;
            case 3:
                start = 730;
                break;
            case 4:
                start = 1095;
                break;
            case 5:
                start = 1460;
                break;
            case 6:
                start = 1825;
                break;
            case 7:
                start = 2190;
                break;

            case 8:
                start = 2555;
                break;

            case 9:
                start = 2920;
                break;


            case 11:
                start = 3650;
                break;

            case 12:
                start = 4015;
                break;

            case 13:
                start = 4380;
                break;

            case 14:
                start = 4745;
                break;

            case 15:
                start = 5110;
                break;

            case 16:
                start = 5475;
                break;

            case 17:
                start = 5840;
                break;

            case 18:
                start = 6205;
                break;

            case 19:
                start = 6570;
                break;

            case 20:
                start = 6935;
                break;

            case 21:
                start = 7300;
                break;


            default:
                break;
        }

        return  start;

    }

    int getEnd(int selected){


        int end = 0;

        switch (selected) {

            case 1:
                end = 365;
                break;

            case 2:
                end = 730;
                break;
            case 3:
                end = 1095;
                break;
            case 4:
                end = 1460;
                break;
            case 5:
                end = 1825;
                break;
            case 6:
                end = 2190;
                break;
            case 7:
                end = 2555;
                break;

            case 8:
                end = 2920;
                break;

            case 9:
                end = 3285;
                break;


            case 11:
                end = 4015;
                break;

            case 12:
                end = 4380;
                break;

            case 13:
                end = 4745;
                break;

            case 14:
                end = 5110;
                break;

            case 15:
                end = 5475;
                break;

            case 16:
                end = 5840;
                break;

            case 17:
                end = 6205;
                break;

            case 18:
                end = 6570;
                break;

            case 19:
                end = 6935;
                break;

            case 20:
                end = 7300;
                break;

            case 21:
                end = 7665;
                break;


            default:
                break;
        }

        return  end;

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
