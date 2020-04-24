package com.project.Mart.controllers;

import com.project.Mart.models.PaymentModel;
import com.project.Mart.services.PaymentServices.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //api endpoint call karanna ona wenawa
@RequestMapping("/payment") // api end point eka sadaha
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
