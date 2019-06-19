package com.helpdesk.demo.dao.franchise;

import java.util.List;

import com.helpdesk.demo.domain.franchise.FranchiseDomain;
import com.helpdesk.demo.response.Response;



public interface FranchiseDAO {
	public Response addFranchise(FranchiseDomain franchiseDomain) throws Exception;
	public Response updateFranchise(FranchiseDomain franchiseDomain) throws Exception;
	public FranchiseDomain getFranchise(int franchiseId )throws Exception;
	public List<FranchiseDomain> getFranchises() throws Exception;
	public List<FranchiseDomain> getFranchiseSolution() throws Exception;
}
