package org.glassfish.jersey.examples.server.async.service;

import org.glassfish.jersey.examples.server.async.data.Customer;

public interface CustomerService {

	public Customer retrieve(Long id);

    public void delete(Long id);
	
	public void save(Customer customer);
}