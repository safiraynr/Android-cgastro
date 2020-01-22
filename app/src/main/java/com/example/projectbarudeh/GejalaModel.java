package com.example.projectbarudeh;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties

public class GejalaModel implements Serializable {

    private String jenis_diare;
    private String tipe_dehidrasi;
    private String key;

    public GejalaModel() {
    }


    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getJenis_diare() {
        return jenis_diare;
    }
    public void setJenis_diare(String jenis_diare) {
        this.jenis_diare = jenis_diare;
    }
    public String getTipe_dehidrasi() {
        return tipe_dehidrasi;
    }
    public void setTipe_dehidrasi(String tipe_dehidrasi) {
        this.tipe_dehidrasi = tipe_dehidrasi;
    }

    @Override
    public String toString() {
        return "" + jenis_diare + "\n" +
                "" + tipe_dehidrasi;
    }

    public GejalaModel(String diare, String dehidrasi) {
        jenis_diare = diare;
        tipe_dehidrasi = dehidrasi;


    }


}
