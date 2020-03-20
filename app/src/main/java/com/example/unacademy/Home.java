package com.example.unacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        RecyclerView listView = findViewById(R.id.numberlist);

        final List<String> l1 = new ArrayList<>();

        for(int i = 1; i <= 9; i++)
        {
            l1.add(i == 7 ? getString(R.string.url) + "7_0.jpg" : getString(R.string.url) + Integer.toString(i) + "_1.jpg");
        }

        listView.setHasFixedSize(true);
        listView.setLayoutManager(new LinearLayoutManager(this));

        final ListAdapter couponAdapter = new ListAdapter(this, R.layout.image, l1);
        listView.setAdapter(couponAdapter);
    }
}