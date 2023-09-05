package com.easytecno.myapplication.repository.di;

import com.easytecno.myapplication.datasource.network.PostApi;
import com.easytecno.myapplication.repository.post.PostRepository;
import com.easytecno.myapplication.repository.post.PostRepositoryImpl;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    PostRepository providesPostRepository(PostApi postApi) {
        return new PostRepositoryImpl(postApi);
    }
}
