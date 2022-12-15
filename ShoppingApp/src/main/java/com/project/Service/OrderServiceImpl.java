package com.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.OrderDao;
import com.project.Exceptions.OrderException;
import com.project.module.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao oDao;
	@Override
	public Order addOrder(Order order){
		
		Order saveOrders = oDao.save(order);
		return saveOrders;
	}
	
	
	@Override
	public Order viewOrder(Integer orderId) throws OrderException {
		Optional<Order> ordr1 = oDao.findById(orderId);
		
		if(ordr1.isPresent()) {
			return ordr1.get();
		} else {
			throw new OrderException("Not found");
		}
	}

	
	
	

}
