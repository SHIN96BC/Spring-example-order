package com.example.order.domain.order;

public interface OrderReader {

    Order getOrder(String orderToken);

}
