package com.neil.object;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_LAB")
public class StudentLabObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6918607887145583349L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "student_username")
	private String student_username;
	@Column(name = "groupID")
	private Long groupID;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudent_username() {
		return student_username;
	}
	public void setStudent_username(String student_username) {
		this.student_username = student_username;
	}
	public Long getGroupID() {
		return groupID;
	}
	public void setGroupID(Long groupID) {
		this.groupID = groupID;
	}
	
	
	
	
}
