package com.hibernate.entity;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 import com.hibernate.dao.CustomerDao;
@Entity
@Table(name="customerss")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	@Column(name="Name")
	private String name;
	//@OneToMany(cascade=CascadeType.ALL)
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	//@JoinTable(name="policyss",joinColumns=@JoinColumn(name="Id"),inverseJoinColumns=@JoinColumn(name="Id"))
	private List<Policy> plist=new ArrayList<Policy>();
	@Column(name="Age")
	private int age;
	@Column(name="Email")
	private String email;
	@Column(name="Number")
	private int number;
	
	
//	public Customer( String name, Policy p_details, int age, String email, int number) {
//		super();
//		
//		this.name = name;
//		this.plist = (List<Policy>) p_details;
//		this.age = age;
//		this.email = email;
//		this.number = number;
//	}
//	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Policy> getPlist() {
		return plist;
	}
	public void setPlist(List<Policy> plist) {
		this.plist = plist;
	}
	public void addPolicy(Policy p)
	{
		plist.add(p);
		p.setCustomer(this);
	}
	public void removePolicy(Policy p)
	{
		plist.remove(p);
		p.setCustomer(null);
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", p_details=" + plist + ", age=" + age + ", email="
				+ email + ", number=" + number + "]";
	}
	

}
