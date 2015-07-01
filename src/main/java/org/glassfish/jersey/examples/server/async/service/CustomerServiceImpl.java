package org.glassfish.jersey.examples.server.async.service;

import org.glassfish.jersey.examples.server.async.data.Customer;
import org.glassfish.jersey.examples.server.async.entity.CustomerEntity;
import org.glassfish.jersey.examples.server.async.persistence.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public Customer retrieve(Long id) {
		return entityToCustomer(customerDao.retrieve(id));
	}

    public void delete(Long id) {
        customerDao.delete(id);
    }

	public void save(Customer customer) {
		customerDao.save(customerToEntity(customer));
	}

	// =========== Helpers ================

	private Customer entityToCustomer(CustomerEntity entity) {
		Customer customer = new Customer();

		if (entity != null) {
			customer.setId(entity.getId());
			customer.setFirstName(entity.getFirstName());
			customer.setLastName(entity.getLastName());
		}

		return customer;
	}

	private CustomerEntity customerToEntity(Customer customer) {
		CustomerEntity entity = new CustomerEntity();

		if (customer != null) {
			entity.setId(customer.getId());
			entity.setFirstName(customer.getFirstName());
			entity.setLastName(customer.getLastName());
		}

		return entity;
	}
}