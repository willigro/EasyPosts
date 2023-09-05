package com.easytecno.myapplication.repository.post;

import com.easytecno.myapplication.datasource.network.Post;

import java.util.List;

import retrofit2.Call;

public interface PostRepository {
    Call<List<Post>> fetchPosts();
}

