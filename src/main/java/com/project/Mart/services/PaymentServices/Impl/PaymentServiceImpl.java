package com.project.Mart.services.PaymentServices.Impl;

import com.project.Mart.models.PaymentModel;
import com.project.Mart.repositories.PaymentRepository;
import com.project.Mart.services.PaymentServices.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentModel> findAllPayment() {
        List<PaymentModel> allPayment = paymentRepository.findAll();
        return allPayment;
    }

    @Override
    public String savePayment(PaymentModel paymentData) {
        paymentRepository.save(paymentData);
        return "data save";
    }

    @Override
    public String updatePayment(PaymentModel newPaymentData) {

        String msg = null;

        if(newPaymentData.getP_id() != null){
            paymentRepository.save(newPaymentData);
            msg = "Data updated";
        }
        else{
            msg = "Data not updated";
        }
        return msg;

    }

    @Override
    public Optional<PaymentModel> findUByid(Integer id) {
        return paymentRepository.findById(id);
    }
}
