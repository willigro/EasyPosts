package com.easytecno.myapplication.ui.post.listing;

import android.os.Bundle;
import android.view.View;

import com.easytecno.myapplication.R;
import com.easytecno.myapplication.controller.ListingPostController;
import com.easytecno.myapplication.databinding.ActivityListingPostBinding;
import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.ui.binding.BaseBindingActivity;
import com.easytecno.myapplication.ui.post.details.PostDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListingPostActivity extends BaseBindingActivity<ActivityListingPostBinding> {

    RecyclerPostAdapter adapter;

    @Inject
    ListingPostController postController;

    public ListingPostActivity() {
        super(R.layout.activity_listing_post);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchPosts();
    }

    // TODO handle errors
    private void fetchPosts() {
        binding.listingPostProgress.setVisibility(View.VISIBLE);
        postController.fetchPosts(this::createPostAdapter);
    }

    private void createPostAdapter(List<Post> list) {
        adapter = new RecyclerPostAdapter(
                list,
                item -> {
                    startActivity(PostDetailsActivity.getIntent(this, item));
                }
        );

        binding.listingPostRecycler.setAdapter(adapter);
        binding.listingPostProgress.setVisibility(View.GONE);
    }
}