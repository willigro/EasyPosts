package com.easytecno.myapplication.datasource.network;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.easytecno.myapplication.datasource.room.config.TableDao;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = TableDao.TABLE)
public class Post implements Serializable {
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
