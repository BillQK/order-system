package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.OrderEntity;

import com.billqk.ordersystem.database.repository.OrderRepository;
import com.billqk.ordersystem.database.repository.UserRepository;
import com.billqk.ordersystem.model.OrderDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/")
    public List<OrderDto> getOrder() {
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityList) {
            OrderDto orderDto = new OrderDto();
            // Get User
            orderDto.setUserId(orderEntity.getUserEntity().getUser_id());
            //Setting attributes
            orderDto.setOrderId(orderEntity.getOrder_id());
            orderDto.setOrderDate(orderEntity.getOrderDate());
            orderDto.setStatus(orderEntity.getStatus());

            orderDtoList.add(orderDto);

        }
        return orderDtoList;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String CreateOrder(@Valid @RequestBody OrderDto orderDto)  {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setUserEntity(
                userRepository.findById(
                        orderDto.getUserId()).orElseThrow(()-> new RuntimeException("user id not found: ")));

        orderEntity.setOrderDate();
        orderEntity.setStatus(orderDto.getStatus());
        orderRepository.save(orderEntity);
        return "Order added";
    }

}
