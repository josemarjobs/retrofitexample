package com.kindelbit.retrofitexample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kindelbit.retrofitexample.adapters.ImagesAdapter;
import com.kindelbit.retrofitexample.adapters.OnItemClickListener;
import com.kindelbit.retrofitexample.models.Image;
import com.kindelbit.retrofitexample.services.ImagesService;
import com.kindelbit.retrofitexample.services.RetrofitBuilder;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by josemarmagalhaes on 6/9/16.
 */
public class ViewImagesFragment extends Fragment {
    RecyclerView recyclerViewImages;
    LinearLayoutManager linearLayoutManager;
    ImagesAdapter adapter;
    private OnItemClickListener<Image> listener;

    public ViewImagesFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnItemClickListener<Image>) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_images, container, false);

        adapter = new ImagesAdapter(new ArrayList<Image>(), getContext(), listener);
        recyclerViewImages = (RecyclerView) view.findViewById(R.id.recyclerViewImages);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewImages.setLayoutManager(linearLayoutManager);
        recyclerViewImages.setAdapter(adapter);

        getImages();

        return view;
    }

    public void getImages() {
        ImagesService service = RetrofitBuilder.getInstance().create(ImagesService.class);
        service.getImages().enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    adapter.swap(response.body());
                } else {
                    Toast.makeText(getContext(), "Error retrieving images", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {
                Toast.makeText(getContext(), "Error retrieving images", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
