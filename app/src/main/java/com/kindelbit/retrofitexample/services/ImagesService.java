package com.kindelbit.retrofitexample.services;

import com.kindelbit.retrofitexample.models.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by josemarmagalhaes on 6/9/16.
 */
public interface ImagesService {

    @GET("images")
    Call<List<Image>> getImages();
}
