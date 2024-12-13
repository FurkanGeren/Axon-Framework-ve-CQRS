package com.axon.training.commandmodel.order;


import com.axon.training.coreapi.commands.CreateOrderCommand;
import com.axon.training.coreapi.commands.UpdateOrderCommand;
import com.axon.training.coreapi.events.OrderCreateEvent;
import com.axon.training.coreapi.events.OrderUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private boolean orderConfirmed;

    private int count;

    @AggregateMember
    private List<OrderLine> orderLines;

    public OrderAggregate() {}

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        AggregateLifecycle.apply(new OrderCreateEvent(command.getOrderId(), false));
    }

    @CommandHandler
    public void handle(UpdateOrderCommand command) {
        if(this.count <= command.getCount()){
            throw new RuntimeException("Stock is not valid.");
            // apply(InsufficientStockEvent);
        }

        AggregateLifecycle.apply(new OrderUpdatedEvent(command.getOrderId(), command.getCount()));
    }


    @EventSourcingHandler
    public void on(OrderCreateEvent event) {
        this.orderId = event.getOrderId();
        this.orderConfirmed = event.getOrderConfirmed();
        this.count = 100;
        this.orderLines = new ArrayList<>();
    }

    @EventSourcingHandler
    public void on(OrderUpdatedEvent event) {
        this.count -= event.getCount();
    }

}
