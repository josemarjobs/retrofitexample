package com.kindelbit.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kindelbit.retrofitexample.adapters.OnItemClickListener;
import com.kindelbit.retrofitexample.models.Image;

/**
 * Created by josemarmagalhaes on 6/9/16.
 */
public class ViewImagesActivity extends AppCompatActivity implements OnItemClickListener<Image> {

    public static final String EXTRA_IMAGE = "extra_image_item";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_images);
    }

    @Override
    public void onItemClick(Image item) {
        Intent intent = new Intent(this, ImageViewerActivity.class);
        intent.putExtra(EXTRA_IMAGE, item.toBundle());
        startActivity(intent);
    }
}
