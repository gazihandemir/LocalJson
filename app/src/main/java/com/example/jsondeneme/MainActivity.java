package com.example.jsondeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.CityList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CityList cityList = new CityList();
        try {
            // load file
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.deneme)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null; ) {
                jsonBuilder.append(line).append("\n");
            }

            Gson gson = new Gson();
            cityList = gson.fromJson(jsonBuilder.toString(), CityList.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Spinner spinner = findViewById(R.id.spinner);
        List<String> spinnerData = new ArrayList<>();
        for (int i = 0; i < cityList.getCityDetail().size(); i++) {
            spinnerData.add(cityList.getCityDetail().get(i).getName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinnerData);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }
}
