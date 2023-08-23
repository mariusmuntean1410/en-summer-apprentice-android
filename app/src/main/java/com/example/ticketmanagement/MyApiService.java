package com.example.ticketmanagement;

import com.example.ticketmanagement.Model.EventModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApiService {
    @GET("/event/all")
    Call<List<EventModel>> getEvents();

    @GET("/event/specific")
    Call<List<EventModel>> getEventsByVenueAndEventType(@Query("venueId") int venueId, @Query("eventType") String eventType);
}
