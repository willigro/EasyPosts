package com.easytecno.myapplication.datasource.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostApi {
    @GET("posts")
    Observable<List<Post>> fetchPosts();
}