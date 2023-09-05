package com.easytecno.myapplication.ui.binding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class BaseBindingActivity<T extends ViewDataBinding> extends AppCompatActivity {

    int layoutId;

    public BaseBindingActivity(int layoutId) {
        this.layoutId = layoutId;
    }

    protected T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, layoutId);
    }
}
