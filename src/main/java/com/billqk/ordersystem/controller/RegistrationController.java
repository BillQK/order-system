package com.billqk.ordersystem.controller;


import com.billqk.ordersystem.service.RegistrationRequest;
import com.billqk.ordersystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/admin")
    public String registerAdmin(@RequestBody RegistrationRequest request)
    {

        return registrationService.registerAdmin(request);

    }
    @GetMapping()
    public String confirm(@RequestParam("token") String token)
    {
        return registrationService.confirmToken(token);
    }
}
