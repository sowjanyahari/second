package com.helpdesk.demo.service.franchise;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.demo.constants.StatusCode;
import com.helpdesk.demo.dao.franchise.FranchiseDAO;
import com.helpdesk.demo.domain.franchise.FranchiseDomain;
import com.helpdesk.demo.mapper.franchise.FranchiseMapper;
import com.helpdesk.demo.model.franchise.FranchiseModel;
import com.helpdesk.demo.response.Response;
import com.helpdesk.demo.utils.CommonUtils;



@Service
public class FranchiseServiceImpl implements FranchiseService {
	@Autowired
	FranchiseDAO franchiseDAO;
	
	@Autowired
	FranchiseMapper franchiseMapper;
	
	
	private static final Logger logger=LoggerFactory.getLogger(FranchiseServiceImpl.class);
	
	@Override
	public Response addFranchise(FranchiseModel franchiseModel) throws Exception{ 
	try{
		FranchiseDomain franchiseDomain=new FranchiseDomain();
		franchiseDomain.setFranchiseIssueType(franchiseModel.getFranchiseIssueType());
		franchiseDomain.setFranchiseIssueDescription(franchiseModel.getFranchiseIssueDescription());
		franchiseDomain.setIsActive(0);
		
		Response response=franchiseDAO.addFranchise(franchiseDomain);
		return response;
	}
	catch(Exception e) {
		logger.error("Exception Service"+e.getMessage());
		Response response= new Response();
		response.setStatus(StatusCode.ERROR.name());
		response.setErrors(e.getMessage());
		return response;
	}
	}

	/*@Override
	public Response updateFranchise(FranchiseModel franchiseModel) throws Exception {
		FranchiseDomain franchiseDomain=new FranchiseDomain();
		BeanUtils.copyProperties(franchiseModel, franchiseDomain);
		Response response=franchiseDAO.updateFranchise(franchiseDomain);
		
		return response;
	}
*/
	@Override
	public FranchiseModel getFranchise(int franchiseId) throws Exception {
		try {
			
			FranchiseModel franchiseModel=new FranchiseModel();
			FranchiseDomain franchise=franchiseDAO.getFranchise(franchiseId);
			BeanUtils.copyProperties(franchise, franchiseModel);
			return franchiseModel;
		}
		catch(Exception e) {
			logger.error("Exception Service"+e.getMessage());
		return null;
		}
	}
	@Override
	public List<FranchiseModel> getFranchises() throws Exception {
	try {
		List<FranchiseDomain> franchises=franchiseDAO.getFranchises();
		return franchiseMapper.entityList(franchises);
	}
	catch(Exception e) {
		logger.error("exception Service"+e.getMessage());
		return null;
	}
	}

	@Override
	public List<FranchiseModel> getFranchiseSolution() {
		try {
			List<FranchiseDomain> franchises=franchiseDAO.getFranchiseSolution();
			return franchiseMapper.entityList(franchises);
		}
		catch(Exception e) {
			logger.error("exception Service"+e.getMessage());
			return null;
		}

	}
	@Override
	public Response updateFranchise(FranchiseModel franchiseModel) throws Exception {
		
		FranchiseDomain franchiseDomain=new FranchiseDomain();
		BeanUtils.copyProperties(franchiseModel, franchiseDomain);
		Response response=franchiseDAO.updateFranchise(franchiseDomain);
		
		return response;
	
	}
	}
