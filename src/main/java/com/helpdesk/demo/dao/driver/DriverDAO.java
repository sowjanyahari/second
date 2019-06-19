package com.helpdesk.demo.dao.driver;

import java.util.List;
import com.helpdesk.demo.domain.driver.DriverDomain;
import com.helpdesk.demo.response.Response;



public interface DriverDAO {
	public Response addDriver(DriverDomain driverDomain) throws Exception;
	public Response updateDriver(DriverDomain driverDomain) throws Exception;
	public DriverDomain getDriver(int driverId) throws Exception;
	public List<DriverDomain> getPriority()throws Exception;
	public List<DriverDomain> getDrivers()throws Exception;
	public List<DriverDomain> getDriverSolution() throws Exception;
	public List<DriverDomain> getHighPriorityCount()throws Exception;
	public List<DriverDomain> getMediumPriority()throws Exception;
	public List<DriverDomain> getLowPriority()throws Exception;
	public List<DriverDomain> getPriorityList()throws Exception;
	public Response updateDriverPriority(DriverDomain driverDomain) throws Exception;
}
