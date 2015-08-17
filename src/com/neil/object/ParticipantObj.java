package com.neil.object;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="c1")
public class ParticipantObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2312738339276338463L;

	@Id
	@GeneratedValue
    @Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "contact")
	private String contact;

	@Column(name = "car")
	private String car;
	
	@Column(name = "create_date")
	private Date create_date;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
