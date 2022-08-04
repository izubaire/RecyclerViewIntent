package com.example.recyclerviewintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private recycleAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnClickListener();
        recycleAdapter adapter = new recycleAdapter(usersList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new recycleAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("username", usersList.get(position).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {
        usersList.add(new User("Husnain"));
        usersList.add(new User("Usman"));
        usersList.add(new User("Usama"));
        usersList.add(new User("Sami"));
        usersList.add(new User("Ali"));
        usersList.add(new User("Bilal"));
        usersList.add(new User("Ahmad"));
        usersList.add(new User("Munawar"));
        usersList.add(new User("Arshad"));

    }

}