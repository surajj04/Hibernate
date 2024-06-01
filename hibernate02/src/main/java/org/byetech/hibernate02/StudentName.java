package org.byetech.hibernate02;

import javax.persistence.Embeddable;

@Embeddable // if you don't want to create new table then you can use the @Embeddable
public class StudentName {
	
	private String fname;
	private String lname;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return "StudentName [fname=" + fname + ", lname=" + lname + "]";
	}
	
	
	
	
	
	

}
