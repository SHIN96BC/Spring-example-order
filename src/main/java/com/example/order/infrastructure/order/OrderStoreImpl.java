package com.example.order.infrastructure.order;

import com.example.order.domain.order.Order;
import com.example.order.domain.order.OrderStore;
import com.example.order.domain.order.item.OrderItem;
import com.example.order.domain.order.item.OrderItemOption;
import com.example.order.domain.order.item.OrderItemOptionGroup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderStoreImpl implements OrderStore {

    @Override
    public Order store(Order order) {
        return null;
    }

    @Override
    public OrderItem store(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItemOptionGroup store(OrderItemOptionGroup orderItemOptionGroup) {
        return null;
    }

    @Override
    public OrderItemOption store(OrderItemOption orderItemOption) {
        return null;
    }

}
