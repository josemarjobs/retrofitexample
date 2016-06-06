package com.kindelbit.retrofitexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kindelbit.retrofitexample.R;
import com.kindelbit.retrofitexample.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by josemarmagalhaes on 6/5/16.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private List<User> users = new ArrayList<>();
    private OnItemClickListener mListener;

    public UsersAdapter(List<User> users, OnItemClickListener listener) {
        mListener = listener;
        this.users = users;
    }

    public void swap(List<User> users) {
        this.users = users;
        this.notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(users.get(position), mListener);
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvId;
        TextView tvEmail;
        TextView tvRegistrationId;

        public UserViewHolder(final View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            tvRegistrationId = (TextView) itemView.findViewById(R.id.tvRegistrationId);
        }

        void bind(final User item, final OnItemClickListener listener) {
            tvEmail.setText(item.getEmail());
            tvId.setText(item.getId());
            tvName.setText(item.getName());
            tvRegistrationId.setText(item.getRegistratinId());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(User item);
    }
}
