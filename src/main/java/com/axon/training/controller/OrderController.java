package com.axon.training.controller;

import com.axon.training.coreapi.commands.CreateOrderCommand;
import com.axon.training.coreapi.commands.UpdateOrderCommand;
import com.axon.training.coreapi.queries.FindAllOrderQuery;
import com.axon.training.model.OrderEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/v1/api/order")
public class OrderController {


    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;


    public OrderController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/create")
    public String createOrder() {
        String orderId = UUID.randomUUID().toString();
        commandGateway.send(new CreateOrderCommand(orderId));
        return orderId;
    }

    @PutMapping("/update/{orderId}/{count}")
    public String updateOrder(@PathVariable String orderId,
                              @PathVariable Integer count) {
        commandGateway.send(new UpdateOrderCommand(orderId, count));
        return orderId;
    }

    @GetMapping
    public CompletableFuture<List<OrderEntity>> getAllOrders() {
        return queryGateway.query(new FindAllOrderQuery(),
                ResponseTypes.multipleInstancesOf(OrderEntity.class));
    }




}
