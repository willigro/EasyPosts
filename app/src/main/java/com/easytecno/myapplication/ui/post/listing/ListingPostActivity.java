package com.easytecno.myapplication.ui.post.listing;

import android.os.Bundle;

import com.easytecno.myapplication.R;
import com.easytecno.myapplication.databinding.ActivityListingPostBinding;
import com.easytecno.myapplication.ui.binding.BaseBindingActivity;
import com.easytecno.myapplication.ui.post.details.PostDetailsActivity;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListingPostActivity extends BaseBindingActivity<ActivityListingPostBinding> {

    RecyclerPostAdapter adapter;

    public ListingPostActivity() {
        super(R.layout.activity_listing_post);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> mock = new ArrayList<>();
        mock.add("1");

        adapter = new RecyclerPostAdapter(
                mock,
                item -> {
                    startActivity(PostDetailsActivity.getIntent(this, item));
                }
        );

        binding.recycler.setAdapter(adapter);
    }
}