package com.springcore.service;

import com.springcore.model.Orders;
import utils.OrderBody;

import java.util.List;

public interface OrdersService {

    Orders createOrder(OrderBody orderBody);

    List<Orders> activeUndelivered (Integer userId);

    List<Orders> activeDelivered(Integer userId);

      List<Orders> getAllActiveOrders();

    Orders cancelOrder(Integer orderId);

    Orders setDeliveryStatus(Integer orderId);


}
