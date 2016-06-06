package com.kindelbit.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by josemarmagalhaes on 6/5/16.
 */
public class AddUserActivity extends AppCompatActivity {
    private static final String TAG = AddUserActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }
}
