package com.code.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
//member variable
//mapped each member variable to column
//declared one the member variable as PK
	@Id //PK
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name="courseid")
	private int courseid;
	@Column(name="title",length=30,nullable = false,unique = true)
	private String title;
	@Column(name="fees",nullable = false)
	private double fees;
	@Column(name="duration",length=20,nullable = false)
	private String duration;
	//create a relationship
	//Instructor ManyToOne
	@ManyToOne
	@JoinColumn(name="instructorid")
	private Instructor instructor;
	//create a default constructor
	public Course()
	{
		//set the default value
		this.courseid=0;
		this.duration=null;
		this.fees=0;
		this.instructor=null;
		this.title=null;
	}
	//create a constrcutor with parameter
	public Course(String title, double fees, String duration, Instructor instructor) {
		super();
		this.title = title;
		this.fees = fees;
		this.duration = duration;
		this.instructor = instructor;
	}
	//getter and setter
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	//toString()
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", title=" + title + ", fees=" + fees + ", duration=" + duration
				+ ", instructor=" + instructor + "]";
	}
	
}