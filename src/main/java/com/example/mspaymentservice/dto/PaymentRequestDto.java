package com.example.mspaymentservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDto {
    @NotNull
    private Long orderId;

    @NotNull
    private Long courierId;

    @NotNull
    private Long userId;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private BigDecimal deliveryFee;
}
