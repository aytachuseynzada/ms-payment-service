package com.example.mspaymentservice.dto;

import com.example.mspaymentservice.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponseDto {
    private Long id;
    private Long orderId;
    private Long userId;
    private Long courierId;
    private PaymentStatus paymentStatus;
    private BigDecimal DeliveryFee;
    private BigDecimal amount;
}
