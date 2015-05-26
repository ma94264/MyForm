package com.neil.object;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LAB_GROUP")
public class LabGroupObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2961300352341753752L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "session_start", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date session_start;
	@Column(name = "session_end", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date session_end;
	
	@Column(name = "week_start")
	private int week_start;
	@Column(name = "week_end")
	private int week_end;
	
	@Column(name = "venue")
	private String venue;
	@Column(name = "course")
	private String course;
	
	@Column(name = "group_name")
	private String group;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getSession_start() {
		return session_start;
	}
	public void setSession_start(Date session_start) {
		this.session_start = session_start;
	}
	public Date getSession_end() {
		return session_end;
	}
	public void setSession_end(Date session_end) {
		this.session_end = session_end;
	}
	public int getWeek_start() {
		return week_start;
	}
	public void setWeek_start(int week_start) {
		this.week_start = week_start;
	}
	public int getWeek_end() {
		return week_end;
	}
	public void setWeek_end(int week_end) {
		this.week_end = week_end;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
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
}
