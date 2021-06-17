package com.hibernate.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.hibernate.entity.Customer;
import com.hibernate.util.HibernateUtil;


public class CustomerDao {
	
	
	static SessionFactory sessionFactory = null; 
	//Transaction t=null;
	// fetch and display all 
	public void saveCustomer(Customer c)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//session.save(c.getP_details());
		session.save(c);
		session.getTransaction().commit();
		System.out.println("inserted Successfully \n" + c.toString());
		session.close();
	}
	public Customer getCustomer(int id) {
		
		Customer c;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		c=session.get(Customer.class, id);
		System.out.println(c.toString());
		session.close();
		return c;
	}
	public void displayCustomers(){
		List<Customer> custList=fetchCustomers();
		for(Customer cust:custList)
		{
			System.out.println(cust.toString());
		}
		
	}
	
	public List<Customer> fetchCustomers(){
		System.out.println("Fetching Customers");
		Session session=HibernateUtil.getSessionFactory().openSession();
		
	Query query=session.createQuery("from Customer",Customer.class);
List<Customer> cust=	query.getResultList();
		System.out.println("Fetched "+cust.size());
		return cust;
	}
	





}
