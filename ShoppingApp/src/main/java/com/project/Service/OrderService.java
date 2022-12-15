package com.project.Service;

import com.project.Exceptions.OrderException;
import com.project.module.Order;

public interface OrderService {

	public Order addOrder(Order order) throws Exception;
	
	public Order viewOrder(Integer orderId) throws OrderException;
}
