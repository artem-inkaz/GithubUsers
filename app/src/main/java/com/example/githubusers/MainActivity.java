package com.example.githubusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.githubusers.adapter.UserAdapter;
import com.example.githubusers.api.GitHubService;
import com.example.githubusers.api.GithubApplication;
import com.example.githubusers.models.Users;
import com.example.githubusers.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.Listener {

   private RecyclerView recyclerView;
   private MainPresenter mainPresenter;
   private Button retryButton;
   private ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.users_recycler);
        retryButton = findViewById(R.id.retry_button);
        retryButton.setOnClickListener(view ->{
            mainPresenter.loadUsers();
            retryButton.setVisibility(View.GONE);
            loadingBar.setVisibility(View.VISIBLE);
        });
        loadingBar = findViewById(R.id.loadingBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // ускоряет работу recyclerView при условии что элементы одиниковы по высоте
        recyclerView.setHasFixedSize(true);

        // проверочный код
//        List<Users> usersList = new ArrayList<>();
//        usersList.add(new Users("Artem", "Строка"));
//        usersList.add(new Users("Artem", "Строка"));
//        usersList.add(new Users("Artem", "Строка"));
//        usersList.add(new Users("Artem", "Строка"));
//
//        recyclerView.setAdapter(new UserAdapter(usersList));
        GitHubService service =((GithubApplication) getApplication()).getGitHubService();
        mainPresenter = new MainPresenter(service, this);
        mainPresenter.loadUsers();
        loadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onUsersLoaded(List<Users> users) {
        loadingBar.setVisibility(View.GONE);
        recyclerView.setAdapter(new UserAdapter(users));
    }

    @Override
    public void onError(String message) {
//       Toast.makeText(this, String.format("error occured: %", message), Toast.LENGTH_SHORT).show();
        loadingBar.setVisibility(View.GONE);
        retryButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.stopLoading();
    }
}