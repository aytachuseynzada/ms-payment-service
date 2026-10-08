package com.example.mspaymentservice.consumer;

import com.example.mspaymentservice.dto.PaymentRequestDto;
import com.example.mspaymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import static com.example.mspaymentservice.config.RabbitMQConfig.PAYMENT_QUEUE;

@RequiredArgsConstructor
@Slf4j
@Component
public class PaymentConsumer {
    private final PaymentService paymentService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = PAYMENT_QUEUE)
    public void handleOrderCreated(String message) {
        log.info("PaymentConsumer.handleOrderCreated.start message: {}", message);

        try {
            var event =
                    objectMapper.readValue(message, PaymentRequestDto.class);

            paymentService.createPayment(event);

            log.info("PaymentConsumer.handleOrderCreated.end");
        } catch (Exception e) {
            log.error("PaymentConsumer.handleOrderCreated.error", e);
        }
    }
}
