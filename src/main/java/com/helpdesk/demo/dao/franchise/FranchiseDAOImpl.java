package com.helpdesk.demo.dao.franchise;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.helpdesk.demo.constants.StatusCode;
import com.helpdesk.demo.domain.franchise.FranchiseDomain;
import com.helpdesk.demo.response.Response;
import com.helpdesk.demo.utils.CommonUtils;



@Repository
@Transactional
public class FranchiseDAOImpl implements FranchiseDAO{

	private static final Logger logger=LoggerFactory.getLogger(FranchiseDAOImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Response addFranchise(FranchiseDomain franchiseDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Add Franchise Data");
		try {
			entityManager.persist(franchiseDomain);
			response.setStatus(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception is addfranchise",e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		// TODO Auto-generated method stub
		return response;
	}


	/*@Override
	public Response updateFranchise(FranchiseDomain franchiseDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Update Franchise DAta");
		try {
			FranchiseDomain franchises=getFranchise(franchiseDomain.getFranchiseId());
			franchises.setFranchiseIssueType(franchiseDomain.getFranchiseIssueType());
			franchises.setFranchiseIssueDescription(franchiseDomain.getFranchiseIssueDescription());
			franchises.setFranchiseSolution(franchiseDomain.getFranchiseSolution());
			franchises.setIsActive(1);
			entityManager.flush();
			
			response.setStatus(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception is updateFranchise",e);
			response.setErrors(StatusCode.ERROR.name());
		}
		
		return response;
	}
	*/

	@Override
	public FranchiseDomain getFranchise(int franchiseId) throws Exception {
		try {
			String hql="From Franchise where franchiseId=?1";
			return(FranchiseDomain)entityManager.createQuery(hql).setParameter(1, franchiseId).getSingleResult(); 
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		catch(Exception e) {
			logger.error("Exception is getFranchise"+e.getMessage());
		return null;
	}
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<FranchiseDomain> getFranchises() throws Exception {
		try {
			
			String hql="FROM FranchiseDomain";
			return(List<FranchiseDomain>) entityManager.createQuery(hql).getResultList();
		}
		catch(Exception e) {
			logger.error("Exception is getFranchises",e);
		}
		return null;	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<FranchiseDomain> getFranchiseSolution() throws Exception {
try {
			
			String hql="FROM FranchiseDomain Where isActive=1 ";
			return(List<FranchiseDomain>) entityManager.createQuery(hql).getResultList();
		}
		catch(Exception e) {
			logger.error("Exception is getFranchiseSolution",e);
		}
		return null;	
	}


	@Override
	public Response updateFranchise(FranchiseDomain franchiseDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Update Franchise Data");
		try {
			FranchiseDomain franchises=getFranchise(franchiseDomain.getFranchiseId());
			franchises.setFranchiseIssueType(franchiseDomain.getFranchiseIssueType());
			franchises.setFranchiseIssueDescription(franchiseDomain.getFranchiseIssueDescription());
			franchises.setFranchiseSolution(franchiseDomain.getFranchiseSolution());
			franchises.setIsActive(1);
			entityManager.flush();
			
			response.setStatus(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception is updateFranchise",e);
			response.setErrors(StatusCode.ERROR.name());
		}
		
		return response;
	}
}

