package com.helpdesk.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.helpdesk.demo.constants.StatusCode;
import com.helpdesk.demo.dao.driver.DriverDAO;
import com.helpdesk.demo.model.driver.DriverModel;
import com.helpdesk.demo.response.ErrorObject;
import com.helpdesk.demo.response.Response;
import com.helpdesk.demo.service.driver.DriverService;
import com.helpdesk.demo.utils.CommonUtils;



@RestController
@RequestMapping("/111")
@CrossOrigin(origins="*",allowedHeaders="*")
public class DriversController {

	private static final Logger logger=LoggerFactory.getLogger(DriversController.class);
	@Autowired
	DriverService driverService;
	
	@Autowired
	DriverDAO driverDao;
	/*-----------------------------------------------Add Driver------------------------------------*/
	
	@RequestMapping(value="/create",method=RequestMethod.POST,produces="application/json")
	public Response addDriver(@RequestBody DriverModel driverModel,HttpServletRequest request,HttpServletResponse response)
	throws Exception
	{
		logger.info("addDriver: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("added Driver: Received request: "+ CommonUtils.getJson(driverModel));
		//upload the file
		
		 
		return driverService.addDriver(driverModel);
		
	}

	/*-----------------------------------------------get Driver by Id------------------------------------*/
	
	
	@RequestMapping(value="/getDriver/{driverId}" ,method=RequestMethod.GET,produces="application/json")
	public @ResponseBody String getDriver(@PathVariable int driverId,HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		logger.info("getDriver:Recieved request URL:"+request.getRequestURI().toString()
		+((request.getQueryString()==null)?"":"?"+ request.getQueryString().toString()));
		DriverModel driverModel=driverService.getDriver(driverId);
		Response res = CommonUtils.getResponseObject("Driver Details");
		if (driverModel == null)
		{
			ErrorObject err = CommonUtils.getErrorResponse("Drivers Not Found", "Drivers Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} 
		else
		{
			res.setData(driverModel);
		}
		logger.info("getDriver: Sent response");
		return CommonUtils.getJson(res);
		
	}
	
	/*----------------------------------update Driver------------------------*/
	@RequestMapping(value="/update",method=RequestMethod.PUT,produces="application/json")
	public Response updateDriver(@RequestBody DriverModel driverModel,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("updateDriver:Received request URL:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)? "":"?"+request.getQueryString().toString()));
		logger.info("addUser:Receiver resuest:"+CommonUtils.getJson(driverModel));
		
		return driverService.updateDriver(driverModel);
	}


	/*-----------------------------------------------Get DriverList-------------------------------------------------------*/
	

	@RequestMapping(value="/getDrivers",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody String getDrivers(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("getDriver:Received request URL:"+request.getRequestURI().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
				List<DriverModel> driverModel=driverService.getDrivers();
				
				 Response res = CommonUtils.getResponseObject("Parent Details");
					if (driverModel == null)
					{
						ErrorObject err = CommonUtils.getErrorResponse("Drivers Not Found", "Drivers Not Found");
						res.setErrors(err);
						res.setStatus(StatusCode.ERROR.name());
					} 
					else
					{
						res.setData(driverModel);
					}
					logger.info("getDrivers: Sent response");
					return CommonUtils.getJson(res);
	}


	/*-----------------------------------------------Get Driver Solution List------------------------------------------------*/
	
	@RequestMapping(value="/getDriverSolution",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody String getDriverSolution(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("getDriver:Received request URL:"+request.getRequestURI().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
				List<DriverModel> driverModel=driverService.getDriverSolution();
				
				 Response res = CommonUtils.getResponseObject("Driver Details");
					if (driverModel == null)
					{
						ErrorObject err = CommonUtils.getErrorResponse("Drivers Not Found", "Drivers Not Found");
						res.setErrors(err);
						res.setStatus(StatusCode.ERROR.name());
					} 
					else
					{
						res.setData(driverModel);
					}
					logger.info("getDriver Solution: Sent response");
					return CommonUtils.getJson(res);
	}
	/*-----------------------------------------------Get Driver HighPriority------------------------------------------------*/

	@RequestMapping(value = "/HighPriorityCount", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getHighPriorityCount(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("getHighpriority: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<DriverModel> model = driverService.getHighPriorityCount();
		
		
		Response res = CommonUtils.getResponseObject("List of  High priority count Priority");
		if (model == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Priority Not Found", "Priority Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(model);
		}
		logger.info("getHighPriority: Sent response");
		return CommonUtils.getJson(res);
	}
	

/*--------------------------------------------Medium Priority-----------------------------------------*/


@RequestMapping(value = "/MediumPriority", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody String getMediumPriority(HttpServletRequest request, HttpServletResponse response) throws Exception 
{
	logger.info("getMediumpriority: Received request: " + request.getRequestURL().toString()
			+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	List<DriverModel> model =driverService.getMediumPriority();
	
	
	Response res = CommonUtils.getResponseObject("List of Priority");
	if (model == null) {
		ErrorObject err = CommonUtils.getErrorResponse("Priority Not Found", "Priority Not Found");
		res.setErrors(err);
		res.setStatus(StatusCode.ERROR.name());
	} else {
		res.setData(model);
	}
	logger.info("getPriority: Sent response");
	return CommonUtils.getJson(res);
}

/*--------------------------------------------Low Priority-----------------------------------------*/

@RequestMapping(value = "/LowPriority", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody String getLowPriority(HttpServletRequest request, HttpServletResponse response) throws Exception 
{
	logger.info("getParents: Received request: " + request.getRequestURL().toString()
			+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	List<DriverModel> model = driverService.getLowPriority();
	
	
	Response res = CommonUtils.getResponseObject("List of Priority");
	if (model == null) {
		ErrorObject err = CommonUtils.getErrorResponse("Priority Not Found", "Priority Not Found");
		res.setErrors(err);
		res.setStatus(StatusCode.ERROR.name());
	} else {
		res.setData(model);
	}
	logger.info("getPriority: Sent response");
	return CommonUtils.getJson(res);
}

/*-----------------------------------------------Get Driver Priority List------------------------------------------------*/

@RequestMapping(value="/getPriorityList",method=RequestMethod.GET,produces="application/json")
public @ResponseBody String getPriorityList(HttpServletRequest request,HttpServletResponse response)
throws Exception{
	logger.info("getPriorityList:Received request URL:"+request.getRequestURI().toString()
			+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
			List<DriverModel> driverModel=driverService.getPriorityList();
			 Response res = CommonUtils.getResponseObject("Driver Details");
				if (driverModel == null)
				{
					ErrorObject err = CommonUtils.getErrorResponse("PriorityList Not Found", "PriorityList Not Found");
					res.setErrors(err);
					res.setStatus(StatusCode.ERROR.name());
				} 
				else
				{
					res.setData(driverModel);
				}
				logger.info("getPriorityList : Sent response");
				return CommonUtils.getJson(res);
}

/*-----------------------------------------------Update driver Priority------------------------------------------------*/
@RequestMapping(value="/updatepriority",method=RequestMethod.PUT,produces="application/json")
public Response updateDriverPriority(@RequestBody DriverModel driverModel,HttpServletRequest request,HttpServletResponse response)
throws Exception{
	logger.info("updateDriverPriority:Received request URL:"+request.getRequestURL().toString()
			+((request.getQueryString()==null)? "":"?"+request.getQueryString().toString()));
	logger.info("updated Driverpriority:Receiver resuest:"+CommonUtils.getJson(driverModel));
	
	return driverService.updateDriverPriority(driverModel);
}



@RequestMapping(value="/getPriority",method=RequestMethod.GET,produces="application/json")
public @ResponseBody String getPriority(HttpServletRequest request,HttpServletResponse response)
throws Exception{
	logger.info("getPriorityList:Received request URL:"+request.getRequestURI().toString()
			+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
			List<DriverModel> driverModel=driverService.getPriority();
			 Response res = CommonUtils.getResponseObject("Driver Details");
				if (driverModel == null)
				{
					ErrorObject err = CommonUtils.getErrorResponse("PriorityList Not Found", "PriorityList Not Found");
					res.setErrors(err);
					res.setStatus(StatusCode.ERROR.name());
				} 
				else
				{
					res.setData(driverModel);
				}
				logger.info("getPriority : Sent response");
				return CommonUtils.getJson(res);
}
}


