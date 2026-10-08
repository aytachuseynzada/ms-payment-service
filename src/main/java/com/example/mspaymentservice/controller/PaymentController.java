package com.example.mspaymentservice.controller;

import com.example.mspaymentservice.dto.PaymentRequestDto;
import com.example.mspaymentservice.dto.PaymentResponseDto;
import com.example.mspaymentservice.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createPayment(@Valid @RequestBody PaymentRequestDto paymentRequestDto){
        paymentService.createPayment(paymentRequestDto);
    }

    @GetMapping("/{id}")
    public PaymentResponseDto getPaymentByOrderId(@PathVariable Long id){
        return paymentService.getPaymentByOrderId(id);
    }
}
