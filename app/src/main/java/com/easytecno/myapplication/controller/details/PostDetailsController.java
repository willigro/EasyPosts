package com.easytecno.myapplication.controller.details;

import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.repository.post.PostRepository;

import javax.inject.Inject;

public class PostDetailsController {

    private final PostRepository postRepository;

    @Inject
    public PostDetailsController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void update(Post post) {
        postRepository.update(post);
    }
}
