package com.easytecno.myapplication.ui.post.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.easytecno.myapplication.R;
import com.easytecno.myapplication.controller.details.PostDetailsController;
import com.easytecno.myapplication.databinding.ActivityPostDetailsBinding;
import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.ui.binding.BaseBindingActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

// TODO use fragments to handle update and insert?
@AndroidEntryPoint
public class PostDetailsActivity extends BaseBindingActivity<ActivityPostDetailsBinding> {

    static private final String INTENT_PARAM_POST = "ipi";

    private Post mPost;

    @Inject
    PostDetailsController postDetailsController;

    public PostDetailsActivity() {
        super(R.layout.activity_post_details);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPost = (Post) getIntent().getSerializableExtra(INTENT_PARAM_POST);

        initView();
    }

    private void initView() {
        binding.postDetailsTitleText.setText(mPost.title);
        binding.postDetailsBodyText.setText(mPost.body);
        binding.postDetailsButtonSave.setOnClickListener(
                v -> {
                    mPost.title = binding.postDetailsTitleText.getText().toString();
                    mPost.body = binding.postDetailsBodyText.getText().toString();
                    postDetailsController.update(
                            mPost
                    );
                }
        );
    }

    static public Intent getIntent(Context context, Post post) {
        Intent intent = new Intent(context, PostDetailsActivity.class);

        intent.putExtra(INTENT_PARAM_POST, post);

        return intent;
    }
}