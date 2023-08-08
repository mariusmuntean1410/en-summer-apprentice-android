package com.example.ticketmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketmanagement.Model.OrderModel;
import com.example.ticketmanagement.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>  {

    private ArrayList<OrderModel> orders = new ArrayList<>();

   Context context;

   String[] ticketOptions2 = {};
    public OrderAdapter(Context context){

        this.context = context;
    }
    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_list,parent, false);
        OrderAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, final int position) {

            int numberOfTickets = orders.get(position).getNumberOfTickets();
            int orderId = orders.get(position).getOrderId();
            int totalPrice = orders.get(position).getTotalPrice();
            String orderedAt = orders.get(position).getOrderedAt();


            holder.nr_tickets.setText(context.getString(R.string.number_of_tickets, numberOfTickets));
            holder.orderId.setText(context.getString(R.string.order_id, orderId));
            holder.orderPrice.setText(context.getString(R.string.total_price, totalPrice));
            holder.orderedAt.setText(context.getString(R.string.ordered_at, orderedAt));


        ArrayAdapter<String> ticketAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, ticketOptions2);
        ticketAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinnerTicketCategory2.setAdapter(ticketAdapter);


    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
    public void setTicketOptions2(String[] ticketOptions2) {
        this.ticketOptions2 = ticketOptions2;
        notifyDataSetChanged();
    }
    public void setOrders(ArrayList<OrderModel> orders){
        this.orders = orders;
        notifyDataSetChanged();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nr_tickets,orderId,orderPrice, orderedAt;
          CardView parent;

        Spinner spinnerTicketCategory2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderedAt = itemView.findViewById(R.id.orderedAt);
            nr_tickets = itemView.findViewById(R.id.nr_tickets);
            orderId = itemView.findViewById(R.id.orderId);
            parent = itemView.findViewById(R.id.parent);
            orderPrice = itemView.findViewById(R.id.orderPrice);
            spinnerTicketCategory2 = itemView.findViewById(R.id.spinnerTicketCategory2);
        }
    }


}
