package com.axon.training.coreapi.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class UpdateOrderCommand {


    @TargetAggregateIdentifier
    private final String orderId;
    private final Integer count;


    public UpdateOrderCommand(String orderId, Integer count) {
        this.orderId = orderId;
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateOrderCommand that = (UpdateOrderCommand) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, count);
    }


    @Override
    public String toString() {
        return "UpdateOrderCommand{" +
                "orderId='" + orderId + '\'' +
                ", count=" + count +
                '}';
    }
}
