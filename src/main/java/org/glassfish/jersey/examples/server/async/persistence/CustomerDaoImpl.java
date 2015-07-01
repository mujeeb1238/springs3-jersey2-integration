package org.glassfish.jersey.examples.server.async.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.glassfish.jersey.examples.server.async.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerDaoImpl implements CustomerDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist-unit");
	
	public CustomerEntity retrieve(Long id) {
		EntityManager em = emf.createEntityManager();

		CustomerEntity entity = null;

		try {
			entity = em.find(CustomerEntity.class, id);
			System.out.println("First Name: "+entity.getFirstName());
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return entity;
	}

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            CustomerEntity entity = em.find(CustomerEntity.class, id);

            if(entity == null) {
                System.out.println("Error Deleting Customer: Customer not found");
            }
            else {
                em.remove(entity);
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error Deleting Customer: " + e.getMessage());

            transaction.rollback();
        } finally {
            em.close();
        }
    }

	public void save(CustomerEntity customer) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

            em.merge(customer);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error Saving Customer: " + e.getMessage());

			transaction.rollback();
		} finally {
			em.close();
		}
	}
}
