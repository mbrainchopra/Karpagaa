package com.michelbchopra.karpagaaa;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    private static ContactDatabase dbInstance;

    public static synchronized ContactDatabase getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder(context.getApplicationContext(), ContactDatabase.class,
                    "DaoDatabase").fallbackToDestructiveMigration().build();
        }
        return dbInstance;
    }

    public abstract ContactDAO getCantactDAO();


}
