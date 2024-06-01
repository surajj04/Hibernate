package org.byetech.hibernate01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity(name="student")
@Entity
@Table(name="student_table")
public class Student {
	@Id
	private int student_id;
	@Column(name="student_name")
	private String name;
	private double marks;
	@Transient // if you don't want to store that value you can use @Transient
	private int pin;
	
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", marks=" + marks + ", pin=" + pin + "]";
	}
	
	
	
	
	
	

}
