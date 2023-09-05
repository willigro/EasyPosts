package com.easytecno.myapplication.controller;

import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.repository.post.PostRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ListingPostController {

    private final PostRepository postRepository;

    @Inject
    public ListingPostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Observable<List<Post>> fetchPosts() {
        return postRepository.fetchPosts();
    }

    public void deletePost(Post post) {
        postRepository.deletePost(post);
    }
}
