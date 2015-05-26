package com.neil.object;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="COURSE")
public class CourseObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1128460114489971262L;

	@Id
    @Column(name="course")
	private String course;
	
	@Column(name = "program")
	private String program;
	@Column(name = "class_type")
	private String class_type;
	@Column(name = "week1_mon", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date week1_mon;
	@Column(name = "recess_mon", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date recess_mon;
	
	public Date getWeek1_mon() {
		return week1_mon;
	}
	public void setWeek1_mon(Date week1_mon) {
		this.week1_mon = week1_mon;
	}
	public Date getRecess_mon() {
		return recess_mon;
	}
	public void setRecess_mon(Date recess_mon) {
		this.recess_mon = recess_mon;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	
}
