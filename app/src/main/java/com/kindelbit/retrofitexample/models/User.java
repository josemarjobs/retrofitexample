package com.kindelbit.retrofitexample.models;

import android.os.Bundle;

import com.google.gson.annotations.SerializedName;

/**
 * Created by josemarmagalhaes on 6/5/16.
 */
public class User {

    @SerializedName("_id")
    private String id;
    private String name;
    private String email;
    @SerializedName("registration_id")
    private String registratinId;

    public User() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Id: " + getId());
        str.append("\nRegistration Id: " + getRegistratinId());
        str.append("\nName: " + getName());
        str.append("\nEmail: " + getEmail());
        return str.toString();
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString("ID", getId());
        b.putString("NAME", getName());
        b.putString("EMAIL", getEmail());
        b.putString("REG_ID", getRegistratinId());
        return b;
    }

    public static User fromBundle(Bundle b) {
        User u = new User();
        u.setId(b.getString("ID"));
        u.setName(b.getString("NAME"));
        u.setEmail(b.getString("EMAIL"));
        u.setRegistratinId(b.getString("REG_ID"));
        return u;
    }

    public String getRegistratinId() {
        return registratinId;
    }

    public void setRegistratinId(String registratinId) {
        this.registratinId = registratinId;
    }

}
