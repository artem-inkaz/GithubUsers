package com.example.githubusers.presenter;

import android.util.Log;

import com.example.githubusers.api.GitHubService;
import com.example.githubusers.models.Users;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    public  interface Listener {

        public void onUsersLoaded(List<Users> users);
        public void onError(String message);

    }

    private GitHubService gitHubService;
    private Listener listener;
    private Disposable disposable;

    public MainPresenter(GitHubService gitHubService, Listener listener) {
        this.gitHubService = gitHubService;
        this.listener = listener;
    }

    public void loadUsers(){
       disposable = gitHubService.listUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .doOnError(error -> Log.e(MainPresenter.class.getName(),error.toString()))
                .subscribe(users ->listener.onUsersLoaded(users),
                        error->listener.onError(error.getMessage()));
    }

    public void stopLoading(){
        if (disposable != null){
            disposable.dispose();
        }
        listener = null;
    }
}
