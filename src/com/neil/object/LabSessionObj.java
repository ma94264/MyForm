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
@Table(name="LAB_SESSION")
public class LabSessionObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5934229845353126239L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "professor_username")
	private String professor_username;
	
	@Column(name = "groupID")
	private long groupID;
	@Column(name = "week_number")
	private int week_number;
	@Transient
	private LabGroupObj lgo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LabGroupObj getLgo() {
		return lgo;
	}
	public void setLgo(LabGroupObj lgo) {
		this.lgo = lgo;
	}
	
	public long getGroupID() {
		return groupID;
	}
	public void setGroupID(long groupID) {
		this.groupID = groupID;
	}
	public int getWeek_number() {
		return week_number;
	}
	public void setWeek_number(int week_number) {
		this.week_number = week_number;
	}
	public String getProfessor_username() {
		return professor_username;
	}
	public void setProfessor_username(String professor_username) {
		this.professor_username = professor_username;
	}
	
}
