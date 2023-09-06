package com.easytecno.myapplication.repository.post;

import com.easytecno.myapplication.datasource.network.Post;

import java.util.List;

import io.reactivex.Observable;

public interface PostRepository {
    Observable<List<Post>> fetchPosts();

    Observable<Long> insert(Post post);

    void delete(Post post);

    void update(Post post);
}

