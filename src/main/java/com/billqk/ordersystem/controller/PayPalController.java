package com.billqk.ordersystem.controller;


import com.billqk.ordersystem.database.domain.OrderDetailsEntity;
import com.billqk.ordersystem.database.domain.OrderEntity;
import com.billqk.ordersystem.database.repository.OrderDetailsRepository;
import com.billqk.ordersystem.database.repository.OrderRepository;
import com.billqk.ordersystem.model.OrderDetailsDto;
import com.billqk.ordersystem.model.OrderDto;
import com.billqk.ordersystem.model.PaymentDto;
import com.billqk.ordersystem.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pay")
public class PayPalController {
    @Autowired
    PaypalService service;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public static final String SUCCESS_URL = "/success";
    public static final String CANCEL_URL = "/cancel";


    @PostMapping()
    public String payment(@Valid @RequestBody PaymentDto paymentDto) {
        Long id = paymentDto.getOrder_id();
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("order Id not found: "));

        List<OrderDetailsEntity> orderDetailsEntityList = orderDetailsRepository.findByOrderEntity(orderEntity);
        Double totalPrice = 0.0;
        for (OrderDetailsEntity orderDetailsEntity : orderDetailsEntityList) {
            totalPrice += orderDetailsEntity.getTotalPrice();
        }

        try {
            Payment payment = service.createPayment(
                    totalPrice,
                    "USD", "PayPal",
                    "order", "Order Number: " + paymentDto.getOrder_id(), CANCEL_URL, SUCCESS_URL);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals(("approval_url"))) {
                    return "redirect:" + link.getHref();
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId,
                             @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = service.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";

            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }


    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }
}
