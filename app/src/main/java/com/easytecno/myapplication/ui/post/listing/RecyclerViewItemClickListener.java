package com.easytecno.myapplication.ui.post.listing;

import com.easytecno.myapplication.datasource.network.Post;

public interface RecyclerViewItemClickListener {
    void onItemClick(Post item);
    void onDeleteClick(Post post);
}
