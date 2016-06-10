package com.kindelbit.retrofitexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kindelbit.retrofitexample.models.User;
import com.kindelbit.retrofitexample.services.RetrofitBuilder;
import com.kindelbit.retrofitexample.services.UsersService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by josemarmagalhaes on 6/5/16.
 */
public class AddUserFragment extends Fragment implements View.OnClickListener {
    private EditText etName;
    private EditText etEmail;
    private EditText etRegistrationId;
    private Button buttonSave;

    public AddUserFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        etName = (EditText) view.findViewById(R.id.etName);
        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etRegistrationId = (EditText) view.findViewById(R.id.etRegistrationId);
        buttonSave = (Button) view.findViewById(R.id.btnSaveUser);
        buttonSave.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        User user = new User();
        user.setName(etName.getText().toString());
        user.setEmail(etEmail.getText().toString());
        user.setRegistratinId(etRegistrationId.getText().toString());

        saveUser(user);
    }

    private void saveUser(User user) {
        Retrofit retrofit = RetrofitBuilder.getInstance();
        UsersService service = retrofit.create(UsersService.class);
        Call<User> call = service.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getContext(), response.body().toString() + "\nSaved", Toast.LENGTH_SHORT).show();
                getActivity().setResult(Activity.RESULT_OK);
                getActivity().finish();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), "Error saving data. Try again.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
