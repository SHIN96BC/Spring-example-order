package com.example.order.domain.order;

public interface OrderService {

    String registerOrder(OrderCommand.RegisterOrder requestOrder);
    void paymentOrder(OrderCommand.PaymentRequest paymentRequest);
    OrderInfo.Main retrieveOrder(String orderToken);

}
