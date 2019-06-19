package com.helpdesk.demo.domain.driver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="driverIssue")
public class DriverDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="driverId")
	private int driverId;
	
	
	@Column(name="issueType")
	private String issueType;
	
	@Column(name="issueDescription")
	private String issueDescription;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="isActive")
	private int isActive;
	
	@Column(name="solution")
	private String solution;

	
	
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
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public DriverDomain() {
		super();
	}
	public DriverDomain(int driverId,String issueType,String issueDescription,String priority, int isActive,String solution) {
		super();
		this.driverId=driverId;
		this.issueType=issueType;
		this.issueDescription=issueDescription;
		this.priority=priority;
		this.isActive=isActive;
		this.solution=solution;
		
	}
}
