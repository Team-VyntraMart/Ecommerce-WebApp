package com.project.Mart.controllers;

import com.project.Mart.models.PaymentModel;
import com.project.Mart.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/payment") 
@CrossOrigin(origins = "http://localhost:8015")
public class PaymentController {

    @Autowired
    private PaymentService paymentServices;

    @GetMapping("/all")
    public List<PaymentModel> allPayment() {
        return paymentServices.findAllPayment();
    }

    @PostMapping("/add")
    public String addPayment(@RequestBody PaymentModel PamyentData) {
        return paymentServices.savePayment(PamyentData);
    }

    @PutMapping("/update")
    public String updatePayment(@RequestBody PaymentModel newPamentData) {
        return paymentServices.updatePayment(newPamentData);
    }

    @GetMapping("/find/{id}")
    public Optional<PaymentModel> getPaymentById(@PathVariable Integer id) {
        return paymentServices.findUByid(id);
    }
}
