package com.madipb.technotalk.database;

import com.madipb.technotalk.data.AnggotaEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface KomunitasDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOneMember(AnggotaEntity anggotaEntity);

    @Query("SELECT * FROM anggota_table ORDER BY angkatan DESC")
    List<AnggotaEntity> getAllAnggota();

}
