package com.kindelbit.retrofitexample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kindelbit.retrofitexample.adapters.UsersAdapter;
import com.kindelbit.retrofitexample.datasource.UsersDatasource;
import com.kindelbit.retrofitexample.services.RetrofitBuilder;
import com.kindelbit.retrofitexample.services.UsersService;
import com.kindelbit.retrofitexample.models.User;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by josemarmagalhaes on 6/5/16.
 */
public class MainFragment extends Fragment {

    private RecyclerView mRecyclerViewUsers;
    private UsersAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private UsersAdapter.OnItemClickListener mListener;
    private Realm mRealm;
    private UsersDatasource mUserDatasource;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (UsersAdapter.OnItemClickListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerViewUsers = (RecyclerView) view.findViewById(R.id.recyclerViewUsers);
        mRecyclerViewUsers.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewUsers.setLayoutManager(mLinearLayoutManager);
        mAdapter = new UsersAdapter(new ArrayList<User>(), mListener);
        mRecyclerViewUsers.setAdapter(mAdapter);

        mRealm = Realm.getDefaultInstance();
        mUserDatasource = new UsersDatasource(mRealm);
        getUsers();

        return view;
    }

    private void getUsersFromTheWeb() {
        Retrofit retrofit = RetrofitBuilder.getInstance();
        UsersService usersService = retrofit.create(UsersService.class);
        Call<List<User>> call = usersService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    mUserDatasource.replaceAll(response.body());
                    getUsers();
                    Log.d("MainFragment", "USERS Returned: " + response.body().size());
                } else {
                    Toast.makeText(getActivity(), "Failed to get data...", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getContext(), "Connection error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void refreshList() {
        getUsersFromTheWeb();
    }

    public void getUsers() {
        mAdapter.swap(mUserDatasource.getUsers());
    }
}
