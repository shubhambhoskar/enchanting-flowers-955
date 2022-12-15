package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.OrderException;
import com.project.Service.OrderService;
import com.project.module.Order;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService oService;
	
	@PostMapping("/orders")
	public ResponseEntity<Order> addOrderHandler(@RequestBody Order order) throws Exception{
		Order saveOrder = oService.addOrder(order);
		
		return new ResponseEntity<Order>(saveOrder,HttpStatus.CREATED);	
	}
	
	@GetMapping("/orders")
	public ResponseEntity<Order> viewOrderHandler(@RequestParam Integer orderId) throws OrderException{
		Order existingOrder = oService.viewOrder(orderId);
		
		return new ResponseEntity<Order>(existingOrder,HttpStatus.OK);
	}

}
