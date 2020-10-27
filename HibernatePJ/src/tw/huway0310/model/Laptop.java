package tw.huway0310.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Laptop")
public class Laptop {
	@Id
	@Column(name = "LAPTOPID")
	private String laptopID;
	
	@Column(name = "LAPTOPNAME")
	private String laptopname;
	
	@OneToOne
	@JoinColumn(name = "SID")
	private Student aStudent;
	
	public String getLaptopID() {
		return laptopID;
	}
	public void setLaptopID(String laptopID) {
		this.laptopID = laptopID;
	}
	public String getLaptopname() {
		return laptopname;
	}
	public void setLaptopname(String laptopname) {
		this.laptopname = laptopname;
	}
	public Student getaStudent() {
		return aStudent;
	}
	public void setaStudent(Student aStudent) {
		this.aStudent = aStudent;
	}
}
