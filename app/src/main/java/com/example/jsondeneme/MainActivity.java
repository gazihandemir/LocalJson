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

import model.Besinler;
import model.BesinlerDetails;
import model.CityList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  // 100tane temel json yazdırma
      // intellij idea !
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String id = "";
            String name = "";
            String calories = "";
            int deger = 0;
            String json = "";
            ArrayList<String> list = new ArrayList<>();
            while (deger != 100) {
                System.out.println("id : ");
                id = scn.nextLine();
                System.out.println("name : ");
                name = scn.nextLine();
                System.out.println("calories : ");
                calories = scn.nextLine();
                json = "{ \n " +
                        "       \"id\" : \"" + id + "\",\n" +
                        "       \"name\" : \"" + name + "\",\n" +
                        "       \"calories\" : \"" + calories + "\",\n},\n";
*//*            System.out.println("{\n" +
                    "       \"id\": \"1\",\n" +
                    "       \"name\": \"Ahududu\",\n" +
                    "       \"calories\":\"52\"\n" +
                    "     },");
            System.out.println("{ \n " +
                    "       \"id\" : \""+id+"\",\n" +
                    "       \"name\" : \""+name+"\",\n" +
                    "       \"calories\" : \""+calories+"\",\n }," );*//*
                list.add(json);
                deger++;

            }
            for (int i =0;i<100;i++){
                System.out.println(list.get(i));
            }

        }*/
        CityList cityList = new CityList();
        BesinlerDetails besinlerList = new BesinlerDetails();
        try {
            // load file
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.besinler)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null; ) {
                jsonBuilder.append(line).append("\n");
            }

            Gson gson = new Gson();
            //cityList = gson.fromJson(jsonBuilder.toString(), CityList.class);
            besinlerList = gson.fromJson(jsonBuilder.toString(), BesinlerDetails.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //1
        Spinner spinner = findViewById(R.id.spinner);
        List<String> spinnerData = new ArrayList<>();
        //2
        Spinner spinner1 = findViewById(R.id.spinner2);
        List<String> spinnerData2 = new ArrayList<>();
        //3
        Spinner spinner2= findViewById(R.id.spinner3);
        List<String> spinnerData3 = new ArrayList<>();
        /*   for (int i = 0; i < cityList.getCityDetail().size(); i++) {
            spinnerData.add(cityList.getCityDetail().get(i).getName());
        }*/
        for (int i = 0; i < besinlerList.getBesinler().size(); i++) {
            spinnerData.add(besinlerList.getBesinler().get(i).getName());
        }
        for (int i=0;i<besinlerList.getBesinler().size();i++){
            spinnerData2.add(besinlerList.getBesinler().get(i).getCalories());
        }
        for (int i=0;i<besinlerList.getBesinler().size();i++){
            spinnerData3.add(besinlerList.getBesinler().get(i).getPorsiyon());
        }
        // 1
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinnerData);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        // 2
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinnerData2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter2);
        // 3
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinnerData3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter3);
    }
}
