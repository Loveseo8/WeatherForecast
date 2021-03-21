package ru.mirea.weatherforecast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    List<String> cities = new ArrayList<>();
    LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, List<String> cities){

        this.context = context;
        this.cities = cities;

    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textCity;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        textCity = (TextView) itemView.findViewById(R.id.city_name);
        textCity.setText(cities.get(position));

        return itemView;
    }
}
