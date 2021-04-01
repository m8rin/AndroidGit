package com.example.lab8;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("/greeting/{userName}")
    Call<User> fetchUser(@Path("userName") String userName);
}
