package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu_Pakar extends AppCompatActivity implements AdapterPakarRecyclerView.FirebaseDataListener {

    private DatabaseReference database;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<profil> daftarBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__pakar);

        rvView = (RecyclerView) findViewById(R.id.rv_pakar);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        database = FirebaseDatabase.getInstance().getReference();

        database.child("profil").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                daftarBarang = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {

                    profil profil = noteDataSnapshot.getValue(profil.class);
                    profil.setKey(noteDataSnapshot.getKey());
                    daftarBarang.add(profil);
                }
                adapter = new AdapterPakarRecyclerView(daftarBarang, Menu_Pakar.this);
                rvView.setAdapter(adapter);
            }

            public void onCancelled(DatabaseError databaseError) {


                System.out.println(databaseError.getDetails() + " " + databaseError.getMessage());
            }
        });
    }
    public static Intent getActIntent(Activity activity){
        return new Intent(activity, Menu_Pakar.class);
    }

    @Override
    public void onDeleteData(profil profil, final int position) {

        if(database!=null){ database.child("profil").child(profil.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(Menu_Pakar.this,"success delete", Toast.LENGTH_LONG).show();
            }
        });

        }

    }
}




