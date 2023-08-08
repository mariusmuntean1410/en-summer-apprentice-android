package com.example.ticketmanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketmanagement.Adapter.OrderAdapter;
import com.example.ticketmanagement.Model.OrderModel;
import com.example.ticketmanagement.R;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {


    private RecyclerView ordersView;
    private String[] ticketOptions2 = {"Standard","VIP"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.customToolbar2);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ordersView = findViewById(R.id.ordersView);

        ArrayList<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel(1,"12.10.2023",1500,3));
       orders.add(new OrderModel(2,"13.10.2023",1700,2));
        orders.add(new OrderModel(3,"14.10.2023",1600,5));
       orders.add(new OrderModel(4,"23.09.2023",2000,8));

        OrderAdapter adapter = new OrderAdapter(this );
        adapter.setOrders(orders);
        ordersView.setAdapter(adapter);
        ordersView.setLayoutManager(new LinearLayoutManager(this));
        String[] ticketOptions2 = {"Standard","VIP"};
        adapter.setTicketOptions2(ticketOptions2);

        ImageButton btnSort2 = toolbar.findViewById(R.id.btnSort2);
        ImageButton btnFilter2 = toolbar.findViewById(R.id.btnFilter2);
        ImageButton btnOrders = toolbar.findViewById(R.id.btnOrders);
        btnOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnSort2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnFilter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
