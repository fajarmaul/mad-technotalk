package com.madipb.technotalk.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/*Model Anggota*/
@Entity(tableName = "anggota_table")
public class AnggotaEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "komunitas")
    private String komunitas;

    @ColumnInfo(name = "angkatan")
    private int angkatan;

    public AnggotaEntity(String nama, String email, String komunitas, int angkatan) {
        this.nama = nama;
        this.email = email;
        this.komunitas = komunitas;
        this.angkatan = angkatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKomunitas() {
        return komunitas;
    }

    public void setKomunitas(String komunitas) {
        this.komunitas = komunitas;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    @Override
    public String toString() {
        return "AnggotaEntity{" +
                "nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", komunitas='" + komunitas + '\'' +
                ", angkatan=" + angkatan +
                '}';
    }
}
