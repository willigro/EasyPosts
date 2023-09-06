package com.easytecno.myapplication.ui.binding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import io.reactivex.disposables.CompositeDisposable;

public class BaseBindingActivity<T extends ViewDataBinding> extends AppCompatActivity {

    int layoutId;

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseBindingActivity(int layoutId) {
        this.layoutId = layoutId;
    }

    protected T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, layoutId);
    }

    // TODO, onStop too, but there I need to make sure that the ListingPost is not disposed
    //  when stops, cause it is going to break the link to the room/db
    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
