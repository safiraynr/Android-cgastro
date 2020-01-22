package com.example.projectbarudeh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class riwayat_diagnosa extends AppCompatActivity implements AdapterRiwayatRecyclerView.FirebaseDataListener {


    private DatabaseReference database;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<profil> daftarRiwayat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mengeset layout
        setContentView(R.layout.activity_riwayat_diagnosa);


       // Inisialisasi Recyclerview dan komponennya
        rvView = (RecyclerView) findViewById(R.id.rv_riwayat);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);
        //Inisialisasi dan mengambil Firebase Database Reference
        database = FirebaseDatabase.getInstance().getReference();
        //Mengambil data barang dari Firebase Realtime DB
        database.child("profil").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Saat ada data baru, masukkan datanya ke ArrayList
                daftarRiwayat = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    /**
                     * Mapping data pada DataSnapshot ke dalam object Barang
                     * Dan juga menyimpan primary key pada object Barang
                     * untuk keperluan Edit dan Delete data
                     */
                    profil profil = noteDataSnapshot.getValue(profil.class);
                    profil.setKey(noteDataSnapshot.getKey());
                    /**
                     * Menambahkan object Barang yang sudah dimapping
                     * ke dalam ArrayList
                     */
                    daftarRiwayat.add(profil);
                }
                    /**
                     * Inisialisasi adapter dan data barang dalam bentuk ArrayList
                     * dan mengeset Adapter ke dalam RecyclerView
                     */
                adapter = new AdapterRiwayatRecyclerView(daftarRiwayat, riwayat_diagnosa.this);
                rvView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            /**
             * Kode ini akan dipanggil ketika ada error dan
             * pengambilan data gagal dan memprint error nya
             * ke LogCat
             */
                            System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });

    }


    public static Intent getActIntent(Activity activity){
        return new Intent(activity, riwayat_diagnosa.class);
    }

    @Override
    public void onDeleteData(profil profil, final int position) {

        /**

                * Kode ini akan dipanggil ketika method onDeleteData
         * dipanggil dari adapter lewat interface.
         * Yang kemudian akan mendelete data di Firebase Realtime DB
         * berdasarkan key barang.
         * Jika sukses akan memunculkan Toast
         */
        if(database!=null){ database.child("profil").child(profil.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(riwayat_diagnosa.this,"success delete", Toast.LENGTH_LONG).show();
            }
        });
        }
    }

}
