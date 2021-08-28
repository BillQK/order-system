package com.billqk.ordersystem.controller;


import com.billqk.ordersystem.service.RegistrationRequest;
import com.billqk.ordersystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @PostMapping()
    public String register(@RequestBody RegistrationRequest request)
    {

        return registrationService.register(request);

    }
}
