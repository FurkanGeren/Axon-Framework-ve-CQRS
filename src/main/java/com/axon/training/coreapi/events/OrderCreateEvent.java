package com.axon.training.coreapi.events;


import java.util.Objects;

public class OrderCreateEvent {


    private final String orderId;
    private final Boolean orderConfirmed;

    public OrderCreateEvent(String orderId, Boolean orderConfirmed) {
        this.orderId = orderId;
        this.orderConfirmed = orderConfirmed;
    }

    public String getOrderId() {
        return orderId;
    }

    public Boolean getOrderConfirmed() {
        return orderConfirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCreateEvent that = (OrderCreateEvent) o;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderId);
    }

    @Override
    public String toString() {
        return "OrderCreateEvent{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
