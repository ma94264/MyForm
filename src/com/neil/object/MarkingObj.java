package com.neil.object;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MARKING")
public class MarkingObj {
	
	@Id
    @Column(name="grade")
	private int grade;
	
	@Column(name = "marks")
	private int marks;
	@Column(name = "definition")
	private String definition;
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	} 
	
	
	
	
}
