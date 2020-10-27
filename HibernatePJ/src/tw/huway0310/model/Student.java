package tw.huway0310.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@Column(name = "SID") 
	private String sid;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "LAPTOPID")
	private Laptop aLaptop;
	
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Laptop getaLaptop() {
		return aLaptop;
	}
	public void setaLaptop(Laptop aLaptop) {
		this.aLaptop = aLaptop;
	}

}
