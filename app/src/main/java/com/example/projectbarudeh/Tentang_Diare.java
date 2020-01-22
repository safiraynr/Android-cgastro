package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Tentang_Diare extends AppCompatActivity {

    public static Intent getActIntent(MainActivity mainActivity) {
        return new Intent(mainActivity, Tentang_Diare.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang__diare);

    }
}
