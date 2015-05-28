package com.neil.object;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ASSESSMENT")
public class AssessmentObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4743256129056116910L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "student_username")
	private String student_username;
	@Column(name = "lab_sessionID")
	private long lab_sessionID; 
	@Column(name = "grade")
	private int grade;
	@Column(name = "remark")
	private String remark;
	
	@Transient
	private String student_name;
	
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
	public long getLab_sessionID() {
		return lab_sessionID;
	}
	public void setLab_sessionID(long lab_sessionID) {
		this.lab_sessionID = lab_sessionID;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	
}
