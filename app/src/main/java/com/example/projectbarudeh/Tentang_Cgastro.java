package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Tentang_Cgastro extends AppCompatActivity {

    public static Intent getActIntent(Activity activity) {
        return new Intent(activity, Tentang_Cgastro.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang__cgastro);

    }

}
