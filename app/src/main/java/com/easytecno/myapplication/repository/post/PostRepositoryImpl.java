package com.easytecno.myapplication.repository.post;

import com.easytecno.myapplication.datasource.network.Post;
import com.easytecno.myapplication.datasource.network.PostApi;
import com.easytecno.myapplication.datasource.room.dao.PostDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PostRepositoryImpl implements PostRepository {

    private final PostApi postApi;
    private final PostDao postDao;

    @Inject
    public PostRepositoryImpl(PostApi postApi, PostDao postDao) {
        this.postApi = postApi;
        this.postDao = postDao;
    }

    @Override
    public Observable<List<Post>> fetchPosts() {
        return postDao.fetchPostsDistinct()
                .flatMap(cachedData -> {
                    if (cachedData != null && !cachedData.isEmpty()) {
                        return Observable.just(cachedData);
                    } else {
                        return postApi.fetchPosts()
                                .subscribeOn(Schedulers.io())
                                .doOnNext(postDao::insert);
                    }
                });
    }

    @Override
    public Observable<Long> insert(Post post) {
        return Observable.create(
                        emitter -> {
                            long result = postDao.insert(post);
                            emitter.onNext(result);
                            emitter.onComplete();
                        }
                )
                .flatMap(result -> Observable.just((Long) result))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public void delete(Post post) {
        Observable.create(
                        emitter -> {
                            postDao.delete(post);
                            emitter.onComplete();
                        }
                )
                .subscribeOn(Schedulers.io()) // TODO move schedulers to DI
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    @Override
    public void update(Post post) {
        Observable.create(
                        emitter -> {
                            postDao.update(post);
                            emitter.onComplete();
                        }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
