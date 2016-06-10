package com.kindelbit.retrofitexample.models;

import android.os.Bundle;

import com.google.gson.annotations.SerializedName;

/**
 * Created by josemarmagalhaes on 6/9/16.
 */
public class Image {
    @SerializedName("_id")
    private String id;
    private String name;
    private String contentType;
    private String originalName;
    private String extension;
    private long size;
    private String url;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString("ID", getId());
        b.putString("URL", getUrl());
        b.putString("NAME", getOriginalName());
        return b;
    }

    public static Image fromBundle(Bundle bundle){
        Image image = new Image();
        image.setId(bundle.getString("ID"));
        image.setOriginalName(bundle.getString("NAME"));
        image.setUrl(bundle.getString("URL"));
        return image;
    }

}
