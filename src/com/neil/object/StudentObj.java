package com.neil.object;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class StudentObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2312738339276338463L;

	@Id
    @Column(name="username")
	private String username;
	
	@Column(name = "name")
	private String name;

	@Column(name = "course_type")
	private String course_type;
	
	@Column(name = "nationality")
	private String nationality;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse_type() {
		return course_type;
	}

	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
