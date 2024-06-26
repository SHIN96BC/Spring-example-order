package com.example.order.infrastructure.order.payment;

import com.example.order.domain.order.Order;
import com.example.order.domain.order.OrderCommand;
import com.example.order.domain.order.payment.PaymentProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentProcessorImpl implements PaymentProcessor {

    @Override
    public void pay(Order order, OrderCommand.PaymentRequest request) {

    }

}
