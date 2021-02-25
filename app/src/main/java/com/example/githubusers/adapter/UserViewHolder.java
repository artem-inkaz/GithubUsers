package com.example.githubusers.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.example.githubusers.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView avatar;
    TextView name;

    public UserViewHolder(@NonNull View itemView){
        super (itemView);
        avatar = itemView.findViewById(R.id.user_avatar_img);
        name = itemView.findViewById(R.id.user_name_txt);
    }
}
