package com.axon.training.querymodel;


import com.axon.training.coreapi.events.OrderCreateEvent;
import com.axon.training.coreapi.queries.FindAllOrderQuery;
import com.axon.training.model.OrderEntity;
import com.axon.training.repository.OrderEntityRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ProcessingGroup("orders")
public class OrderEventHandler {


    private final OrderEntityRepository repository;

    public OrderEventHandler(OrderEntityRepository repository) {
        this.repository = repository;
    }


    @EventHandler
    public void on(OrderCreateEvent event) {
        repository.save(new OrderEntity(event.getOrderId(), event.getOrderConfirmed()));
    }

    @QueryHandler
    public List<OrderEntity> on(FindAllOrderQuery query) {
        return repository.findAll();
    }

}
