package com.example.listycitylab3;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        AddCityFragment.AddCityDialogListener {
    private ArrayList<City> dataList;
    private ListView cityList;
    private CityArrayAdapter cityAdapter;


//    public int selectedPosition = -1;
    @Override
    public void addCity(City city) {
        cityAdapter.add(city);
        cityAdapter.notifyDataSetChanged();
    }

    @Override
    public void editCity(int position, City city) {
        dataList.set(position, city);
        cityAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] cities = { "Edmonton", "Vancouver", "Toronto" };
        String[] provinces = { "AB", "BC", "ON" };
        dataList = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            dataList.add(new City(cities[i], provinces[i]));
        }
        cityList = findViewById(R.id.city_list);
        cityAdapter = new CityArrayAdapter(this, dataList);
        cityList.setAdapter(cityAdapter);
        FloatingActionButton fab = findViewById(R.id.button_add_city);
        fab.setOnClickListener(v -> {
            new AddCityFragment().show(getSupportFragmentManager(), "Add City");
        });

        cityList.setOnItemClickListener((parent, view, position, id) -> {
                Log.i("friedchicken", "you clicked: " + view.toString() + " | " + position);
//                dataList.remove(position);
//                view.setBackgroundColor(Color.BLUE);
//                selectedPosition = position;

//                dataList.set(position, new City("bruh", "moment"));

//                AddCityFragment bruh = new AddCityFragment().newInstance(new City());

//                new AddCityFragment().show(getSupportFragmentManager(), "Add City");
//                    new AddCityFragment().editCity(position);
//                new AddCityFragment().show(getSupportFragmentManager(), "Add City");
//                    AddCityFragment dialog = new AddCityFragment();
//                    dialog.setDialogListener(newText -> {
//                        dataList.set(position, newText);
//                        textView.setText(newText); // update fragment UI
//                    });
//                    dialog.show(getSupportFragmentManager(), "editDialog");
                    AddCityFragment frag = new AddCityFragment();
                    frag.isEdit = true;
                    frag.city = dataList.get(position);
                    frag.position = position;

                    frag.show(getSupportFragmentManager(), "bruh");

//                    addCityFrag.show(getSupportFragmentManager(), "bruh");
//                    cityAdapter.notifyDataSetChanged();
//                dataList.
//                cityAdapter =new ArrayAdapter<>(MainActivity.this, R.layout.content, dataList);
//                cityList.setAdapter(cityAdapter);

            }
        );
    }
}