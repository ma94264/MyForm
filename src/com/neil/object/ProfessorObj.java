package com.neil.object;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROFESSOR")
public class ProfessorObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1900552902583857902L;

	@Id
    @Column(name="username")
	private String username;
	
	@Column(name = "name")
	private String name;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
