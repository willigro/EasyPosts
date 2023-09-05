package com.easytecno.myapplication.datasource.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.easytecno.myapplication.datasource.network.Post;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Post> posts);

    @Query("SELECT * FROM tb_post;")
    Observable<List<Post>> fetchPosts();

    @Delete
    void delete(Post post);

    // TODO Called again after insert, didn't need to, but it is fine now
    default Observable<List<Post>> fetchPostsDistinct() {
        return fetchPosts().distinctUntilChanged();
    }
}
