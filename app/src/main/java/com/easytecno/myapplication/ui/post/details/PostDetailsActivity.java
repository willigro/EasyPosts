package com.easytecno.myapplication.ui.post.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.easytecno.myapplication.R;
import com.easytecno.myapplication.controller.details.PostDetailsController;
import com.easytecno.myapplication.datasource.network.Post;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PostDetailsActivity extends AppCompatActivity {

    static private final String INTENT_PARAM_POST = "ipi";

    private Post mPost;

    @Inject
    PostDetailsController postDetailsController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        mPost = (Post) getIntent().getSerializableExtra(INTENT_PARAM_POST);

        initView();
    }

    private void initView() {
        ((EditText) findViewById(R.id.post_details_title_text)).setText(mPost.title);
        ((EditText) findViewById(R.id.post_details_body_text)).setText(mPost.body);

        findViewById(R.id.post_details_button_save).setOnClickListener(
                v -> {
                    mPost.title = ((EditText) findViewById(R.id.post_details_title_text)).getText().toString();
                    mPost.body = ((EditText) findViewById(R.id.post_details_body_text)).getText().toString();
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