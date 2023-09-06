package com.easytecno.myapplication.ui.post.listing;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.easytecno.myapplication.R;
import com.easytecno.myapplication.controller.listing.ListingPostController;
import com.easytecno.myapplication.databinding.ActivityListingPostBinding;
import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.ui.binding.BaseBindingActivity;
import com.easytecno.myapplication.ui.post.details.PostDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

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
        CompositeDisposable cd = new CompositeDisposable();

        Disposable subscribe = postController.fetchPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        data -> {
                            Log.d("TAGGING", String.valueOf(data.size()));
                            createPostAdapter(data);
                        },
                        throwable -> {
                            Log.d("TAGGING", "Error " + throwable.getMessage());
                            // Handle errors
                        }
                );

        cd.add(subscribe);
    }

    private void createPostAdapter(List<Post> list) {
        adapter = new RecyclerPostAdapter(
                list,
                new RecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(Post post) {
                        startActivity(PostDetailsActivity.getIntent(ListingPostActivity.this, post));
                    }

                    @Override
                    public void onDeleteClick(Post post) {
                        postController.deletePost(post);
                    }
                }
        );

        binding.listingPostRecycler.setAdapter(adapter);
        binding.listingPostProgress.setVisibility(View.GONE);
    }
}