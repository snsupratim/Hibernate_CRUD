package com.code.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	//member variable
	//mapped each member variable to column
	//add constraints also
	//one of the member variable should be primary key
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="firstname",nullable = false,length=30)
	private String firstname;
	@Column(name="lastname",nullable = false,length=30)
	private String lastname;
	@Column(name="emailid",nullable = false,
			length=30,unique = true)
	private String emailid;
	//constructor
	public Instructor()
	{
		this.id=0;
		this.firstname=null;
		this.lastname=null;
		this.emailid=null;
	}
	//create constructor with parameter
	public Instructor(String firstname, String lastname, String emailid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
	}
	//getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid=" + emailid
				+ "]";
	}



}