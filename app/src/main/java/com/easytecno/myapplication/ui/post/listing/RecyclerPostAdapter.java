package com.easytecno.myapplication.ui.post.listing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.easytecno.myapplication.R;
import com.easytecno.myapplication.datasource.network.Post;

import java.util.List;

public class RecyclerPostAdapter extends RecyclerView.Adapter<RecyclerPostAdapter.ViewHolderPost> {

    List<Post> mPostList;
    RecyclerViewItemClickListener listener;

    public RecyclerPostAdapter(List<Post> list, RecyclerViewItemClickListener listener) {
        this.mPostList = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderPost onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderPost(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.adapter_recycler_listing_post, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPost holder, int position) {
        final Post post = mPostList.get(holder.getAdapterPosition());

        holder.stub.setText(post.title);
        holder.stub.setOnClickListener(
                v -> listener.onItemClick(post.body)
        );
        holder.deleteButton.setOnClickListener(
                v -> listener.onDeleteClick(post)
        );
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    static class ViewHolderPost extends RecyclerView.ViewHolder {

        TextView stub, deleteButton;

        public ViewHolderPost(@NonNull View itemView) {
            super(itemView);
            stub = itemView.findViewById(R.id.adapter_recycler_listing_post_stub_text);
            deleteButton = itemView.findViewById(R.id.adapter_recycler_listing_post_delete);
        }
    }
}
