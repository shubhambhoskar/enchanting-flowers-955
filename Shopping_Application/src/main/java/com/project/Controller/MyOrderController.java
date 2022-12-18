package com.project.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.AddressException;
import com.project.Exceptions.CartException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.OrderException;
import com.project.Service.OrderServices;
import com.project.module.MyOrder;

@RestController
public class MyOrderController {
	@Autowired
	private OrderServices orderServices;
	
	@PostMapping("/orders")
	public ResponseEntity<MyOrder> addOrderHandler(@RequestParam String Key) throws OrderException, CartException, LoginException, CustomerException, AddressException{
		
		MyOrder savedOrder = orderServices.addOrder(Key);
		
		return new ResponseEntity<MyOrder>(savedOrder, HttpStatus.OK);
	}
	
	@PutMapping("/orders")
	public ResponseEntity<MyOrder> updateOrderHandler(@Valid @RequestBody MyOrder order, @RequestParam Integer orderId,@RequestParam String Key) throws OrderException, LoginException, CustomerException{

		MyOrder savedOrder = orderServices.updateOrder(order, orderId, Key);

		return new ResponseEntity<MyOrder>(savedOrder, HttpStatus.OK);
	}

	@DeleteMapping("/orders")
	public ResponseEntity<MyOrder> deleteOrderHandler(@RequestParam Integer orderId, @RequestParam String Key) throws OrderException, CustomerException, LoginException{

		MyOrder savedOrder = orderServices.removeOrder(orderId, Key);

		return new ResponseEntity<MyOrder>(savedOrder, HttpStatus.OK);

	}

	@GetMapping("/orders/{orderId}")
	public ResponseEntity<MyOrder> getOrderByIdHandler(@PathVariable("orderId") Integer orderId,@RequestParam String Key) throws OrderException, CustomerException, LoginException{

		MyOrder savedOrder = orderServices.viewOrder(orderId, Key);

		return new ResponseEntity<MyOrder>(savedOrder, HttpStatus.OK);

	}

	@GetMapping("/orderByDate")
	public ResponseEntity<List<MyOrder>> getOrderByByDateHandler(@RequestParam LocalDate date,@RequestParam String key) throws OrderException, CustomerException, LoginException{

		List<MyOrder> savedOrder = orderServices.viewAllOrdersByDate(date, key);

		return new ResponseEntity<List<MyOrder>>(savedOrder, HttpStatus.OK);

	}
	
//	@GetMapping("/ordersByLocation")
//	public ResponseEntity<List<MyOrder>> getOrderByByLocationHandler(@RequestParam String city,@RequestParam String key) throws OrderException, CustomerException, LoginException{
//
//		List<MyOrder> savedOrder = orderServices.viewAllOrdersByLocation(city, key);
//
//		return new ResponseEntity<List<MyOrder>>(savedOrder, HttpStatus.OK);
//
//	}
	
	@GetMapping("/ordersByLocation")
	public ResponseEntity<List<MyOrder>> getOrderByByCustomerIdHandler(@RequestParam Integer CustomerId,@RequestParam String key) throws OrderException, CustomerException, LoginException{

		List<MyOrder> savedOrder = orderServices.viewAllOrdersByCustomerId(CustomerId, key);

		return new ResponseEntity<List<MyOrder>>(savedOrder, HttpStatus.OK);

	}
}
