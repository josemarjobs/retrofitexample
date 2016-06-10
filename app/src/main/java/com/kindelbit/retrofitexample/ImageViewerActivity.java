package com.kindelbit.retrofitexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by josemarmagalhaes on 6/9/16.
 */
public class ImageViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        ImageViewerFragment fragment = new ImageViewerFragment();
        fragment.setArguments(getIntent().getBundleExtra(ViewImagesActivity.EXTRA_IMAGE));

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.imageViewerContainer, fragment)
                .commit();

    }

}
