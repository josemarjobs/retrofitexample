package com.kindelbit.retrofitexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kindelbit.retrofitexample.R;
import com.kindelbit.retrofitexample.models.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by josemarmagalhaes on 6/9/16.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder> {

    private List<Image> images;
    private Context context;
    private OnItemClickListener<Image> listener;

    public ImagesAdapter(List<Image> images, Context context, OnItemClickListener<Image> listener) {
        this.images = images;
        this.context = context;
        this.listener = listener;
    }

    public void swap(List<Image> images) {
        this.images = images;
        this.notifyDataSetChanged();
    }

    @Override
    public ImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_list_item, parent, false);
        return new ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImagesViewHolder holder, int position) {
        holder.bind(images.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ImagesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textUsername;

        public ImagesViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageItem);
            textUsername = (TextView) itemView.findViewById(R.id.textUsername);
        }


        public void bind(final Image image, final OnItemClickListener<Image> listener) {
            if (image.getUser() == null) {
                this.textUsername.setText(image.getOriginalName());
            } else {
                this.textUsername.setText(image.getUser().getName());
            }
            Picasso.with(context)
                    .load(image.getUrl())
                    .placeholder(R.drawable._placeholder)
                    .resize(600, 600)
                    .centerCrop()
                    .into(this.imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(image);
                }
            });
        }
    }
}
