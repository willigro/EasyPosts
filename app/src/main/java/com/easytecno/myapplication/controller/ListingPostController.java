package com.easytecno.myapplication.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.repository.post.PostRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListingPostController {

    private final PostRepository postRepository;

    @Inject
    public ListingPostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void fetchPosts(ListingPostControllerResult listener) {
        postRepository.fetchPosts().enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    listener.listing(response.body());
                    // Handle the data
                } else {
                    Log.d("TAGGING", "error");
                    // Handle the error
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("TAGGING", "onFailure");
                // Handle network failures
            }
        });
    }
}
