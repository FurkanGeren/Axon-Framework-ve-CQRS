package com.axon.training.coreapi.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class IncProductCountCommand {


    @TargetAggregateIdentifier
    private final String productId;


    public IncProductCountCommand(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "IncProductCountCommand{" +
                "productId='" + productId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncProductCountCommand that = (IncProductCountCommand) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }
}
