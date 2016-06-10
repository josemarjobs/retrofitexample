package com.kindelbit.retrofitexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kindelbit.retrofitexample.models.Image;
import com.squareup.picasso.Picasso;

/**
 * Created by josemarmagalhaes on 6/9/16.
 */
public class ImageViewerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_viewer, container, false);

        Image image = Image.fromBundle(getArguments());
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewer);

        Picasso.with(getContext())
                .load(image.getUrl())
                .placeholder(R.drawable._placeholder)
                .resize(1800, 1800)
                .centerInside()
                .into(imageView);

        return view;
    }
}
