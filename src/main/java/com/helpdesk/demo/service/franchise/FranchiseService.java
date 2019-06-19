package com.helpdesk.demo.service.franchise;

import java.util.List;

import com.helpdesk.demo.model.franchise.FranchiseModel;
import com.helpdesk.demo.response.Response;


public interface FranchiseService {
	public Response addFranchise(FranchiseModel franchiseModel) throws Exception;
	public Response updateFranchise(FranchiseModel franchiseModel) throws Exception;
	public FranchiseModel getFranchise(int franchiseId) throws Exception;
	public List<FranchiseModel> getFranchises() throws Exception;
	public List<FranchiseModel> getFranchiseSolution() throws Exception;


}
