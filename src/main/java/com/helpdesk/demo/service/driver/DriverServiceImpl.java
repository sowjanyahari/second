package com.helpdesk.demo.service.driver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.helpdesk.demo.constants.StatusCode;
import com.helpdesk.demo.dao.driver.DriverDAO;
import com.helpdesk.demo.domain.driver.DriverDomain;
import com.helpdesk.demo.mapper.driver.DriverMapper;
import com.helpdesk.demo.model.driver.DriverModel;
import com.helpdesk.demo.response.Response;



@Service
public class DriverServiceImpl implements DriverService {


	private static final Logger logger=LoggerFactory.getLogger(DriverServiceImpl.class);
	@Autowired
	DriverDAO driverDao;
	
	@Autowired
	DriverMapper driverMapper;
	/*--------------------------------------------update driver -----------------------------------------*/
	@Override
	public Response updateDriver(DriverModel driverModel) throws Exception {
		DriverDomain driverDomain=new DriverDomain();
		BeanUtils.copyProperties(driverModel, driverDomain);
			Response response=driverDao.updateDriver(driverDomain);
			return response;
	}
	/*-------------------------------------------add driver issue-----------------------------------------*/
	@Override
	public Response addDriver(DriverModel driverModel) throws Exception {
		try {
			DriverDomain driverDomain=new DriverDomain();
			driverDomain.setIssueType(driverModel.getIssueType());
			driverDomain.setIssueDescription(driverModel.getIssueDescription());
			driverDomain.setIsActive(0);

			
			Response response=driverDao.addDriver(driverDomain);
			return response;
		}
		catch(Exception e){
			logger.error("Exception Service"+e.getMessage());
			Response response=new Response();
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}
	/*-------------------------------------------- get driver by Id-----------------------------------------*/
	@Override
	public DriverModel getDriver(int driverId) throws Exception {
		try {
			DriverModel driverModel=new DriverModel();
			DriverDomain driverDomain=driverDao.getDriver(driverId);
			BeanUtils.copyProperties(driverDomain, driverModel);
			return driverModel;
		}
			catch(Exception e) {
				logger.info("Exception Service"+e.getMessage());
				return null;
			}
		}
	/*------------------------------------------get Drivers list----------------------------------------*/
	@Override
	public List<DriverModel> getDrivers() throws Exception {
		try {
			List<DriverDomain> drivers=driverDao.getDrivers();
			return driverMapper.entityList(drivers);
	}
		catch(Exception ex) {
			logger.error("exception Service"+ex.getMessage());
			return null;
		}
		
	}
	/*--------------------------------------------getDriverSolution-----------------------------------------*/
	@Override
	public List<DriverModel> getDriverSolution() throws Exception {
		try {
			List<DriverDomain> drivers=driverDao.getDriverSolution();
			return driverMapper.entityList(drivers);
	}
		catch(Exception ex) {
			logger.error("exception Service"+ex.getMessage());
			return null;
		}


	}
	/*--------------------------------------------High priority-----------------------------------------*/
	@Override
	public List<DriverModel> getHighPriorityCount() throws Exception {

		try{
			
			List<DriverDomain> priority = driverDao.getHighPriorityCount();
			return driverMapper.entityList(priority);
			
			
		}catch(Exception ex){
			logger.info("Exception getHighpriority:", ex);
			
		}
		return null;
	}
	/*--------------------------------------------Medium priority-----------------------------------------*/
	@Override
	public List<DriverModel> getMediumPriority() throws Exception {

		try{
			
			List<DriverDomain> priority = driverDao.getMediumPriority();
			return driverMapper.entityList(priority);
			
			
		}catch(Exception ex){
			logger.info("Exception getmediumPriority:", ex);
			
		}
		return null;
	}
	/*--------------------------------------------Low List-----------------------------------------*/
	@Override
	public List<DriverModel> getLowPriority() throws Exception {

		try{
			
			List<DriverDomain> priority = driverDao.getLowPriority();
			return driverMapper.entityList(priority);
			
			
		}catch(Exception ex){
			logger.info("Exception getLowPriority:", ex);
			
		}
		return null;
	}
	/*-------------------------------------------getPriorityList-----------------------------------------*/
	@Override
	public List<DriverModel> getPriorityList() throws Exception {
		try {
			List<DriverDomain> drivers=driverDao.getPriorityList();
			return driverMapper.entityList(drivers);
	}
		catch(Exception ex) {
			logger.error("exception priority List"+ex.getMessage());
			return null;
		}


	}
	/*-------------------------------------------update priority-----------------------------------------*/
	@Override
	public Response updateDriverPriority(DriverModel driverModel) throws Exception {
		DriverDomain driverDomain=new DriverDomain();
		BeanUtils.copyProperties(driverModel, driverDomain);
			Response response=driverDao.updateDriverPriority(driverDomain);
			return response;
	}
	
	
	
	@Override
	public List<DriverModel> getPriority() throws Exception {
try{
			
			List<DriverDomain> priority = driverDao.getPriority();
			return driverMapper.entityList(priority);
			
			
		}catch(Exception ex){
			logger.info("Exception getParents:", ex);
			
		}
		return null;
	}
}

