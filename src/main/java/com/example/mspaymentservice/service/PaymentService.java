package com.example.mspaymentservice.service;

import com.example.mspaymentservice.dao.entity.PaymentEntity;
import com.example.mspaymentservice.dao.repository.PaymentRepository;
import com.example.mspaymentservice.dto.PaymentRequestDto;
import com.example.mspaymentservice.dto.PaymentResponseDto;
import com.example.mspaymentservice.exceptions.PaymentNotFoundException;
import com.example.mspaymentservice.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public void createPayment(PaymentRequestDto paymentRequestDto) {
        var payment = paymentMapper.mapToEntity(paymentRequestDto);
        payment = paymentRepository.save(payment);
        paymentMapper.mapToDto(payment);
    }

    public PaymentResponseDto getPaymentByOrderId(Long orderId){
        var payment = fetchPaymentByIdIfExists(orderId);
        return paymentMapper.mapToDto(payment);
    }

    private PaymentEntity fetchPaymentByIdIfExists(Long id) {
        return paymentRepository.findByOrderId(id)
                .orElseThrow(() ->
                        new PaymentNotFoundException("Payment not found with id: " + id));
    }
}
