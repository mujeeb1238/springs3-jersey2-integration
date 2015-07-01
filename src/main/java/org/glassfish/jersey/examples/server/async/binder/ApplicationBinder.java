package org.glassfish.jersey.examples.server.async.binder;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.examples.server.async.persistence.CustomerDao;
import org.glassfish.jersey.examples.server.async.persistence.CustomerDaoImpl;
import org.glassfish.jersey.examples.server.async.service.CustomerService;
import org.glassfish.jersey.examples.server.async.service.CustomerServiceImpl;

public class ApplicationBinder extends AbstractBinder {
	
    @Override
    protected void configure() {
    	// services
        bind(CustomerServiceImpl.class).to(CustomerService.class).in(Singleton.class);
        
        // dao
        bind(CustomerDaoImpl.class).to(CustomerDao.class).in(Singleton.class);
    }
}