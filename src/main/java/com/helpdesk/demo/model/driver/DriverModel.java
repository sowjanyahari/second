package com.helpdesk.demo.model.driver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class DriverModel {
	private int driverId;
	private String issueType;
	private String issueDescription;
	private String solution;
	private String priority;
	private int isActive;

	

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public DriverModel(){
		
	}
	
	public DriverModel(int driverId,String issueType,String issueDescription,String priority, int isActive,String solution) {
		this.driverId=driverId;
		this.issueType=issueType;
		this.issueDescription=issueDescription;
		this.priority=priority;
		this.isActive=isActive;
		this.solution=solution;
		
		
	}	

}

