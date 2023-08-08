package com.example.ticketmanagement.Activity;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ticketmanagement.Model.EventModel;
import com.example.ticketmanagement.MyApiService;
import com.example.ticketmanagement.R;
import com.example.ticketmanagement.RetrofitClient;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initializeComponents();
    }

    private void initializeComponents() {
        // Find the button in the layout
        MaterialButton buttonGetEvents = findViewById(R.id.getEventsButton);

        buttonGetEvents.setOnClickListener(view -> {
            // Call the API when the button is clicked
            getEvents();
        });
    }

    private void getEvents() {
        RetrofitClient retrofitService = new RetrofitClient();
        MyApiService apiService = retrofitService.getRetrofitInstance().create(MyApiService.class);

        apiService.getEvents().enqueue(new Callback<List<EventModel>>() {
            @Override
            public void onResponse(Call<List<EventModel>> call, Response<List<EventModel>> response) {
                if (response.isSuccessful()) {
                    List<EventModel> events = response.body();
                    // Process the list of events here
                    if (events != null && !events.isEmpty()) {
                        // Handle the events list as needed
                        // For example, display the event names in a Toast
                        StringBuilder message = new StringBuilder();
                        for (EventModel event : events) {
                            message.append(event.getEventName()).append("\n");
                        }
                        Toast.makeText(TestActivity.this, message.toString(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(TestActivity.this, "No events found.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle error response
                    Toast.makeText(TestActivity.this, "Failed to get events.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<EventModel>> call, Throwable t) {
                // Handle network or other errors
                Toast.makeText(TestActivity.this, "Failed to get events. Check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}