package com.project.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.CartDao;
import com.project.Dao.CurrentUserSessionDao;
import com.project.Dao.CustomerDao;
import com.project.Dao.MyOrderDao;
import com.project.Exceptions.AddressException;
import com.project.Exceptions.CartException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.OrderException;
import com.project.module.Address;
import com.project.module.Cart;
import com.project.module.CurrentUserSession;
import com.project.module.Customer;
import com.project.module.MyOrder;
import com.project.module.Product;

@Service
public class OrderServicesImpl implements OrderServices{
	@Autowired
	private MyOrderDao myOrderDao;
	
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CurrentUserSessionDao cussdao;
	
	@Autowired
	private CartDao cartdao;
//*****************************************************************************************************************************************************************************************
	@Override
	public MyOrder addOrder(String key)throws OrderException, CartException, LoginException, CustomerException, AddressException {
		CurrentUserSession loggedInCustomer = cussdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInCustomer.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}

		Optional<Customer> existingUser = customerDao.findById(loggedInCustomer.getUserId());

		if (existingUser.isPresent()) {

			Customer customer = existingUser.get();

			Cart cart = customer.getCart();

			Map<Product, Integer> productMap = cart.getProducts();

			if (productMap.isEmpty()) {
				throw new CartException("Empty cart Found");
			}

			MyOrder Order = new MyOrder();
			Order.setCustomer(customer);
			Order.setOrderDate(LocalDate.now());
			Order.setProducts(productMap);
			Order.setOrderStatus("Order placed");
			Address address = customer.getAddresses();

			if (address == null) {
				throw new AddressException("No Address found for this Customer.");
			}
			Order.setAddress(address);
			cart.setProducts(new HashMap<>());
			MyOrder savedOrder = myOrderDao.save(Order);
			return savedOrder;
		} else {
			throw new CustomerException("Customer Not Found");
		}
	}
//*****************************************************************************************************************************************************************************************
	@Override
	public MyOrder updateOrder(MyOrder order,Integer orderId, String key) throws OrderException, LoginException, CustomerException {
		CurrentUserSession loggedInCustomer = cussdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInCustomer.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}

		Optional<Customer> existingUser = customerDao.findById(loggedInCustomer.getUserId());

		if (existingUser.isPresent()) {

			Customer customer = existingUser.get();

			Optional<MyOrder> existingOrder = myOrderDao.findById(orderId);

			if (existingOrder.isPresent()) {

				MyOrder savedOrder = existingOrder.get();

				if (savedOrder.getCustomer().getCustomerLoginId() == customer.getCustomerLoginId()) {

					order.setCustomer(customer);

					return myOrderDao.save(order);

				} else {
					throw new CustomerException("Invalid Customer Details for Order Id: " + orderId);
				}
			} else {
				throw new OrderException("No order found with this orderId: " + orderId);
			}

		} else {
			throw new CustomerException("User Not Found");
		}
	}
//*****************************************************************************************************************************************************************************************
	@Override
	public MyOrder removeOrder(Integer oriderId, String key) throws OrderException, CustomerException, LoginException {
		CurrentUserSession loggedInCustomer = cussdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInCustomer.getAdmin()== true) {
			throw new CustomerException("Only Customer can make changes");
		}

		Optional<Customer> existingUser = customerDao.findById(loggedInCustomer.getUserId());

		if (existingUser.isPresent()) {

			Customer customer = existingUser.get();

			Optional<MyOrder> existingOrder = myOrderDao.findById(oriderId);

			if (existingOrder.isPresent()) {

				MyOrder savedOrder = existingOrder.get();

				if (savedOrder.getCustomer().getCustomerLoginId() == customer.getCustomerLoginId()) {

					myOrderDao.delete(savedOrder);

					return savedOrder;

				} else {
					throw new CustomerException("Invalid Customer Details for Order Id: " + oriderId);
				}

			} else {
				throw new OrderException("No order found with this orderId: " + oriderId);
			}

		} else {
			throw new CustomerException("Customer Not Found");
		}
	}
//*****************************************************************************************************************************************************************************************
	@Override
	public MyOrder viewOrder(Integer orderId , String key) throws OrderException, CustomerException, LoginException {
		CurrentUserSession loggedInCustomer = cussdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInCustomer.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}

		Optional<Customer> existingUser = customerDao.findById(loggedInCustomer.getUserId());

		if (existingUser.isPresent()) {

			Customer customer = existingUser.get();

			Optional<MyOrder> existingOrder = myOrderDao.findById(orderId);

			if (existingOrder.isPresent()) {

				MyOrder savedOrder = existingOrder.get();

				if (savedOrder.getCustomer().getCustomerLoginId() == customer.getCustomerLoginId()) {
					return savedOrder;
				} else {
					throw new CustomerException("Invalid Customer Details for Order Id: " + orderId);
				}

			} else {
				throw new OrderException("No order found with this orderId: " + orderId);
			}

		} else {
			throw new CustomerException("User Not Found");
		}
	}
////*****************************************************************************************************************************************************************************************
	@Override
	public List<MyOrder> viewAllOrdersByDate(LocalDate date,String key) throws OrderException, CustomerException, LoginException {
		CurrentUserSession loggedInCustomer = cussdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInCustomer.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}
		Optional<Customer> existingUser = customerDao.findById(loggedInCustomer.getUserId());

		if (existingUser.isPresent()) {
        List<MyOrder> orders= myOrderDao.findByOrderDate(date);
		if(orders.size()>0) {
			
			return orders;
		}
		else {
			throw new OrderException("Order doesn't exist on this date.");
		}
		} else {
			throw new CustomerException("User Not Found");
		}
		
	}
////*****************************************************************************************************************************************************************************************
//	@Override
//	public List<MyOrder> viewAllOrdersByLocation(String city,String key) throws OrderException, CustomerException, LoginException {
//		CurrentUserSession loggedInCustomer = cussdao.findByUuid(key);
//
//		if (loggedInCustomer == null) {
//			throw new LoginException("Invalid Key Entered");
//		}
//
//		if (loggedInCustomer.getAdmin() == true) {
//			throw new CustomerException("Only Customer can make changes");
//		}
//		Optional<Customer> existingUser = customerDao.findById(loggedInCustomer.getUserId());
//
//		if (existingUser.isPresent()) {
//			
//			List<MyOrder> list= myOrderDao.getOrderByCity(city);
//			
//			if( list.size() < 1) {
//				throw new OrderException("No order found with this userId.");
//			}
//			return list;	
//		}else {
//			throw new CustomerException("User Not Found");
//		}
//	}

////*****************************************************************************************************************************************************************************************	
	@Override
	public List<MyOrder> viewAllOrdersByCustomerId(Integer CustomerId, String key)throws OrderException, CustomerException, LoginException {
		CurrentUserSession loggedInCustomer = cussdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInCustomer.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}
		Optional<Customer> existingUser = customerDao.findById(loggedInCustomer.getUserId());

		if (existingUser.isPresent()) {
			
			Customer customer = existingUser.get();
			Cart c = customer.getCart();
			List<MyOrder> list= myOrderDao.getOrderByCID(CustomerId);
			if( list.size() < 1) {
				throw new OrderException("No order found with this userId.");
			}
			return list;
			}else {
			throw new CustomerException("User Not Found");
		}
	}


}
