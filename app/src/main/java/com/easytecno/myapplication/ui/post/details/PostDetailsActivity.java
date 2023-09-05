package com.easytecno.myapplication.ui.post.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.easytecno.myapplication.R;

public class PostDetailsActivity extends AppCompatActivity {

    static private final String INTENT_PARAM_ITEM = "ipi";

    private String mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        mItem = getIntent().getStringExtra(INTENT_PARAM_ITEM);

        initView();
    }

    private void initView() {
        ((TextView) findViewById(R.id.stub_text)).setText(mItem);
    }

    static public Intent getIntent(Context context, String item) {
        Intent intent = new Intent(context, PostDetailsActivity.class);

        intent.putExtra(INTENT_PARAM_ITEM, item);

        return intent;
    }
}