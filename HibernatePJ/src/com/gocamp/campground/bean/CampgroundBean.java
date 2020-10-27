package com.gocamp.campground.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Campinf")
public class CampgroundBean {
	public CampgroundBean(){
	}
	
	private int id;
	private String name;
	private String city;
	private String adress;
	private String tel;
	private int oprice;
	private int wprice;
	private int tentnum;
	private String elevation;
	private String feature;
	private String facility;
	private String pet;
	private String service;
	private String parking;
	
	public CampgroundBean (int cId,String cName,String cCity,String cAdress,
			String cTel,int cOprice,int cWprice,int cTentnum,String cElevation,String cFeature,String cFacility,
			String cPet,String cService,String cParking){
		
		this.id=cId;
		this.name=cName;
		this.city=cCity;
		this.adress=cAdress;
		this.tel=cTel;
		this.oprice=cOprice;
		this.wprice=cWprice;
		this.tentnum=cTentnum;
		this.elevation=cElevation;
		this.feature=cFeature;
		this.facility=cFacility;
		this.pet=cPet;
		this.service=cService;
		this.parking=cParking;
	}
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "CITY")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}@Column(name = "ADRESS")
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Column(name = "TEL")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name = "OPRICE")
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}
	@Column(name = "WPRICE")
	public int getWprice() {
		return wprice;
	}
	public void setWprice(int wprice) {
		this.wprice = wprice;
	}
	@Column(name = "TENTNUM")
	public int getTentnum() {
		return tentnum;
	}
	public void setTentnum(int tentnum) {
		this.tentnum = tentnum;
	}
	@Column(name = "ELEVATION")
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	@Column(name = "FEATURE")
	public String getFeature() {
		return feature;
	}
	
	public void setFeature(String feature) {
		this.feature = feature;
	}
	@Column(name = "FACILITY")
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	@Column(name = "PET")
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet = pet;
	}
	@Column(name = "SERVICE")
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	@Column(name = "PARKING")
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}


}
