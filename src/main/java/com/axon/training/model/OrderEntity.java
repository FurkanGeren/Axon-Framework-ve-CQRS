package com.axon.training.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class OrderEntity {

    @Id
    public String orderId;
    public Boolean orderConfirmed;

    public OrderEntity() {
    }

    public OrderEntity(String orderId, Boolean orderConfirmed) {
        this.orderId = orderId;
        this.orderConfirmed = orderConfirmed;
    }

    public String getOrderId() {
        return orderId;
    }

    public Boolean getOrderConfirmed() {
        return orderConfirmed;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderConfirmed(Boolean orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId='" + orderId + '\'' +
                ", orderConfirmed=" + orderConfirmed +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(orderConfirmed, that.orderConfirmed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderConfirmed);
    }
}
