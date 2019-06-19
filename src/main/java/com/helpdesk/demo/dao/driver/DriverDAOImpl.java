package com.helpdesk.demo.dao.driver;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import com.helpdesk.demo.constants.StatusCode;
import com.helpdesk.demo.domain.driver.DriverDomain;
import com.helpdesk.demo.response.Response;
import com.helpdesk.demo.utils.CommonUtils;



@Repository
@Transactional
public class DriverDAOImpl implements DriverDAO {

	private static final Logger logger=LoggerFactory.getLogger(DriverDAOImpl.class);
	
	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public Response addDriver(DriverDomain driverDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Add Driver data");
		try {
			entitymanager.persist(driverDomain);
			response.setStatus(StatusCode.SUCCESS.name());
		}
		catch(Exception e)
		{
			logger.error("Exception in addUser",e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}


	@Override
	public Response updateDriver(DriverDomain driverDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Update Driver data");
		try {
			DriverDomain drivers=getDriver(driverDomain.getDriverId());
			drivers.setIssueType(driverDomain.getIssueType());
			drivers.setIssueDescription(driverDomain.getIssueDescription());
			drivers.setSolution(driverDomain.getSolution());
			drivers.setIsActive(1);
			entitymanager.flush();
			
			response.setStatus(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception is updateDriver",e);
			response.setStatus(StatusCode.ERROR.name());
		}
		
		return null;
	}


	@Override
	public DriverDomain getDriver(int driverId) throws Exception {
		try {
			String hql="From DriverDomain where driverId=?1";
			return(DriverDomain) entitymanager.createQuery(hql).setParameter(1, driverId).getSingleResult();
		}
		catch(EmptyResultDataAccessException e){
			return null;
		}
		catch(Exception e) {
			logger.error("Exception is getDriver"+e.getMessage());
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DriverDomain> getDrivers() throws Exception {
		try 
		{
			String hql = "FROM DriverDomain Where isActive=0 ";
			
			return(List<DriverDomain>) entitymanager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getDrivers", e); 
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DriverDomain> getDriverSolution() throws Exception {
		try 
		{
			String hql = "FROM DriverDomain Where isActive=1";
			
			return(List<DriverDomain>) entitymanager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getParents", e); 
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DriverDomain> getHighPriorityCount() throws Exception {
		try 
		{
			String hql = "FROM DriverDomain  where priority = 1";
			
			return (List<DriverDomain>) entitymanager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getHighpriority", e);
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DriverDomain> getMediumPriority() throws Exception {
		try 
		{
			String hql = "FROM DriverDomain  where priority = 2";
			
			return (List<DriverDomain>) entitymanager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getMediumPriorities", e);
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DriverDomain> getLowPriority() throws Exception {
		try 
		{
			String hql = "FROM DriverDomain  where priority = 3";
			
			return (List<DriverDomain>) entitymanager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getLowPriorities", e);
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DriverDomain> getPriorityList() throws Exception {
		try 
		{
			String hql = "FROM DriverDomain Where isActive=2";
			
			return(List<DriverDomain>) entitymanager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getPriorityList", e); 
		}
		return null;
	}


	@Override
	public Response updateDriverPriority(DriverDomain driverDomain) throws Exception {
		Response response=CommonUtils.getResponseObject("Update DriverPriority data");
		try {
			DriverDomain drivers=getDriver(driverDomain.getDriverId());
			drivers.setIssueType(driverDomain.getIssueType());
			drivers.setIssueDescription(driverDomain.getIssueDescription());
			drivers.setPriority(driverDomain.getPriority());
			drivers.setIsActive(2);
			entitymanager.flush();
			
			response.setStatus(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception is updateDriverpriority",e);
			response.setStatus(StatusCode.ERROR.name());
		}
		
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DriverDomain> getPriority() throws Exception {
		try 
		{
			String hql = "FROM DriverDomain  where priority = 1";
			
			return (List<DriverDomain>) entitymanager.createQuery(hql).getResultList();
		} 
		catch (Exception e)
		{
			logger.error("Exception in getpriority", e);
		}
		return null;
	}
}
