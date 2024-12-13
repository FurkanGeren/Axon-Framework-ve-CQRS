package com.axon.training.commandmodel.order;

import com.axon.training.coreapi.commands.IncProductCountCommand;
import com.axon.training.coreapi.events.ProductCountIncEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.EntityId;

public class OrderLine {

    @EntityId
    private final String productId;
    private Integer count;

    public OrderLine(String productId, Integer count) {
        this.productId = productId;
        this.count = count;
    }

    @CommandHandler
    public void handle(IncProductCountCommand command) {
        AggregateLifecycle.apply(new ProductCountIncEvent(10));
    }


    @EventSourcingHandler
    public void on(ProductCountIncEvent event){
        this.count -= event.getCount();
    }
}
