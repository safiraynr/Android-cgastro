package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variable field tombol-tombol yang sudah dibuat di layout activity_main.xml
    private Button btCekDiagnosisDB;
    private Button btTentangDiareDB;
    private Button btRiwayatDB;
    private Button btEditPakar;
    private Button btTentangcgastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inisialisasi tombol-tombol
        btCekDiagnosisDB = (Button) findViewById(R.id.bt_cekdiagnosis);
        btTentangDiareDB = (Button) findViewById(R.id.bt_tentangdiare);
        btRiwayatDB = (Button) findViewById(R.id.bt_riwayatdiagnosa);
        btTentangcgastro = (Button) findViewById(R.id.bt_tentangcgastro);
     //   btEditPakar = (Button) findViewById(R.id.bt_edit_riwayat);
        //Jika mengklik tombol "Tambahkan Data"

        btCekDiagnosisDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CekDiagnosis.getActIntent(MainActivity.this));
            }
        });
        btRiwayatDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(riwayat_diagnosa.getActIntent(MainActivity.this));
            }
        });
        btTentangDiareDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Tentang_Diare.getActIntent(MainActivity.this));
            }
        });
        btTentangcgastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Tentang_Cgastro.getActIntent(MainActivity.this));
            }
        });


    }

    public void launchlogin(View view) {
        Intent intent = new Intent(this, Login_Pakar.class);
        startActivity(intent);
    }
}