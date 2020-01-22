package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;


public class Gejala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gejala);

        Intent intent = getIntent();
        String nama = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE);
        String umur = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE2);
        String gender = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE3);
        String jenis = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE4);
        String dehidrasi = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE5);
        String penanganan = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE6);


        TextView etnamaorg = findViewById(R.id.tvhasilnama);
        etnamaorg.setText(nama);

        TextView etusia = findViewById(R.id.tvhasilumur);
        etusia.setText(umur);

        TextView etgender = findViewById(R.id.tvhasilgender);
        etgender.setText(gender);

        TextView etjenis = findViewById(R.id.tvhasiljenis);
        etjenis.setText(jenis);

        TextView etdehidrasi = findViewById(R.id.tvhasildehidrasi);
        etdehidrasi.setText(dehidrasi);

        TextView etpenanganan = findViewById(R.id.tvhasilpenanganan);
        etpenanganan.setText(penanganan);
    }


    public static Intent getActIntent(Activity activity) {
// kode untuk pengambilan Intent

        return new Intent(activity, Gejala.class);

    }

    public void launchmenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void launchtentangdiare(View view) {
        Intent intent = new Intent(this, Tentang_Diare.class);
        startActivity(intent);
    }
}
