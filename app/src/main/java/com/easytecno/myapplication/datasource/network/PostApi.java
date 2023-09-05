package com.easytecno.myapplication.datasource.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    @GET("posts")
    Call<List<Post>> getMyData();
}