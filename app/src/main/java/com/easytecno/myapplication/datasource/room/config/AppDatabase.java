package com.easytecno.myapplication.datasource.room.config;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.datasource.room.dao.PostDao;


@Database(entities = {Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PostDao postDao();

    private static volatile AppDatabase INSTANCE = null;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "easy.db"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}
