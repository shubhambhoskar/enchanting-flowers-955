package com.project.Service;

import java.time.LocalDate;
import java.util.List;

import com.project.Exceptions.AddressException;
import com.project.Exceptions.CartException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.OrderException;
import com.project.module.MyOrder;


public interface OrderServices {
	public MyOrder addOrder(String key) throws OrderException, CartException, LoginException,CustomerException,AddressException;
	
	public MyOrder updateOrder(MyOrder order,Integer orderId, String key) throws OrderException, LoginException,CustomerException;
	
	public MyOrder removeOrder(Integer oriderId, String key) throws OrderException,CustomerException, LoginException;
	
	public MyOrder viewOrder(Integer orderId, String key) throws OrderException,CustomerException, LoginException;
	
	public List<MyOrder> viewAllOrdersByDate(LocalDate date,String key) throws OrderException,CustomerException, LoginException;

//	public List<MyOrder> viewAllOrdersByLocation(String city,String key) throws OrderException,CustomerException, LoginException;
	
	public List<MyOrder> viewAllOrdersByCustomerId(Integer CustomerId,String key) throws OrderException,CustomerException, LoginException;
}
