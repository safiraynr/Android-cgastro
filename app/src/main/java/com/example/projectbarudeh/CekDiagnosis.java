package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CekDiagnosis extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "a";
    public static final String EXTRA_MESSAGE2 = "b";
    public static final String EXTRA_MESSAGE3 = "c";
    public static final String EXTRA_MESSAGE4 = "d";
    public static final String EXTRA_MESSAGE5 = "e";
    public static final String EXTRA_MESSAGE6 = "f";
    public static final String EXTRA_MESSAGE7 = "g";
    public static final String EXTRA_MESSAGE8 = "h";
    public static final String EXTRA_MESSAGE9 = "i";
    public static final String EXTRA_MESSAGE10 = "j";

    private DatabaseReference database;

    private Button btn_next1;
    private EditText etNamaorg;
    private EditText etUsia;
    private RadioGroup rgGender;
    private RadioButton rbGender;
    private String stringGender;

    private Button btn_hasil;
    private CheckBox feses1;
    private CheckBox feses2;
    private CheckBox feses3;
    private CheckBox feses4;
    private CheckBox kesadaran1;
    private CheckBox kesadaran2;
    private CheckBox kelopak1;
    private CheckBox kelopak2;
    private CheckBox minum1;
    private CheckBox minum2;
    private CheckBox turgor1;
    private CheckBox turgor2;

    private String stFeses1;
    private String stFeses2;
    private String stFeses3;
    private String stFeses4;
    private String stKesadaran1;
    private String stKesadaran2;
    private String stKelopak1;
    private String stKelopak2;
    private String stMinum1;
    private String stMinum2;
    private String stTurgor1;
    private String stTurgor2;

    private String jenisdiare = "";
    private String tipe = "";
    private String rekomendasi = "";
    private String penangananA;
    private String penangananB;
    private String penangananC;
    private String hasilpenanganan = "";
    private String umur;
    private String nama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_diagnosis);


        etNamaorg = (EditText) findViewById(R.id.et_namaorg);
        etUsia = (EditText) findViewById(R.id.et_usiaorg);
        btn_next1 = (Button) findViewById(R.id.btn_next1);
        rgGender = findViewById(R.id.rb_group);

        penangananA = getString(R.string.text_penangananA);
        penangananB = getString(R.string.text_penangananB);
        penangananC = getString(R.string.text_penangananC);

        feses1 = (CheckBox) findViewById(R.id.cb_feses1);
        feses2 = (CheckBox) findViewById(R.id.cb_feses2);
        feses3 = (CheckBox) findViewById(R.id.cb_feses3);
        feses4 = (CheckBox) findViewById(R.id.cb_feses4);

        kesadaran1 = (CheckBox) findViewById(R.id.cb_kesadaran1);
        kesadaran2 = (CheckBox) findViewById(R.id.cb_kesadaran2);

        kelopak1 = (CheckBox) findViewById(R.id.cb_kelopak1);
        kelopak2 = (CheckBox) findViewById(R.id.cb_kelopak2);

        minum1 = (CheckBox) findViewById(R.id.cb_haus1);
        minum2 = (CheckBox) findViewById(R.id.cb_haus2);

        turgor1 = (CheckBox) findViewById(R.id.cb_turgor1);
        turgor2 = (CheckBox) findViewById(R.id.cb_turgor2);

        feses1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    feses2.setEnabled(false);
                    feses3.setEnabled(false);
                    feses4.setEnabled(false);
                    stFeses1 = "true";
                } else {
                    feses2.setEnabled(true);
                    feses3.setEnabled(true);
                    feses4.setEnabled(true);
                    stFeses1 = "false";
                }
            }
        });
        feses2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    feses1.setEnabled(false);
                    feses3.setEnabled(false);
                    feses4.setEnabled(false);
                    stFeses2 = "true";
                } else {
                    feses1.setEnabled(true);
                    feses3.setEnabled(true);
                    feses4.setEnabled(true);
                    stFeses2 = "false";
                }
            }
        });
        feses3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    feses1.setEnabled(false);
                    feses2.setEnabled(false);
                    feses4.setEnabled(false);
                    stFeses3 = "true";
                } else {
                    feses1.setEnabled(true);
                    feses2.setEnabled(true);
                    feses4.setEnabled(true);
                    stFeses3 = "false";
                }

            }
        });
        feses4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    feses1.setEnabled(false);
                    feses2.setEnabled(false);
                    feses3.setEnabled(false);
                    stFeses4 = "true";
                } else {
                    feses1.setEnabled(true);
                    feses2.setEnabled(true);
                    feses3.setEnabled(true);
                    stFeses4 = "false";
                }
            }
        });
        kesadaran1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    kesadaran2.setEnabled(false);
                    stKesadaran1 = "true";
                } else {
                    kesadaran2.setEnabled(true);
                    stKesadaran1 = "false";
                }
            }
        });
        kesadaran2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    kesadaran1.setEnabled(false);
                    stKesadaran2 = "true";
                } else {
                    kesadaran1.setEnabled(true);
                    stKesadaran2 = "false";
                }
            }
        });
        kelopak1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    kelopak2.setEnabled(false);
                    stKelopak1 = "true";
                } else {
                    kelopak2.setEnabled(true);
                    stKelopak1 = "false";
                }


            }
        });
        kelopak2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    kelopak1.setEnabled(false);
                    stKelopak2 = "true";
                } else {
                    kelopak1.setEnabled(true);
                    stKelopak2 = "false";
                }
            }
        });
        minum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    minum2.setEnabled(false);
                    stMinum1 = "true";
                } else {
                    minum2.setEnabled(true);
                    stMinum1 = "false";
                }
            }
        });
        minum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    minum1.setEnabled(false);
                    stMinum2 = "true";
                } else {
                    minum1.setEnabled(true);
                    stMinum2 = "false";
                }
            }
        });
        turgor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    turgor2.setEnabled(false);
                    stTurgor1 = "true";
                } else {
                    turgor2.setEnabled(true);
                    stTurgor1 = "false";
                }
            }
        });
        turgor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    turgor1.setEnabled(false);
                    stTurgor2 = "true";
                } else {
                    turgor1.setEnabled(true);
                    stTurgor2 = "false";
                }
            }
        });
        if (!"true".equals(stFeses1)) {
            stFeses1 = "false";
        }
        if (!"true".equals(stFeses2)) {
            stFeses2 = "false";
        }
        if (!"true".equals(stFeses3)) {
            stFeses3 = "false";
        }
        if (!"true".equals(stKesadaran1)) {
            stKesadaran1 = "false";
        }
        if (!"true".equals(stKesadaran2)) {
            stKesadaran1 = "false";
        }
        if (!"true".equals(stKelopak1)) {
            stKelopak1 = "false";
        }
        if (!"true".equals(stKelopak2)) {
            stKelopak2 = "false";
        }
        if (!"true".equals(stMinum1)) {
            stMinum1 = "false";
        }
        if (!"true".equals(stMinum2)) {
            stMinum2 = "false";
        }
        if (!"true".equals(stTurgor1)) {
            stTurgor1 = "false";
        }
        if (!"true".equals(stTurgor2)) {
            stTurgor2 = "false";
        }

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rbGender = rgGender.findViewById(checkedId);
                switch (checkedId) {
                    case R.id.rb_female:
                        stringGender = rbGender.getText().toString();
                        break;
                    case R.id.rb_male:
                        stringGender = rbGender.getText().toString();
                        break;
                }
            }
        });

        database = FirebaseDatabase.getInstance().getReference();
        final profil profil = (profil) getIntent().getSerializableExtra("data");

        // kode yang dipanggil ketika tombol Submit diklik
        if (profil != null) {
            etNamaorg.setText(profil.getNamaorg());
            etUsia.setText(profil.getUsia());
            btn_next1.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {
                    profil.setNamaorg(etNamaorg.getText().toString());
                    profil.setUsia(etUsia.getText().toString());
                    updateprofil(profil);
                }

            });
        } else {
            btn_next1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {


                    if (!isEmpty(etNamaorg.getText().toString()) &&
                            !isEmpty(etUsia.getText().toString()) && !isEmpty(stringGender.toString())) {
                        nama = etNamaorg.getText().toString();
                        umur = etUsia.getText().toString();

                        //1
                        if (feses1.isChecked()) {
                            hasilpenanganan = penangananA;
                            jenisdiare = "Disentri";
                            tipe = "Tanpa Dehidrasi";
                            rekomendasi = "-";

                        }
                        //2
                        else if (feses1.isChecked() && kesadaran1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                            rekomendasi = "-";
                        }
                        //3
                        else if (feses1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //4
                        else if (feses1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //5
                        else if (feses1.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //6
                        if (feses1.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //7
                        if (feses1.isChecked() && kesadaran2.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //8
                        if (feses1.isChecked() && kesadaran2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //9
                        if (feses1.isChecked() && kelopak1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //10
                        if (feses1.isChecked() && kelopak1.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //11
                        if (feses1.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //12
                        if (feses1.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //13
                        if (feses1.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //14
                        if (feses1.isChecked() && kesadaran2.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //15
                        if (feses1.isChecked() && kelopak1.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //16
                        if (feses1.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Ringan/Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //17
                        if (feses1.isChecked() && kesadaran1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //18
                        if (feses1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //19
                        if (feses1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //20
                        if (feses1.isChecked() && kesadaran1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //21
                        if (feses1.isChecked() && kesadaran1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //22
                        if (feses1.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //23
                        if (feses1.isChecked() && kelopak1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //24
                        if (feses1.isChecked() && kelopak1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //25
                        if (feses1.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //26
                        if (feses1.isChecked() && kesadaran1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //27
                        if (feses1.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //28
                        if (feses1.isChecked() && kesadaran1.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //29
                        if (feses1.isChecked() && kelopak1.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //30
                        if (feses1.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Disentri";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //31
                        if (feses2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Tanpa Dehidrasi";
                            hasilpenanganan = penangananA;
                        }
                        //32
                        if (feses2.isChecked() && kesadaran2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //33
                        if (feses2.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //34
                        if (feses2.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //35
                        if (feses2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //36
                        if (feses2.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //37
                        if (feses2.isChecked() && kesadaran2.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //38
                        if (feses2.isChecked() && kesadaran2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //39
                        if (feses2.isChecked() && kelopak1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //40
                        if (feses2.isChecked() && kelopak1.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //41
                        if (feses2.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //42
                        if (feses2.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //43
                        if (feses2.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //44
                        if (feses2.isChecked() && kesadaran2.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //45
                        if (feses2.isChecked() && kelopak1.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //46
                        if (feses2.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //47
                        if (feses2.isChecked() && kesadaran1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //48
                        if (feses2.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //49
                        if (feses2.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //50
                        if (feses2.isChecked() && kesadaran1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //51
                        if (feses2.isChecked() && kesadaran1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //52
                        if (feses2.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //53
                        if (feses2.isChecked() && kelopak1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //54
                        if (feses2.isChecked() && kelopak1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //55
                        if (feses2.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //56
                        if (feses2.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //57
                        if (feses2.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //58
                        if (feses2.isChecked() && kesadaran1.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //59
                        if (feses2.isChecked() && kelopak1.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //60
                        if (feses2.isChecked() && kesadaran1.isChecked() && minum1.isChecked() && turgor1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Kolera";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //61
                        if (feses3.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Tanpa Dehidrasi";
                            hasilpenanganan = penangananA;
                        }
                        //62
                        if (feses3.isChecked() && kesadaran2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //63
                        if (feses3.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //64
                        if (feses3.isChecked() && kesadaran2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //65
                        if (feses3.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //66
                        if (feses3.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //67
                        if (feses3.isChecked() && kesadaran2.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //68
                        if (feses3.isChecked() && kesadaran2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //69
                        if (feses3.isChecked() && kelopak1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //70
                        if (feses3.isChecked() && kesadaran2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //71
                        if (feses3.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //72
                        if (feses3.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //73
                        if (feses3.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //74
                        if (feses3.isChecked() && kesadaran2.isChecked() && turgor2.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //75
                        if (feses3.isChecked() && turgor2.isChecked() && kelopak1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //76
                        if (feses3.isChecked() && kesadaran2.isChecked() && kelopak1.isChecked() && minum2.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //77
                        if (feses3.isChecked() && kesadaran1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //78
                        if (feses3.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //79
                        if (feses3.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //80
                        if (feses3.isChecked() && kesadaran1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //81
                        if (feses3.isChecked() && kesadaran1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //82
                        if (feses3.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //83
                        if (feses3.isChecked() && kelopak1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //84
                        if (feses3.isChecked() && kelopak1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //85
                        if (feses3.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //86
                        if (feses3.isChecked() && kesadaran1.isChecked() && minum1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //87
                        if (feses3.isChecked() && kesadaran1.isChecked() && turgor1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //88
                        if (feses3.isChecked() && kesadaran1.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //89
                        if (feses3.isChecked() && kelopak1.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //90
                        if (feses3.isChecked() && kesadaran1.isChecked() && minum1.isChecked() && kelopak1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Diare Biasa";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //91
                        if (feses4.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Tanpa Dehidrasi";
                            hasilpenanganan = penangananA;
                        }
                        //92
                        if (feses4.isChecked() && kesadaran1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //93
                        if (feses4.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //94
                        if (feses4.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //95
                        if (feses4.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //96
                        if (feses4.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //97
                        if (feses4.isChecked() && kesadaran1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //98
                        if (feses4.isChecked() && kesadaran1.isChecked() && turgor2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //99
                        if (feses4.isChecked() && kelopak1.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //100
                        if (feses4.isChecked() && turgor2.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //101
                        if (feses4.isChecked() && turgor2.isChecked() && minum2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //102
                        if (feses4.isChecked() && kesadaran1.isChecked() && minum2.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //103
                        if (feses4.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked() & turgor2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //104
                        if (feses4.isChecked() && kesadaran1.isChecked() && minum2.isChecked() & turgor2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //105
                        if (feses4.isChecked() && kelopak1.isChecked() && minum2.isChecked() & turgor2.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //106
                        if (feses4.isChecked() && kesadaran1.isChecked() && minum2.isChecked() & turgor2.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Sedang";
                            hasilpenanganan = penangananB;
                        }
                        //107
                        if (feses4.isChecked() && kesadaran1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //108
                        if (feses4.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //109
                        if (feses4.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //110
                        if (feses4.isChecked() && kesadaran1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //111
                        if (feses4.isChecked() && kesadaran1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //112
                        if (feses4.isChecked() && kesadaran1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //113
                        if (feses4.isChecked() && kelopak1.isChecked() && minum1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //114
                        if (feses4.isChecked() && kelopak1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //115
                        if (feses4.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //116
                        if (feses4.isChecked() && kesadaran2.isChecked() && minum1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //117
                        if (feses4.isChecked() && kesadaran2.isChecked() && turgor1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //118
                        if (feses4.isChecked() && kesadaran2.isChecked() && minum1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //119
                        if (feses4.isChecked() && turgor1.isChecked() && minum1.isChecked() && kelopak1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }
                        //120
                        if (feses4.isChecked() && kesadaran2.isChecked() && minum1.isChecked() && kelopak1.isChecked() && turgor1.isChecked()) {
                            jenisdiare = "Giardiasis";
                            tipe = "Dehidrasi Berat";
                            hasilpenanganan = penangananC;
                        }

                        //mengisi data hasil diagnosis ke database
                        submitprofil(new profil(etNamaorg.getText().toString(), etUsia.getText().toString(), stringGender.toString(), jenisdiare, tipe, hasilpenanganan,
                                rekomendasi));
                    } else
                        Snackbar.make(findViewById(R.id.btn_next1), "data nga bole kosong", Snackbar.LENGTH_LONG).show();
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            etNamaorg.getWindowToken(), 0);


                }


            });

        }

    }


    private boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);
    }

    private void updateprofil(profil profil) {
        database.child("profil") //akses parent index, ibaratnya seperti nama tabel
                .child(profil.getKey()) //select barang berdasarkan key
                .setValue(profil) //set value barang yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {

                    @Override

                    public void onSuccess(Void aVoid) {
                        Snackbar.make(findViewById(R.id.btn_next1), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new
                                View.OnClickListener() {

                                    @Override

                                    public void onClick(View view) {
                                        finish();
                                    }

                                }).show();

                    }

                });
    }

    private void submitprofil(profil profil) {
        database.child("profil").push().setValue(profil).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNamaorg.setText("");
                etUsia.setText("");


//                String jns = "";
//                String tipe = "";
//
//                if(feses1.isChecked()){
//                    jns += "Disentri";
//                    tipe += "Tanpa Dehidrasi";
//                }
//                else if (feses1.isChecked() && kesadaran1.isChecked()){
//                    jns += "Disentri";
//                    tipe += "Dehidrasi Sedang";
//                }


                Snackbar.make(findViewById(R.id.btn_next1), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(CekDiagnosis.this, Gejala.class);
                intent.putExtra(EXTRA_MESSAGE, nama);
                intent.putExtra(EXTRA_MESSAGE2, umur);
                intent.putExtra(EXTRA_MESSAGE3, stringGender);
                intent.putExtra(EXTRA_MESSAGE4, jenisdiare);
                intent.putExtra(EXTRA_MESSAGE5, tipe);
                intent.putExtra(EXTRA_MESSAGE6, hasilpenanganan);
                intent.putExtra(EXTRA_MESSAGE7, rekomendasi);
                startActivity(intent);
//                Intent i = new Intent (CekDiagnosis.this, Menu_Pakar.class);
//                i.putExtra(EXTRA_MESSAGE,nama);
//                i.putExtra(EXTRA_MESSAGE2,umur);
//                i.putExtra(EXTRA_MESSAGE4, jenisdiare);
//                i.putExtra(EXTRA_MESSAGE5, tipe);
//                i.putExtra(EXTRA_MESSAGE7, rekomendasi);
//                startActivity(i);
            }

        });

    }


    public static Intent getActIntent(Activity activity) {
// kode untuk pengambilan Intent

        return new Intent(activity, CekDiagnosis.class);

    }

}
