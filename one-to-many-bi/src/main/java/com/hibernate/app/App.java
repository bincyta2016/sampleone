package com.hibernate.app;
import com.hibernate.entity.Customer;


import java.util.ArrayList;
import java.util.List;
import com.hibernate.entity.Policy;
import com.hibernate.dao.PolicyDao;



import com.hibernate.dao.CustomerDao;
import com.hibernate.dao.PolicyDao;




public class App {

	public static void main(String[] args) {

		createCustomer();
		
		
		displayCustomer(1);
		//displayPolicy(10);

	}
	

	public static void createCustomer()
	{
		
		System.out.println("====create====");
		Customer c=new Customer();
		c.setName("bincy");
		c.setAge(22);
		c.setEmail("b@gmail.com");
		c.setNumber(1111);
		
		CustomerDao dao=new CustomerDao();
		
		 List<Policy> p= new ArrayList<Policy>();
	      
		Policy p1=new Policy("jeevn","life",545,54,4);
		Policy p2=new Policy("ic","vehicle",545,4,5);
		
		p.add(p1);
		p.add(p2);
		c.setPlist(p);
		
		
	
		
		dao.saveCustomer(c);
		
		//dao.displayCustomers();
	}
	
	public static void displayCustomer(int id) {
		
		System.out.println("===display customer===");
		CustomerDao dao=new CustomerDao();
		Customer c=dao.getCustomer(id);
		
		List<Policy> lp=c.getPlist();
		for(Policy p:lp)
			displayPolicy(p.getId());
		
		
		
		
	}
	
	public static void displayPolicy(int id) {
		System.out.println("===Display policy===");
		PolicyDao dao=new PolicyDao();
		
		Policy p=dao.getPolicy(id);
		
		
		System.out.println(p.getCustomer().toString());
	}
}