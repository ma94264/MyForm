package com.neil.object;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
