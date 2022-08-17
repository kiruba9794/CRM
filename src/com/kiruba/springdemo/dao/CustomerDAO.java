package com.kiruba.springdemo.dao;

import java.util.List;

import com.kiruba.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer>getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String searchName);
	
	
	
}
