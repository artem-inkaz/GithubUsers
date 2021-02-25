package com.example.githubusers.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.githubusers.R;
import com.example.githubusers.models.Users;

import java.util.List;

// адаптер cодержит пользователей которых мы скачали  из интернета
public class UserAdapter extends RecyclerView.Adapter {

    private List<Users> users;

    public UserAdapter(List<Users> users) {
        this.users = users;
    }

    // здесь создаем UserViewHolder
    @NonNull
    @Override  // передаем view
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user,viewGroup,false);
        return new UserViewHolder(view);
    }
    // когда элемент списка появляется на экране
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        UserViewHolder holder = (UserViewHolder) viewHolder;
        // getName() это getter из Users
        holder.name.setText(users.get(position).getName());
        Glide.with(holder.avatar)
                .load(users.get(position).getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.avatar);
    }
    // сколько элементов будет в списке
    @Override
    public int getItemCount() {
        return users.size();
    }
}
