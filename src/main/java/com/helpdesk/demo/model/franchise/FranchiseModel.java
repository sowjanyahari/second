package com.helpdesk.demo.model.franchise;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class FranchiseModel {
private int franchiseId;
private String franchiseIssueType;
private String franchiseIssueDescription;
private int isActive;
private String franchiseSolution;

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

public int getIsActive() {
	return isActive;
}

public void setIsActive(int isActive) {
	this.isActive = isActive;
}

public String getFranchiseSolution() {
	return franchiseSolution;
}

public void setFranchiseSolution(String franchiseSolution) {
	this.franchiseSolution = franchiseSolution;
}

public FranchiseModel() {
	
}

public FranchiseModel(int franchiseId, String franchiseIssueDescription, String franchiseIssueType, int isActive, String franchiseSolution) {
	this.franchiseId=franchiseId;
	this.franchiseIssueType=franchiseIssueType;
	this.franchiseIssueDescription=franchiseIssueDescription;
	this.isActive=isActive;
	this.franchiseSolution=franchiseSolution;
}



}
