package com.helpdesk.demo.domain.franchise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="franchise17")
public class FranchiseDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FranchiseId")
	private int franchiseId;
	@Column(name="FranchiseIssueType")
	private String franchiseIssueType;
	@Column(name="FranchiseIssueDescription")
	private String franchiseIssueDescription;
	@Column(name="FranchiseSolution")
	private String franchiseSolution;
	@Column(name="isActive")
	private int isActive;

	
	
	public int getFranchiseId() {
		return franchiseId;
	}
	public void setFranchiseId(int franchiseId) {
		this.franchiseId = franchiseId;
	}
	public String getFranchiseIssueType() {
		return franchiseIssueType;
	}
	public void setFranchiseIssueType(String franchiseIssueType) {
		this.franchiseIssueType = franchiseIssueType;
	}
	public String getFranchiseIssueDescription() {
		return franchiseIssueDescription;
	}
	public void setFranchiseIssueDescription(String franchiseIssueDescription) {
		this.franchiseIssueDescription = franchiseIssueDescription;
	}
	public String getFranchiseSolution() {
		return franchiseSolution;
	}
	public void setFranchiseSolution(String franchiseSolution) {
		this.franchiseSolution = franchiseSolution;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public FranchiseDomain(){
	super();	
	}
	public  FranchiseDomain(int franchiseId, String franchiseIssueType, String franchiseIssueDescription,int isActive, String franchiseSolution) {
		super();
		this.franchiseId=franchiseId;
		this.franchiseIssueType=franchiseIssueType;
		this.franchiseIssueDescription=franchiseIssueDescription;
		this.isActive=isActive;
		this.franchiseSolution=franchiseSolution;
	}
}
