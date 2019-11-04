package com.madipb.technotalk;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AnggotaEntity.class}, version = 1, exportSchema = false)
public abstract class KomunitasDatabase extends RoomDatabase {
    private static KomunitasDatabase INSTANCE;
    public abstract KomunitasDAO komunitasDAO();

    public static KomunitasDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (KomunitasDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            KomunitasDatabase.class, "KomunitasDatabase").build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
