package com.gocamp.shop.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	
	private int productId;
	
	
	private String productBrand;
	
	
	private String productName;
	
	
	private int productPrice;
	
	
	private int categortId;
	
	
	private String productSpec;
	
	
	private int productStock;
	
	
	private String productWarring;
	
	
	private String productfeature;

	private int click;
	
	private String picpath;

	
	public Product() {
		
	}

	


	public Product(String productBrand, String productName, int productPrice, int categortId, String productSpec,
			int productStock, String productWarring, String productfeature, String picpath, int click) {
		super();
		this.productBrand = productBrand;
		this.productName = productName;
		this.productPrice = productPrice;
		this.categortId = categortId;
		this.productSpec = productSpec;
		this.productStock = productStock;
		this.productWarring = productWarring;
		this.productfeature = productfeature;
		this.picpath = picpath;
		this.click = click;
	}



	@Column(name = "IMGPATH")
	public String getPicpath() {
		return picpath;
	}




	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}




	@Id
	@Column(name = "PID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getProductId() {
		return productId;
	}

	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Column(name = "PBRAND")
	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	@Column(name = "PNAME")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Column(name = "PRICE")
	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Column(name = "PCATEGORYID")
	public int getCategortId() {
		return categortId;
	}

	public void setCategortId(int categortId) {
		this.categortId = categortId;
	}
	@Column(name = "PSPEC")
	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}
	@Column(name = "PSTOCK")
	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	@Column(name = "PWARRING")
	public String getProductWarring() {
		return productWarring;
	}

	public void setProductWarring(String productWarring) {
		this.productWarring = productWarring;
	}

	@Column(name = "PFEATURE")
	public String getProductfeature() {
		return productfeature;
	}

	public void setProductfeature(String productfeature) {
		this.productfeature = productfeature;
	}

	@Column(name = "PCLICKNUM")
	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}
	

	

}
