package com.kindelbit.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.kindelbit.retrofitexample.adapters.UsersAdapter;
import com.kindelbit.retrofitexample.models.User;

public class MainActivity extends AppCompatActivity implements UsersAdapter.OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String USER_EXTRA = "user_extra";
    private MainFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add_user) {
            Intent intent = new Intent(this, AddUserActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.menu_refresh_list) {
            fragment.refreshList();
        }

        return true;
    }

    @Override
    public void onItemClick(User item) {
        Intent intent = new Intent(this, UserDetailsActivity.class);
        intent.putExtra(USER_EXTRA, item.toBundle());
        startActivity(intent);
    }
}
