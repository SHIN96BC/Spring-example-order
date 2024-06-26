package com.example.order.infrastructure.order;

import com.example.order.domain.order.Order;
import com.example.order.domain.order.OrderReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderReaderImpl implements OrderReader {

    @Override
    public Order getOrder(String orderToken) {
        return null;
    }

}
