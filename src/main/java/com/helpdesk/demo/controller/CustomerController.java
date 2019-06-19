package com.helpdesk.demo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.demo.constants.StatusCode;
import com.helpdesk.demo.dao.customer.CustomerDAO;
import com.helpdesk.demo.model.customer.CustomerModel;
import com.helpdesk.demo.response.ErrorObject;
import com.helpdesk.demo.response.Response;
import com.helpdesk.demo.service.customer.CustomerService;
import com.helpdesk.demo.utils.CommonUtils;



@RestController
@RequestMapping("/customerIssue")
@CrossOrigin(origins="*",allowedHeaders="*")

/*Controller class for Customer Issue handling*/

public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired 
	CustomerService customerService;
	
	@Autowired 
	CustomerDAO customerDAO;
	/*----Adding new Customer Issue----*/
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, produces = "application/json")
	public Response addCustomer(@RequestBody CustomerModel customer, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("addCustomer: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addUser: Received request: "+ CommonUtils.getJson(customer));
		
		return customerService.addCustomer(customer);
		
	}
	
	/*----Getting the overall Customer Issue in the form of list----*/
	
	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("getCustomer: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<CustomerModel> model = customerService.getCustomer();
		
		
		Response res = CommonUtils.getResponseObject("List of Customers");
		if (model == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Customers Not Found", "Customers Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(model);
		}
		logger.info("getCustomer: Sent response");
		return CommonUtils.getJson(res);
}
	/*----Getting the particular customer issue details from the list----*/
	
	@RequestMapping(value = "/getCustomers/{customer_Issue_Id}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody String getCustomers(@PathVariable("customer_Issue_Id") Integer customer_Issue_Id, HttpServletRequest request,
		HttpServletResponse response) throws Exception 
{

	logger.info("getCustomers: Received request: " + request.getRequestURL().toString()
			+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	
	CustomerModel customerModel = customerService.getCustomers(customer_Issue_Id);
	
	 Response res = CommonUtils.getResponseObject("Customer issue Details");
	if (customerModel == null)
	{
		ErrorObject err = CommonUtils.getErrorResponse("Customer issue Not Found", "Customer issue Not Found");
		res.setErrors(err);
		res.setStatus(StatusCode.ERROR.name());
	} 
	else
	{
		res.setData(customerModel);
	}
	logger.info("getCustomers: Sent response");
	return CommonUtils.getJson(res);
}
	
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, produces = "application/json")
	public Response updateCustomer(@RequestBody CustomerModel customer, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("updateCustomer: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateCustomer: Received request: "+ CommonUtils.getJson(customer));
		
		return customerService.updateCustomer(customer);
		
	}
	
	/*----Getting the overall Solved Customer Issue in the form of list----*/
	
	@RequestMapping(value = "/getCustomerSolution", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getCustomerSolution(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("getCustomerSolution: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<CustomerModel> model1 = customerService.getCustomerSolution();
		
		
		Response res = CommonUtils.getResponseObject("List of Customers isuues solved");
		if (model1 == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Customers Not Found", "Customers Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(model1);
		}
		logger.info("getCustomerSolution: Sent response");
		return CommonUtils.getJson(res);
}
	 
}