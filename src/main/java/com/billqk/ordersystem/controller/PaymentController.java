package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.PaymentEntity;
import com.billqk.ordersystem.database.repository.OrderRepository;
import com.billqk.ordersystem.database.repository.PaymentRepository;
import com.billqk.ordersystem.database.repository.UserRepository;
import com.billqk.ordersystem.model.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("")
    public List<PaymentDto> getPayment() {
        List<PaymentEntity> paymentEntityList = paymentRepository.findAll();

        List<PaymentDto> paymentDtoList = new ArrayList<>();

        for (PaymentEntity paymentEntity : paymentEntityList) {
            // paymentDto
            PaymentDto paymentDto = new PaymentDto();

            // setting
            paymentDto.setPayment_id(paymentEntity.getPayment_id());
            paymentDto.setPayment_Date();
            paymentDto.setPayment_method(paymentEntity.getPayment_method());
            paymentDto.setUser_id(paymentEntity.getUserEntity().getUser_id());
            paymentDto.setOrder_id(paymentEntity.getOrderEntity().getOrder_id());
            // adding to list
            paymentDtoList.add(paymentDto);
        }
        return paymentDtoList;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPayment(@Valid @RequestBody PaymentDto paymentDto) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setUserEntity(
                userRepository.findById(
                        paymentDto.getUser_id()).orElseThrow(() -> new RuntimeException("user id not found: ")));
        paymentEntity.setOrderEntity(
                orderRepository.findById(
                        paymentDto.getOrder_id()).orElseThrow(() -> new RuntimeException("order id not found: ")));
        paymentEntity.setPaymentDate();
        paymentEntity.setPayment_method(paymentDto.getPayment_method());
        try {

            paymentRepository.save(paymentEntity);
        } catch (DataIntegrityViolationException e) {
            return e.getRootCause().getMessage();
        }
        return "payment added";
    }


}
