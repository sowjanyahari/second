package com.helpdesk.demo.domain.customer;


import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="CustomerIssues")

/*--Domain class for Customer Issue--*/

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_Issue_Id")
	private Integer customer_Issue_Id;
	
	@Column(name="customer_Id")
	private String customer_Id;
	
	@Column(name="issue_Type")
	private String issue_Type;

	@Column(name="issue_Description")
	private String issue_Description;
	
	@Column(name = "cus_image")
	   private Blob cus_image;
	
	@Column(name="cissue_Status")
	private boolean cissue_Status;
	
	@Column(name="solution_Status")
	private boolean solution_Status;
	   
	   private String path;
	   
	   /*Getter and Setter Methods*/
	public String getPath() {
		return path;
	}

	public String setPath(String path) {
		return this.path = path;
	}

	public Blob getCus_image() {
		return cus_image;
	}

	public void setCus_image(Blob cus_image) {
		this.cus_image = cus_image;
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

/* Constructor to initialize the Domain class variables*/
	public Customer(Integer customer_Issue_Id,String customer_Id,String issue_Type,String issue_Description,boolean cissue_Status,Blob cus_image,boolean solution_Status) {
		super();
		this.customer_Issue_Id=customer_Issue_Id;
		this.customer_Id=customer_Id;
		this.issue_Type=issue_Type;
	   this.issue_Description=issue_Description;
	   this.cissue_Status=cissue_Status;
	 this.cus_image=cus_image;
	 this.solution_Status=solution_Status;
}
	public Customer() {
		super();
	}
}
