package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Akun_Pakar extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Akun_Pakar";
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private Button btnKeluar;
    private String userID;
    private String userEMAIL;
    private TextView idnya, emailnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun__pakar);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        btnKeluar = (Button) findViewById(R.id.btn_keluar);


        btnKeluar.setOnClickListener(this);

        idnya = findViewById(R.id.tvidpakar);
        emailnya = findViewById(R.id.tvemailpakar);

        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        userEMAIL = user.getEmail();

        idnya.setText("Id : "+userID);
        emailnya.setText("Email : "+userEMAIL);


    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_keluar) {
            signOut();

            Toast.makeText(Akun_Pakar.this, "Anda berhasi keluar !",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Akun_Pakar.this, MainActivity.class));
        }
    }

    private void signOut() {
        mAuth.signOut();
    }

    public void launchriwayatpakar(View view) {
            Intent intent = new Intent(this, Menu_Pakar.class);
            startActivity(intent);

    }
}
