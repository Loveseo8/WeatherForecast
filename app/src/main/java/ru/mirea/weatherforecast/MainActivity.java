package ru.mirea.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    List<String> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities.add("Алмазный");
        cities.add("Западный");
        cities.add("Курортный");
        cities.add("Лесной");
        cities.add("Научный");
        cities.add("Полярный");
        cities.add("Портовый");
        cities.add("Приморский");
        cities.add("Садовый");
        cities.add("Северный");
        cities.add("Степной");
        cities.add("Таежный");
        cities.add("Южный");


        listView = findViewById(R.id.list_view);
        adapter = new ListViewAdapter(this, cities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, CityWeather.class);
                i.putExtra("CityName", cities.get(position));
                startActivity(i);
            }
        });

    }
}