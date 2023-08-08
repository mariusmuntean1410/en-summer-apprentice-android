package com.example.ticketmanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketmanagement.Adapter.EventAdapter;
import com.example.ticketmanagement.Model.EventModel;
import com.example.ticketmanagement.MyApiService;
import com.example.ticketmanagement.R;
import com.example.ticketmanagement.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private RecyclerView eventsView;
    private MyApiService apiService;
    private EventAdapter adapter;
    private String[] ticketOptions = {"Standard","VIP"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(toolbar);
        apiService = RetrofitClient.getRetrofitInstance().create(MyApiService.class);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        eventsView = findViewById(R.id.eventsView);

        adapter = new EventAdapter(this);
        eventsView.setAdapter(adapter);
        eventsView.setLayoutManager(new LinearLayoutManager(this));


        Call<List<EventModel>> call = apiService.getEvents();
        call.enqueue(new Callback<List<EventModel>>() {
            @Override
            public void onResponse(Call<List<EventModel>> call, Response<List<EventModel>> response) {
                if (response.isSuccessful()) {
                    List<EventModel> events = response.body();

                    adapter.setEvents((ArrayList<EventModel>) events);
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<EventModel>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btnSort = toolbar.findViewById(R.id.btnSort);
        ImageButton btnFilter = toolbar.findViewById(R.id.btnFilter);
        ImageButton btnEvents = toolbar.findViewById(R.id.btnEvents);


        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    }

