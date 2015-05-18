package com.neil.object;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REPORT")
public class ReportObj {
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "student_username")
	private String student_username;
	@Column(name = "lab_sessionID")
	private long lab_sessionID;
	
	@Column(name = "file_name")
	private String file_name;
	@Column(name = "submitted_time")
	private Date submitted_time;
	@Column(name = "remark")
	private String remark;
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
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public Date getSubmitted_time() {
		return submitted_time;
	}
	public void setSubmitted_time(Date submitted_time) {
		this.submitted_time = submitted_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
