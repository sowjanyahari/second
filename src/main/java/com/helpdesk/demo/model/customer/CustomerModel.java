package com.helpdesk.demo.model.customer;

import java.sql.Blob;

/*--Model class for Customer Issue--*/

public class CustomerModel {
	private Integer customer_Issue_Id;
	private String customer_Id;
	private String issue_Type;
	private String issue_Description;
//	private Blob cus_image;
	  private String path;
	private boolean cissue_Status;
	private boolean solution_Status;
	
	
	public Integer getCustomer_Issue_Id() {
		return customer_Issue_Id;
	}


	public void setCustomer_Issue_Id(Integer customer_Issue_Id) {
		this.customer_Issue_Id = customer_Issue_Id;
	}


	public String getCustomer_Id() {
		return customer_Id;
	}


	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}


	public String getIssue_Type() {
		return issue_Type;
	}


	public void setIssue_Type(String issue_Type) {
		this.issue_Type = issue_Type;
	}


	public String getIssue_Description() {
		return issue_Description;
	}


	public void setIssue_Description(String issue_Description) {
		this.issue_Description = issue_Description;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public boolean isCissue_Status() {
		return cissue_Status;
	}


	public void setCissue_Status(boolean cissue_Status) {
		this.cissue_Status = cissue_Status;
	}


	public boolean isSolution_Status() {
		return solution_Status;
	}


	public void setSolution_Status(boolean solution_Status) {
		this.solution_Status = solution_Status;
	}


	public CustomerModel() {
	}
	
	
	public CustomerModel(Integer customer_Issue_Id,String customer_Id,String issue_Type,String issue_Description,boolean cissue_Status, Blob cus_image,boolean solution_Status) {
	
	this.customer_Issue_Id=customer_Issue_Id;
	this.customer_Id=customer_Id;
	this.issue_Type=issue_Type;
   this.issue_Description=issue_Description;
   this.cissue_Status=cissue_Status;
  this.solution_Status=solution_Status;
	}
}