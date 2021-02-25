package com.example.githubusers.api;

import com.example.githubusers.models.Users;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// код скоппирован с https://square.github.io/retrofit/
public interface GitHubService {
    @GET("users")
    // Call заменяем на Single класс RxJava
    Single<List<Users>> listUsers();
}
