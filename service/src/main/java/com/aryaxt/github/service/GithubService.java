package com.aryaxt.github.service;

import com.aryaxt.github.service.models.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @GET("users/{user}/repos")
    Call<List<Repository>> fetchRepositories(@Path("user") String user);

}
