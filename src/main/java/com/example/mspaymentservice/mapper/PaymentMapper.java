package com.example.mspaymentservice.mapper;

import com.example.mspaymentservice.dao.entity.PaymentEntity;
import com.example.mspaymentservice.dto.PaymentRequestDto;
import com.example.mspaymentservice.dto.PaymentResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentEntity mapToEntity(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto mapToDto(PaymentEntity paymentEntity);
}
