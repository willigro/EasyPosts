package com.easytecno.myapplication.repository.post;

import io.reactivex.Completable;

public interface PostRepositoryRegisterPostListener {
    void registering(Completable completable);
}
