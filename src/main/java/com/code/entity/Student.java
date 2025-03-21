package com.code.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
@Id//PK
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="studentid")
private int studentid;
@Column(name="fname",length = 20,nullable = false)
private String fname;
@Column(name="lname",length = 20,nullable = false)
private String lname;
@Column(name="emailid",length = 20,nullable = false,unique = true)
private String emailid;
@Column(name="mobile",length=10,nullable=false,unique=true)
private String mobileno;
//create relationship Many to many
//with Course
@ManyToMany
@JoinTable(name="student_course",
			joinColumns  = @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="course_id"))
private List<Course> courses;
//create default constructor
public Student() {
	this.courses=null;
	this.emailid=null;
	this.fname=null;
	this.lname=null;
	this.studentid=0;
	this.mobileno=null;
	
}
//constructor using parameter
public Student(String fname, String lname, String emailid, String mobileno) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.emailid = emailid;
	this.mobileno = mobileno;
}
//getter and setter
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public List<Course> getCourses() {
	return courses;
}
public void setCourses(List<Course> courses) {
	this.courses = courses;
}
public void setMobileno(String mobileno) {
	this.mobileno=mobileno;
}
//create one method to add the course
public void addCourse(Course course)
{
	//check the courses is null
	//create the object of the courses
	if(courses==null)
	{
		courses=new ArrayList<Course>();
	}
	//add to list
	courses.add(course);
}
//toString()
@Override
public String toString() {
	return "Student [studentid=" + studentid + ", mobile = "+ mobileno +" fname=" + fname + ", lname=" + lname + ", emailid=" + emailid
			+ ", courses=" + courses + "]";
}

}