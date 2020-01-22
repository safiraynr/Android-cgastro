package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Read_Pakar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read__pakar);

        Intent intent = getIntent();
        String nama = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE);
        String jenis = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE4);
        String dehidrasi = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE5);
        String rekomendasi = intent.getStringExtra(CekDiagnosis.EXTRA_MESSAGE7);


        EditText etnamaorg = findViewById(R.id.et_namaorg);
        etnamaorg.setText(nama);
        etnamaorg.setEnabled(false);

        EditText etjenis = findViewById(R.id.et_jenis);
        etjenis.setText(jenis);
        etjenis.setEnabled(false);

        EditText etdehidrasi = findViewById(R.id.et_dehidrasiorg);
        etdehidrasi.setText(dehidrasi);
        etdehidrasi.setEnabled(false);

        EditText etrekomen = findViewById(R.id.et_pengobatan);
        etrekomen.setText(rekomendasi);
    }
    public static Intent getActIntent(Activity activity) {
// kode untuk pengambilan Intent

        return new Intent(activity, Read_Pakar.class);

    }

}
