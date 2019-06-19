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
import com.helpdesk.demo.dao.franchise.FranchiseDAO;
import com.helpdesk.demo.model.franchise.FranchiseModel;
import com.helpdesk.demo.response.ErrorObject;
import com.helpdesk.demo.response.Response;
import com.helpdesk.demo.service.franchise.FranchiseService;
import com.helpdesk.demo.utils.CommonUtils;



@RestController
@RequestMapping("/111")
@CrossOrigin(origins="*",allowedHeaders="*")
public class FranchiseController {
	private static final Logger logger=LoggerFactory.getLogger(FranchiseController.class);
	@Autowired
	FranchiseService franchiseService;
	
	@Autowired
	FranchiseDAO franchiseDAO;
	
	@RequestMapping(value="/createfranchise",method=RequestMethod.POST,produces="application/json")
	public Response addFranchise(@RequestBody FranchiseModel franchiseModel,HttpServletRequest request,HttpServletResponse response)
throws Exception{
		logger.info("addFrancgise: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addFranchise: Received request: "+ CommonUtils.getJson(franchiseModel));
		//upload the file
	return franchiseService.addFranchise(franchiseModel);
	}
	
	
@RequestMapping(value="/updatefranchise",method=RequestMethod.PUT,produces="application/json")
	public Response updateFranchise(@RequestBody FranchiseModel franchiseModel,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("updateFranchise:Received request URL:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)? "":"?"+request.getQueryString().toString()));
		logger.info("addUser:Receiver request:"+CommonUtils.getJson(franchiseModel));
		
		return franchiseService.updateFranchise(franchiseModel);
	}
	
	
	
	
	@RequestMapping(value="/getFranchises",method=RequestMethod.GET,produces="angular/json")
	public @ResponseBody String getFranchises(HttpServletRequest request,HttpServletResponse response)
			throws Exception{
				logger.info("getDriver:Received request URL:"+request.getRequestURI().toString()
						+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
						List<FranchiseModel> franchiseModel=franchiseService.getFranchises();
						
						 Response res = CommonUtils.getResponseObject("Parent Details");
							if (franchiseModel == null)
							{
								ErrorObject err = CommonUtils.getErrorResponse("Franchises Not Found", "Franchises Not Found");
								res.setErrors(err);
								res.setStatus(StatusCode.ERROR.name());
							} 
							else
							{
								res.setData(franchiseModel);
							}
							logger.info("getFranchises: Sent response");
							return CommonUtils.getJson(res);
			}
	@RequestMapping(value="/getFranchise/{franchiseId}",method=RequestMethod.GET,produces="angular/json")
	String getDriver(@PathVariable Integer franchiseId,HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		logger.info("getFranchise:Recieved request URL:"+request.getRequestURI().toString()
		+((request.getQueryString()==null)?"":"?"+ request.getQueryString().toString()));
		FranchiseModel franchiseModel=franchiseService.getFranchise(franchiseId);
		Response res = CommonUtils.getResponseObject("Franchise Details");
		if (franchiseModel == null)
		{
			ErrorObject err = CommonUtils.getErrorResponse("Franchises Not Found", "Franchises Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} 
		else
		{
			res.setData(franchiseModel);
		}
		logger.info("getFranchise: Sent response");
		return CommonUtils.getJson(res);
		
		
	}
	
	@RequestMapping(value="/getFranchiseSolution",method=RequestMethod.GET,produces="angular/json")
	public @ResponseBody String getFranchiseSolution(HttpServletRequest request,HttpServletResponse response)
			throws Exception{
				logger.info("getDriver:Received request URL:"+request.getRequestURI().toString()
						+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
						List<FranchiseModel> franchiseModel=franchiseService.getFranchiseSolution();
						
						 Response res = CommonUtils.getResponseObject("Parent Details");
							if (franchiseModel == null)
							{
								ErrorObject err = CommonUtils.getErrorResponse("FranchiseSolution Not Found", "FranchiseSolution Not Found");
								res.setErrors(err);
								res.setStatus(StatusCode.ERROR.name());
							} 
							else
							{
								res.setData(franchiseModel);
							}
							logger.info("getFranchiseSolution: Sent response");
							return CommonUtils.getJson(res);
			}
	}
