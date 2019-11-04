package com.madipb.technotalk;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface KomunitasDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOneMember(AnggotaEntity anggotaEntity);

}
