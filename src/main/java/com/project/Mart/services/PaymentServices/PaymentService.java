package com.project.Mart.services.PaymentServices;


import com.project.Mart.models.PaymentModel;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<PaymentModel> findAllPayment();

    String savePayment(PaymentModel paymentData);

    String updatePayment(PaymentModel newPaymentData);

    Optional<PaymentModel> findUByid(Integer id);
}
