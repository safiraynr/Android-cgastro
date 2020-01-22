package com.example.projectbarudeh;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class profil implements Serializable {
    private String namaorg;
    private String usia;
    private  String gender;
    private String jenis_diare;
    private String tipe_dehidrasi;
    private String hasil_penanganan;
    private String rekomen_obat;
    private String key;

    public profil(){}

    public String getKey(){
        return key;
    }
    public void setKey(String key){
        this.key = key;
    }
    public String getNamaorg(){
        return namaorg;
    }
    public void setNamaorg(String namaorg){
        this.namaorg = namaorg;
    }
    public String getUsia(){
        return usia;
    }
    public void setUsia(String usia){
        this.usia = usia;
    }
    public String getGender(){return gender;}
    public void setGender(){this.gender = gender;}
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
    public String getHasil_penanganan(){return hasil_penanganan;}
    public void setHasil_penanganan(String hasil_penanganan){this.hasil_penanganan = hasil_penanganan;}
    public String getRekomen_obat(){return  rekomen_obat;}
    public void setRekomen_obat(String rekomen_obat){this.rekomen_obat = rekomen_obat;}




    @Override
    public String toString(){
        return ""+namaorg+"\n"+
                ""+usia+"\n"+
                ""+gender+"\n"+
                ""+ jenis_diare + "\n" +
                "" + tipe_dehidrasi+"\n"+
                "" + hasil_penanganan+"\n"+
                ""+ rekomen_obat;
    }
    public profil(String no,String umr, String gdr,String diare, String dehidrasi, String penanganan, String rekomen){
        namaorg = no;
        usia = umr;
        gender = gdr;
        jenis_diare = diare;
        tipe_dehidrasi = dehidrasi;
        hasil_penanganan = penanganan;
        rekomen_obat = rekomen;


    }
}

