package com.helpdesk.demo.dao.customer;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.helpdesk.demo.constants.StatusCode;
import com.helpdesk.demo.domain.customer.Customer;
import com.helpdesk.demo.response.Response;
import com.helpdesk.demo.utils.CommonUtils;

@Repository
@Transactional

/*--DAO Implementation for the Customer issue---*/

public class CustomerDAOImpl implements CustomerDAO{

	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);


	@PersistenceContext
	EntityManager entityManager;

	/*--DAO method for adding the Customer issue using Domain object---*/
	
	@Override
	public Response addCustomer(Customer customer) throws Exception {
		Response response = CommonUtils.getResponseObject("Add Customer data");
		try 
		{
			entityManager.persist(customer);
			response.setStatus(StatusCode.SUCCESS.name());
		} 
		catch (Exception e) 
		 
		{
			logger.error("Exception in addUser", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;

}
	
	/*--DAO method for getting all the Customer issue list using Domain object---*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomer() throws Exception {
		try 
		{
			String hql = "FROM Customer where cissue_Status=true";
			
			return (List<Customer>) entityManager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getParents", e);
		}
		return null;
	}

	/*--DAO method for getting the particular Customer issue from the list using Domain object---*/

	@Override
	public Customer getCustomers(Integer customer_Issue_Id) throws Exception {

		try 
		{
			String hql = "From Customer where customer_Issue_Id=?1 and cissue_Status=true";
			return (Customer) entityManager.createQuery(hql).setParameter(1, customer_Issue_Id).getSingleResult();
		} 
		catch (EmptyResultDataAccessException e) 
		{
			return null;
		} 
		catch (Exception e) 
		{
			logger.error("Exception in getting cusstomer details"+ e.getMessage());
	        return null;
	}
	}

/*DAO update method to update the solution to database */
	@Override
	public Response updateCustomer(Customer customer) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Customer data");
		try {
			Customer customers=getCustomers(customer.getCustomer_Issue_Id());
			customers.setIssue_Type(customers.getIssue_Type());
			customers.setIssue_Description(customer.getIssue_Description());
			customers.setCissue_Status(false);
			customers.setSolution_Status(true);
		
			response.setStatus(StatusCode.SUCCESS.name());
		}catch(Exception e) {
			logger.error("Exceptio is Update Customer");
			response.setStatus(StatusCode.ERROR.name());
			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerSolution() throws Exception {
		try 
		{
			String hql = "From Customer where solution_Status=true";
			
			return (List<Customer>) entityManager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getParents", e);
		}
		return null;
	}



}
