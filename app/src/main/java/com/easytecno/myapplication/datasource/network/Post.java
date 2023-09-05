package com.easytecno.myapplication.datasource.network;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.easytecno.myapplication.datasource.room.config.TableDao;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = TableDao.TABLE)
public class Post {
    @PrimaryKey
    @SerializedName(TableDao.ID)
    public int id;
    @SerializedName(TableDao.USER_ID)
    public int userId;
    @SerializedName(TableDao.TITLE)
    public String title;
    @SerializedName(TableDao.BODY)
    public String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
