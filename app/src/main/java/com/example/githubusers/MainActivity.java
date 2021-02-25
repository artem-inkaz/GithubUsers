package com.example.githubusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.githubusers.adapter.UserAdapter;
import com.example.githubusers.models.Users;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.users_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // ускоряет работу recyclerView при условии что элементы одиниковы по высоте
        recyclerView.setHasFixedSize(true);

        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("Artem", "Строка"));
        usersList.add(new Users("Artem", "Строка"));
        usersList.add(new Users("Artem", "Строка"));
        usersList.add(new Users("Artem", "Строка"));


        recyclerView.setAdapter(new UserAdapter(usersList));

    }
}