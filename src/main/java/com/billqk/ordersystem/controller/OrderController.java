package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.constant.Constant;
import com.billqk.ordersystem.database.domain.MenuEntity;
import com.billqk.ordersystem.database.domain.OrderDetailsEntity;
import com.billqk.ordersystem.database.domain.OrderEntity;

import com.billqk.ordersystem.database.repository.MenuRepository;
import com.billqk.ordersystem.database.repository.OrderDetailsRepository;
import com.billqk.ordersystem.database.repository.OrderRepository;
import com.billqk.ordersystem.database.repository.UserRepository;
import com.billqk.ordersystem.model.OrderDetailsDto;
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

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    /*
    {
    "orderId" : 1,
    "total" : 70,
    "orderItems" : [
        {
            "menu" : "pho",
            "price" : 10,
            "quantity": 3,
            "total": 30
        },
        {
            "menu" : "hu tieu",
            "price" : 10,
            "quantity" : 4,
            "total" : 40,
        }
    ]
    }

     */
    @GetMapping("/{id}")
    public OrderDto getOrderDto(@PathVariable("id") Long id) {
        // get order entity id
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("order id not found: "));
        // Set orderId, userId, userName, status, totalPrice
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(orderEntity.getOrder_id());
        orderDto.setStatus(orderEntity.getStatus());
        orderDto.setOrderDate(orderEntity.getOrderDate());
        orderDto.setUserId(orderEntity.getUserEntity().getUser_id());
        orderDto.setUserName(orderEntity.getUserEntity().getFirst_name() + " " + orderEntity.getUserEntity().getLast_name());
        Double totalPrice = 0.0;

        // Create orderDetails object in List
        List<OrderDetailsDto> orderDetailsDtoList = new ArrayList<>();
        List<OrderDetailsEntity> orderDetailsEntityList = orderDetailsRepository.findByOrderEntity(orderEntity);

        for (OrderDetailsEntity orderDetailsEntity : orderDetailsEntityList) {
            // Set menuName, item price, orderQty, totalPrice
            OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
            orderDetailsDto.setOrderQty(orderDetailsEntity.getOrderQty());
            orderDetailsDto.setTotalPrice(orderDetailsEntity.getOrderQty() * orderDetailsEntity.getMenuEntity().getPrice());
            orderDetailsDto.setPrice(orderDetailsEntity.getMenuEntity().getPrice());
            orderDetailsDto.setMenuName(orderDetailsEntity.getMenuEntity().getMenuName());
            totalPrice += orderDetailsEntity.getTotalPrice();
            orderDetailsDtoList.add(orderDetailsDto);
        }
        // Set Total Price
        orderDto.setTotalPrice(totalPrice);
        // Set orderdetailsList
        orderDto.setOrderDetailsDtoList(orderDetailsDtoList);

        // return result
        return orderDto;
    }

    // Getting all the orders from database (Don't need to test this)
    @GetMapping()
    public List<OrderDto> getOrder(@RequestParam Constant.Status status) {
        List<OrderEntity> orderEntityList = orderRepository.findByStatusOrderByOrderDateDesc(status);
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityList) {
            OrderDto orderDto = new OrderDto();
            // Get User
            orderDto.setUserId(orderEntity.getUserEntity().getUser_id());
            orderDto.setUserName(orderEntity.getUserEntity().getEmail());
            //Setting attributes
            double totalPrice = 0.0;
            // Create orderDetails object in List
            List<OrderDetailsDto> orderDetailsDtoList = new ArrayList<>();
            List<OrderDetailsEntity> orderDetailsEntityList = orderDetailsRepository.findByOrderEntity(orderEntity);

            for (OrderDetailsEntity orderDetailsEntity : orderDetailsEntityList) {
                // Set menuName, item price, orderQty, totalPrice
                OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
                orderDetailsDto.setOrderQty(orderDetailsEntity.getOrderQty());
                orderDetailsDto.setTotalPrice(orderDetailsEntity.getOrderQty() * orderDetailsEntity.getMenuEntity().getPrice());
                orderDetailsDto.setPrice(orderDetailsEntity.getMenuEntity().getPrice());
                orderDetailsDto.setMenuName(orderDetailsEntity.getMenuEntity().getMenuName());
                totalPrice += orderDetailsEntity.getTotalPrice();
                orderDetailsDtoList.add(orderDetailsDto);
            }

            orderDto.setTotalPrice(totalPrice);
            orderDto.setOrderDetailsDtoList(orderDetailsDtoList);
            orderDto.setOrderId(orderEntity.getOrder_id());
            orderDto.setOrderDate(orderEntity.getOrderDate());
            orderDto.setStatus(orderEntity.getStatus());

            orderDtoList.add(orderDto);

        }
        return orderDtoList;
    }

    /*
    {
    "userId" : 1,
    "status" : "preparing",
    "orderDetailsList" : [
        {
            "menuId" : 1,
            "orderQty" : 3
        },
                {
            "menuId" : 2,
            "orderQty" : 4
        }
    ]

}
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String CreateOrder(@Valid @RequestBody OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        OrderDto orderDto1 = new OrderDto();

        // Json user Id;
        orderEntity.setUserEntity(
                userRepository.findById(
                        orderDto.getUserId()).orElseThrow(
                        () -> new RuntimeException("user id not found: "))
        );
        // database date set
        orderEntity.setOrderDate();
        // Json status set
        orderEntity.setStatus(orderDto.getStatus());

        // Json Order Details List Set
        orderRepository.save(orderEntity);
        List<OrderDetailsDto> orderDetailsDtoList = orderDto.getOrderDetailsDtoList();
        for (OrderDetailsDto orderDetailsDto : orderDetailsDtoList) {
            OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
            // database order id set
            orderDetailsEntity.setOrderEntity(orderEntity);
            // Json order quantity
            orderDetailsEntity.setOrderQty(orderDetailsDto.getOrderQty());
            // Json menu id
            MenuEntity menuEntity = menuRepository.findById(orderDetailsDto.getMenuId()).orElseThrow(() -> new RuntimeException("user id not found: "));
            orderDetailsEntity.setMenuEntity(menuEntity);
            // Return total price
            Double totalPrice = orderDetailsDto.getOrderQty() * menuEntity.getPrice();
            orderDetailsEntity.setTotalPrice(totalPrice);
            // save to database
            orderDetailsRepository.save(orderDetailsEntity);
        }
        return "Order added";
    }

}
