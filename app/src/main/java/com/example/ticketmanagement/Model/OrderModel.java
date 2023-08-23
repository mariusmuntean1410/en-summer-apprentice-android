package com.example.ticketmanagement.Model;

public class OrderModel {

    private int OrderId;

    public OrderModel(int orderId, String orderedAt, int totalPrice, int numberOfTickets) {
        OrderId = orderId;
        this.orderedAt = orderedAt;
        this.totalPrice = totalPrice;
        NumberOfTickets = numberOfTickets;
    }

    private String orderedAt;
    private int totalPrice;

    private int NumberOfTickets;

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "OrderId=" + OrderId +
                ", orderedAt='" + orderedAt + '\'' +
                ", totalPrice=" + totalPrice +
                ", NumberOfTickets=" + NumberOfTickets +
                '}';
    }

    public String getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(String orderedAt) {
        this.orderedAt = orderedAt;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumberOfTickets() {
        return NumberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        NumberOfTickets = numberOfTickets;
    }
}
