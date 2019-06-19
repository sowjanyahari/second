package com.helpdesk.demo.service.customer;


import java.util.List;


import com.helpdesk.demo.model.customer.CustomerModel;
import com.helpdesk.demo.response.Response;

/*--Interface class from Customer Issue for handling the customer issue service--*/

public interface CustomerService {
	public Response addCustomer(CustomerModel customerModel)throws Exception;
	public List<CustomerModel> getCustomer()throws Exception;
	public CustomerModel getCustomers(Integer customer_Issue_Id) throws Exception;
	public Response updateCustomer(CustomerModel customerModel)throws Exception;
	public List<CustomerModel> getCustomerSolution()throws Exception;
}

