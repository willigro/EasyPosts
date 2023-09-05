package com.easytecno.myapplication.repository.post;

import android.util.Log;

import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.datasource.network.PostApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepositoryImpl implements PostRepository {

    private PostApi postApi;

    @Inject
    public PostRepositoryImpl(PostApi postApi) {
        this.postApi = postApi;
    }

    @Override
    public Call<List<Post>> fetchPosts() {
        return postApi.getMyData();
    }
}
