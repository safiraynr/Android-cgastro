package com.example.projectbarudeh;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectbarudeh.R;
import com.example.projectbarudeh.profil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class AdapterRiwayatRecyclerView extends RecyclerView.Adapter<AdapterRiwayatRecyclerView.ViewHolder>{
    private ArrayList<profil> daftarRiwayat;
    private Context context;
    AdapterRiwayatRecyclerView.FirebaseDataListener listener;

    public AdapterRiwayatRecyclerView(ArrayList<profil> profils, Context ctx){
/**
 * Inisiasi data dan variabel yang akan digunakan
 */
        daftarRiwayat = profils;
        context = ctx;
        listener = (riwayat_diagnosa)ctx;

    }
     class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvnama, tvusia, tvjenis, tvdehidrasi, tvrekomendasi;
        ViewHolder(View vw) {
            super(vw);
            tvnama = (TextView) vw.findViewById(R.id.tvriwayatnama);
            tvusia = (TextView) vw.findViewById(R.id.tvriwayatusia);
            tvjenis = (TextView) vw.findViewById(R.id.tvriwayatdiare);
            tvdehidrasi = (TextView) vw.findViewById(R.id.tvriwayatdehidrasi);
            tvrekomendasi = (TextView)vw.findViewById(R.id.tvrekomendasi);

        }
    }

    @Override
    public AdapterRiwayatRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.riwayat_diagnosa, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        AdapterRiwayatRecyclerView.ViewHolder vh = new AdapterRiwayatRecyclerView.ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(AdapterRiwayatRecyclerView.ViewHolder holder, final int position) {

        final String nama = daftarRiwayat.get(position).getNamaorg();
        System.out.println("BARANG DATA one by one " + position + daftarRiwayat.size());
        holder.tvnama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final String umur = daftarRiwayat.get(position).getUsia();
        System.out.println("BARANG DATA one by one " + position + daftarRiwayat.size());
        holder.tvusia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final String jenis = daftarRiwayat.get(position).getJenis_diare();
        System.out.println("BARANG DATA one by one " + position + daftarRiwayat.size());
        holder.tvjenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final String dehidrasi = daftarRiwayat.get(position).getTipe_dehidrasi();
        System.out.println("BARANG DATA one by one " + position + daftarRiwayat.size());
        holder.tvdehidrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final String rekomendasi = daftarRiwayat.get(position).getTipe_dehidrasi();
        System.out.println("BARANG DATA one by one " + position + daftarRiwayat.size());
        holder.tvrekomendasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        holder.tvnama.setText(daftarRiwayat.get(position).getNamaorg());
        holder.tvusia.setText(daftarRiwayat.get(position).getUsia());
        holder.tvjenis.setText(daftarRiwayat.get(position).getJenis_diare());
        holder.tvdehidrasi.setText(daftarRiwayat.get(position).getTipe_dehidrasi());
        holder.tvrekomendasi.setText(daftarRiwayat.get(position).getRekomen_obat());
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarRiwayat.size();
    }

    public interface FirebaseDataListener {
        void onDeleteData(profil profil, int position);
    }
}
