package com.billqk.ordersystem;

import com.billqk.ordersystem.constant.Constant;
import com.billqk.ordersystem.controller.OrderController;
import com.billqk.ordersystem.database.domain.OrderEntity;
import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.OrderRepository;
import com.billqk.ordersystem.model.OrderDto;
import com.billqk.ordersystem.model.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderControllerTest extends AbstractTest {
        @Override
        @Before
        public void setUp() {
            super.setUp();
        }

        @Test
        public void CreateUser() throws Exception {
            String uri = "/api/user";
            UserDto userDto = new UserDto();
            userDto.setAge(19);
            userDto.setEmail("121@gmail.com");
            userDto.setFirstname("hi");
            userDto.setLastname("hello");
            userDto.setMobile("09061007");
            userDto.setPassword("123");

            String inputJson = super.mapToJson(userDto);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(201, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "User added");

        }

//        @Test
//        public void createOrder() throws Exception {
//            String uri = "/api/order";
//
//
//            OrderDto orderDto = new OrderDto();
//            orderDto.setOrderId(Long.valueOf(1));
//            orderDto.setUserId(Long.valueOf(1));
//            orderDto.setStatus("IN PROGRESS");
//
//            String inputJson = super.mapToJson(orderDto);
//            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                    .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//            int status = mvcResult.getResponse().getStatus();
//            assertEquals(201, status);
//            String content = mvcResult.getResponse().getContentAsString();
//            assertEquals(content, "Order added");
//    }

}
