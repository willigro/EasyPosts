package com.easytecno.myapplication.datasource.room.di;

import android.content.Context;

import com.easytecno.myapplication.datasource.room.config.AppDatabase;
import com.easytecno.myapplication.datasource.room.dao.PostDao;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

import javax.inject.Singleton;


@Module
@InstallIn(SingletonComponent.class)
public class AppDatabaseModule {

    @Singleton
    @Provides
    AppDatabase provideDatabase(@ApplicationContext Context context) {
        return AppDatabase.getDatabase(context);
    }

    @Singleton
    @Provides
    PostDao providePostDao(AppDatabase appDatabase) {
        return appDatabase.postDao();
    }
}
