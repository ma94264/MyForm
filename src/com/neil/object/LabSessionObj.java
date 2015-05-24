package com.neil.object;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LAB_GROUP")
public class LabSessionObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5934229845353126239L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "groupID")
	private long groupID;
	@Column(name = "week_number")
	private int week_number;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	
}
