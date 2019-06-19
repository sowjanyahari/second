package com.helpdesk.demo.mapper.franchise;

import org.springframework.stereotype.Component;

import com.helpdesk.demo.domain.franchise.FranchiseDomain;
import com.helpdesk.demo.mapper.AbstractModelMapper;
import com.helpdesk.demo.model.franchise.FranchiseModel;

@Component
public class FranchiseMapper  extends AbstractModelMapper<FranchiseModel,FranchiseDomain> {

	@Override
	public Class<FranchiseModel> entityType() {
		// TODO Auto-generated method stub
		return FranchiseModel.class;
	}

	@Override
	public Class<FranchiseDomain> modelType() {
		// TODO Auto-generated method stub
		return FranchiseDomain.class;
	}

}

