package com.easytecno.myapplication.controller.details;

import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.repository.post.PostRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PostDetailsController {

    private final PostRepository postRepository;

    @Inject
    public PostDetailsController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Observable<Long> insert(Post post) {
        return postRepository.insert(post);
    }

    public void update(Post post) {
        postRepository.update(post);
    }
}
