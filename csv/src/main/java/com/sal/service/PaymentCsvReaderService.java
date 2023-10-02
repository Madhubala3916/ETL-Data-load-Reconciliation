//package com.sal.service;
//import com.sal.model.Payment;
//import com.sal.repository.PaymentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PaymentCsvReaderService {
//    private final PaymentRepository paymentRepository;
//    @Autowired
//    public PaymentCsvReaderService(PaymentRepository paymentRepository) {
//        this.paymentRepository = paymentRepository;
//    }
//    public List<Payment> getAllPayments() {
//        return paymentRepository.findAll();
//    }
//    public Optional<Payment> getPaymentById(Long id) {
//        return paymentRepository.findById(id);
//    }
//    public Payment createPayment(Payment payment) {
//        return paymentRepository.save(payment);
//    }
//    public void deletePayment(Long id) {
//        paymentRepository.deleteById(id);
//    }
//}
