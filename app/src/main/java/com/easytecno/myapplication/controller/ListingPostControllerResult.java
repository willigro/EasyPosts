package com.easytecno.myapplication.controller;

import com.easytecno.myapplication.datasource.network.Post;

import java.util.List;

public interface ListingPostControllerResult {

    void listing(List<Post> list);
}
