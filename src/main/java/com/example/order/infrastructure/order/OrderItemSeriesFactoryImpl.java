package com.example.order.infrastructure.order;

import com.example.order.domain.order.Order;
import com.example.order.domain.order.OrderCommand;
import com.example.order.domain.order.OrderItemSeriesFactory;
import com.example.order.domain.order.item.OrderItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class OrderItemSeriesFactoryImpl implements OrderItemSeriesFactory {

    @Override
    public List<OrderItem> store(Order order, OrderCommand.RegisterOrder requestOrder) {
        return null;
    }

}
