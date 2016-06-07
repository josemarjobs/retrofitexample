package com.kindelbit.retrofitexample.services;

import com.kindelbit.retrofitexample.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by josemarmagalhaes on 6/5/16.
 */
public interface UsersService {

    @GET("users")
    public Call<List<User>> getUsers();

    @GET("users/{id}")
    public Call<User> getUser(@Path("id") String id);

    @POST("users")
    public Call<User> createUser(@Body User user);

    public Call deleteUser();
}
