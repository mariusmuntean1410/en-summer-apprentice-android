package com.example.ticketmanagement.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ticketmanagement.Model.EventModel;
import com.example.ticketmanagement.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>  {

private ArrayList<EventModel> events = new ArrayList<>();

private Context context;

    private String[] ticketOptions = {};
    public EventAdapter(Context context){

this.context = context;
    }
    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_list,parent, false);
      ViewHolder holder = new ViewHolder(view);
      return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, final int position) {
        String startDate = events.get(position).getStartDate();
        String endDate = events.get(position).getEndDate();
holder.txtName.setText(events.get(position).getEventName());
holder.txtDescription.setText(events.get(position).getEventDescription());
holder.startDate.setText(context.getString(R.string.start_date, startDate));
holder.endDate.setText(context.getString(R.string.end_date, endDate));
holder.parent.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) {
        Toast.makeText(context, events.get(position).getEventName()+ "Selected", Toast.LENGTH_SHORT).show();
    }
});
        ArrayAdapter<String> ticketAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, ticketOptions);
        ticketAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinnerTicketCategory.setAdapter(ticketAdapter);
    Glide.with(context).asBitmap().load(events.get(position).getImageUrl())
            .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
    public void setTicketOptions(String[] ticketOptions) {
        this.ticketOptions = ticketOptions;
        notifyDataSetChanged();     
    }
    public void setEvents(ArrayList<EventModel> events){
        this.events = events;
        notifyDataSetChanged();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

private TextView txtName, txtDescription, startDate, endDate;
private CardView parent;

        Spinner spinnerTicketCategory;
private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            startDate = itemView.findViewById(R.id.txtDate);
            endDate = itemView.findViewById(R.id.txtDate2);
            parent = itemView.findViewById(R.id.parent);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            image = itemView.findViewById(R.id.image);
            spinnerTicketCategory = itemView.findViewById(R.id.spinnerTicketCategory);
        }
    }

    }

