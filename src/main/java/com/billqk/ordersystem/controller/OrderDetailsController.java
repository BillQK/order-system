package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.OrderDetailsEntity;
import com.billqk.ordersystem.database.domain.OrderEntity;
import com.billqk.ordersystem.database.repository.MenuRepository;
import com.billqk.ordersystem.database.repository.OrderDetailsRepository;
import com.billqk.ordersystem.database.repository.OrderRepository;
import com.billqk.ordersystem.model.OrderDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orderdetails")
public class OrderDetailsController {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    OrderRepository orderRepository;


    @GetMapping("/")
    public List<OrderDetailsDto> getOrderDetails() {
        List<OrderDetailsEntity> orderDetailsEntityList = orderDetailsRepository.findAll();

        List<OrderDetailsDto> orderDetailsDtoList = new ArrayList<>();

        for (OrderDetailsEntity orderDetailsEntity : orderDetailsEntityList) {
            // orderdetailsDto
            OrderDetailsDto orderdetailsDto = new OrderDetailsDto();

            // Setting attribute
            orderdetailsDto.setOrderQty(orderDetailsEntity.getOrderQty());
            orderdetailsDto.setOrderId(orderDetailsEntity.getOrderEntity().getOrder_id());
            orderdetailsDto.setTotalprice(orderDetailsEntity.getTotalprice());
            orderdetailsDto.setMenuId(orderDetailsEntity.getMenuEntity().getMenuId());

            orderDetailsDtoList.add(orderdetailsDto);

        }
        return orderDetailsDtoList;


    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrderDetails(@Valid @RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();

        orderDetailsEntity.setMenuEntity(
                menuRepository.findById(
                        orderDetailsDto.getMenuId()).orElseThrow(
                                () -> new RuntimeException("Menu id not found : ")));

        orderDetailsEntity.setOrderEntity(
                orderRepository.findById(orderDetailsDto.getOrderId()).orElseThrow(
                                () -> new RuntimeException("Order Id not found: ")));

        orderDetailsEntity.setOrderQty(orderDetailsDto.getOrderQty());
        orderDetailsEntity.setTotalprice(orderDetailsDto.getTotalprice());
        orderDetailsRepository.save(orderDetailsEntity);
        return "order details added";
    }
}