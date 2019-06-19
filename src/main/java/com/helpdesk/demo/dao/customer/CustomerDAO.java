package com.helpdesk.demo.dao.customer;


import java.util.List;

import com.helpdesk.demo.domain.customer.Customer;
import com.helpdesk.demo.response.Response;

/*--Interface class from Customer Issue for handling DAO--*/

public interface CustomerDAO {
	public Response addCustomer(Customer customer)throws Exception;
	public List<Customer> getCustomer()throws Exception;
	public Customer getCustomers(Integer customer_Issue_Id)throws Exception;
   public Response updateCustomer(Customer customer)throws Exception;
   public List<Customer> getCustomerSolution()throws Exception;

}
