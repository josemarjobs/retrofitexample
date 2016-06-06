package com.kindelbit.retrofitexample;

import com.kindelbit.retrofitexample.interfaces.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by josemarmagalhaes on 6/5/16.
 */
public class RetrofitBuilder {
    private static Retrofit retrofit;
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getInstance() {
        return retrofit;
    }
}
