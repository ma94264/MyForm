package com.neil.object;

import java.io.Serializable;

public class AssessmentSearch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8147942239930387263L;
	private String course;
	private String group;
	private Integer week;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	
}
