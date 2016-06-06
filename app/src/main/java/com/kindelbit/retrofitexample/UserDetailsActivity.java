package com.kindelbit.retrofitexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kindelbit.retrofitexample.models.User;

/**
 * Created by josemarmagalhaes on 6/5/16.
 */
public class UserDetailsActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvEmail;
    private TextView tvRegistrationId;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        if (getIntent().hasExtra(MainActivity.USER_EXTRA)) {
            user = User.fromBundle(getIntent().getExtras().getBundle(MainActivity.USER_EXTRA));
            setTitle(user.getName());
        }

        tvName = (TextView) findViewById(R.id.textViewName);
        tvEmail = (TextView) findViewById(R.id.textViewEmail);
        tvRegistrationId = (TextView) findViewById(R.id.textViewRegId);
        tvName.setText(user.getName());
        tvEmail.setText(user.getEmail());
        tvRegistrationId.setText(user.getRegistratinId());
    }
}
