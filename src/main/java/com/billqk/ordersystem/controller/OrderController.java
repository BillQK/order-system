package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.OrderEntity;
import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.MenuRepository;
import com.billqk.ordersystem.database.repository.OrderRepository;
import com.billqk.ordersystem.database.repository.UserRepository;
import com.billqk.ordersystem.model.OrderDto;
import com.billqk.ordersystem.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

}
