package com.helpdesk.demo.service.customer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import javax.imageio.ImageIO;
import org.hibernate.engine.jdbc.BlobProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.demo.constants.StatusCode;
import com.helpdesk.demo.dao.customer.CustomerDAO;
import com.helpdesk.demo.domain.customer.Customer;
import com.helpdesk.demo.mapper.customer.CustomerMapper;
import com.helpdesk.demo.model.customer.CustomerModel;
import com.helpdesk.demo.response.Response;
import com.helpdesk.demo.utils.CommonUtils;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDAO customerDAO;
	

	@Autowired
	CustomerMapper customerMapper;
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	/*--Service Implementation for the Customer issue---*/
	
	@Override
	public Response addCustomer(CustomerModel customerModel) throws Exception {
		try
		{
			Customer customer= new Customer();
			customer.setCustomer_Id(customerModel.getCustomer_Id());
			customer.setIssue_Type(customerModel.getIssue_Type());
			customer.setIssue_Description(customerModel.getIssue_Description());
		    String path=customer.setPath(customerModel.getPath());
		  /*calling the saveImage function for image to Blob conversion */
			customer.setCus_image(BlobProxy.generateProxy(saveImage(path)));
			customer.setCissue_Status(true);
			customer.setSolution_Status(false);
			Response response = customerDAO.addCustomer(customer);
			return response;
		}
		catch(Exception e)
		{
			logger.info("Exception Service:" + e.getMessage());
			Response response=new Response();
			response.setStatus(StatusCode.ERROR.name());
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
/*saveImage function for fetching the image path and convert the image to Blob format*/
	
	private static byte[] saveImage(String imagepath) {
		      File file =new File(imagepath.replace("\\fakepath\\","\\Users\\LENOVO\\Desktop\\Images\\"));
		System.out.println(file.getPath());
		long b=file.length();
		/*Limiting the Image size to 2MB*/
		if(b<2000000) {
		      if(file.exists()){
		         try {
		            BufferedImage bufferedImage=ImageIO.read(file);
		            ByteArrayOutputStream byteOutStream=new ByteArrayOutputStream();
		            ImageIO.write(bufferedImage, "jpg", byteOutStream);
		            return byteOutStream.toByteArray();
		         } catch (IOException e) {
		            e.printStackTrace();
		         }
		      }
		      return null;
		   }
	
	else {
			logger.info("Image size is more than 2MB");
	    }
		 return null;
	}

	/*--Service method for getting all the Customer issue using Model object---*/

	@Override
	public List<CustomerModel> getCustomer() throws Exception {
		try
		{
			List<Customer> customer =customerDAO.getCustomer();
			return customerMapper.entityList(customer);
		} 
		catch (Exception ex)
		{
			logger.info("Exception getParents:", ex);
		}
		return null;
	}

	/*--Service method for getting the particular Customer issue from the list using Model class object---*/
	
	@Override
	public CustomerModel getCustomers(Integer customer_Issue_Id) throws Exception {
		try 
		{
			CustomerModel customerModel = new CustomerModel();
			
			Customer customer = customerDAO.getCustomers(customer_Issue_Id);
		
			 InputStream imgStream =customer.getCus_image().getBinaryStream();
			 /*calling storeImage function*/
	         storeImage(imgStream,customer_Issue_Id);
			BeanUtils.copyProperties(customer, customerModel);
			return customerModel;
		} 
		catch(Exception e) 
		{
			logger.info("Exception getParent:", e);
			return null;
		}
	}

	/*storeImage Function to fetch the blob data from the database and store it in a folder as .jpg image*/

	private void storeImage(InputStream imgStream,Integer customer_Issue_Id) {
		 File file = new File("C:\\Users\\Lenovo\\Desktop\\mmg1\\mmg-help-desk-ui\\Level1\\src\\assets\\"+customer_Issue_Id+".jpg");
		
	      try(FileOutputStream outputStream = new FileOutputStream(file)) {
	         BufferedImage bufferedImage = ImageIO.read(imgStream);
	         ImageIO.write(bufferedImage, "png", outputStream);
	         System.out.println("Image file location: "+file.getCanonicalPath());
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		
	}

/* update service method to update the solution for the problem*/	
	@Override
	public Response updateCustomer(CustomerModel customerModel) throws Exception {
		Customer customer= new Customer();
	
		BeanUtils.copyProperties(customerModel, customer);
		Response res=customerDAO.updateCustomer(customer);
		
		return res;
	}
	
	
	/*--Service method for getting all the Customer solution resolved list using Model object---*/

	@Override
	public List<CustomerModel> getCustomerSolution() throws Exception {
		try
		{
			List<Customer> customer = customerDAO.getCustomerSolution();
			return customerMapper.entityList(customer);
		} 
		catch (Exception ex)
		{
			logger.info("Exception getParents:", ex);
		}
		return null;
	}
}	
