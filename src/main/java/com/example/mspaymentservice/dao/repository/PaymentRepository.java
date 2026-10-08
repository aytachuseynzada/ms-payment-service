package com.example.mspaymentservice.dao.repository;

import com.example.mspaymentservice.dao.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
    Optional<PaymentEntity> findByOrderId(Long orderId);
}
