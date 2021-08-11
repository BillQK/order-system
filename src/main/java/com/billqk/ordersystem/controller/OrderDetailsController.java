package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.OrderDetailsEntity;
import com.billqk.ordersystem.database.domain.OrderEntity;
import com.billqk.ordersystem.database.repository.MenuRepository;
import com.billqk.ordersystem.database.repository.OrderDetailsRepository;
import com.billqk.ordersystem.database.repository.OrderRepository;
import com.billqk.ordersystem.model.OrderDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orderdetails")
public class OrderDetailsController {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/")
    public List<OrderDetailsDto> getOrderDetails() {
        List<OrderDetailsEntity> orderDetailsEntityList = orderDetailsRepository.findAll();

        List<OrderDetailsDto> orderDetailsDtoList = new ArrayList<>();

        for (OrderDetailsEntity orderDetailsEntity  : orderDetailsEntityList) {
            // orderdetailsDto
            OrderDetailsDto orderdetailsDto = new OrderDetailsDto();

            // Setting attribute




    }
}
