package com.helpdesk.demo.mapper.driver;

import org.springframework.stereotype.Component;

import com.helpdesk.demo.domain.driver.DriverDomain;
import com.helpdesk.demo.mapper.AbstractModelMapper;
import com.helpdesk.demo.model.driver.DriverModel;


@Component
public class DriverMapper extends AbstractModelMapper <DriverModel,DriverDomain>{
	@Override
	public Class<DriverModel> entityType() {
		return DriverModel.class;
	}

	@Override
	public Class<DriverDomain> modelType() {
		return DriverDomain.class;
	}

}
