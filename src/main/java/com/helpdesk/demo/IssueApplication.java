package com.helpdesk.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* MAIN Spring Application class*/
@SpringBootApplication
public class IssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueApplication.class, args);
		System.out.println("-----WELCOME TO LEVEL 1 ISSUE HANDLER-----");
	}

}
