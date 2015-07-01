package org.glassfish.jersey.examples.server.async.persistence;

import org.glassfish.jersey.examples.server.async.entity.CustomerEntity;

public interface CustomerDao {
	
	public CustomerEntity retrieve(Long id);

    public void delete(Long id);
	
	public void save(CustomerEntity customer);
}