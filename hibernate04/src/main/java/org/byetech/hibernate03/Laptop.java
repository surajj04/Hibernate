package org.byetech.hibernate03;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {

	@Id
	private int lid;
	private String lname;
	@ManyToMany
	private List<Student> students = new ArrayList<Student>();

	public List<Student> getStudent() {
		return students;
	}

	public void setStudent(List<Student> student) {
		this.students = student;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}

}
