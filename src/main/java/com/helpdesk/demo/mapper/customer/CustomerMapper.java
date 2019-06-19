package com.helpdesk.demo.mapper.customer;

import org.springframework.stereotype.Component;

import com.helpdesk.demo.domain.customer.Customer;
import com.helpdesk.demo.mapper.AbstractModelMapper;
import com.helpdesk.demo.model.customer.CustomerModel;


@Component
/*Mapped class for connecting domain and model class*/

public class CustomerMapper extends AbstractModelMapper<CustomerModel, Customer>{

	@Override
	public Class<CustomerModel> entityType() {
		return CustomerModel.class;
	}

	@Override
	public Class<Customer> modelType() {
		return Customer.class;
	}
}
