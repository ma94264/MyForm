package com.neil.object;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REPORT_DEADLINE")
public class ReportDeadlineObj {
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "lab_sessionID")
	private long lab_sessionID;
	
	@Column(name = "due_date")
	private Date due_date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLab_sessionID() {
		return lab_sessionID;
	}

	public void setLab_sessionID(long lab_sessionID) {
		this.lab_sessionID = lab_sessionID;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
	
	
}
