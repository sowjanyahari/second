package com.helpdesk.demo.service.driver;

import java.util.List;
import com.helpdesk.demo.model.driver.DriverModel;
import com.helpdesk.demo.response.Response;



public interface DriverService {
	public Response addDriver(DriverModel driverModel) throws Exception;
	public Response updateDriver(DriverModel driverModel) throws Exception;
	public DriverModel getDriver(int driverId) throws Exception;
	public List<DriverModel> getDrivers() throws Exception;
	public List<DriverModel> getDriverSolution() throws Exception;
	public List<DriverModel> getHighPriorityCount() throws Exception;
	public List<DriverModel> getMediumPriority() throws Exception;
	public List<DriverModel> getLowPriority()throws Exception;
	public List<DriverModel> getPriorityList() throws Exception;
	public Response updateDriverPriority(DriverModel driverModel) throws Exception;
	public List<DriverModel> getPriority() throws Exception;
}
