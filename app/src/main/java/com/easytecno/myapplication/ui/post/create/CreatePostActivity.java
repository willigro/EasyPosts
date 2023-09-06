package com.easytecno.myapplication.ui.post.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.easytecno.myapplication.R;
import com.easytecno.myapplication.controller.details.PostDetailsController;
import com.easytecno.myapplication.databinding.ActivityCreatePostBinding;
import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.ui.binding.BaseBindingActivity;

import java.util.Random;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@AndroidEntryPoint
public class CreatePostActivity extends BaseBindingActivity<ActivityCreatePostBinding> {

    @Inject
    PostDetailsController postDetailsController;

    public CreatePostActivity() {
        super(R.layout.activity_create_post);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        binding.postCreateButtonSave.setOnClickListener(
                v -> {
                    Post post = new Post(
                            new Random().nextInt(),
                            (int) System.currentTimeMillis(), // TODO think about get the id from db and transform it
                            binding.postCreateTitleText.getText().toString(),
                            binding.postCreateBodyText.getText().toString()
                    );
                    Disposable subscribe = postDetailsController.insert(
                                    post
                            ).observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    data -> {
                                        Log.d("TAGGING", String.valueOf(data));
                                        finish();
                                    },
                                    throwable -> {
                                        Log.d("TAGGING", "Error " + throwable.getMessage());
                                        // Handle errors
                                    }
                            );
                    compositeDisposable.add(subscribe);
                }
        );
    }

    static public Intent getIntent(Context context) {
        return new Intent(context, CreatePostActivity.class);
    }
}