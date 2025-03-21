package com.code.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "instructor_profile")
public class InstructorProfile {

	// Declare primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "degree", length = 10)
	private String degree;

	@Column(name = "hobby", length = 20)
	private String hobby;

	@Column(name = "channel", length = 30)
	private String youtubeChannel;

	// One-to-one relationship with Instructor
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructorid")  // Fix column name if needed
	private Instructor instructor;

	// Default constructor
	public InstructorProfile() {
		//this refers to the current class
		this.id =0;
		this.degree=null;
		this.hobby=null;
		this.youtubeChannel=null;
		this.instructor=null;
	}

	// Parameterized constructor
	public InstructorProfile( String degree, String hobby, String youtubeChannel, Instructor instructor) {
		this.degree = degree;
		this.hobby = hobby;
		this.youtubeChannel = youtubeChannel;
		this.instructor = instructor;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorProfile{" +
				"id=" + id +
				", degree='" + degree + '\'' +
				", hobby='" + hobby + '\'' +
				", youtubeChannel='" + youtubeChannel + '\'' +
				", instructor=" + instructor +
				'}';
	}
}