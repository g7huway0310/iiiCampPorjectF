package com.gocamp.recipe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {

	int reid;
	String rename;
	String brief;
	String image;
	String ingredient;
	String tip1;
	String tip2;
	String tip3;
	String tip4;
	String tip5;
	String tip6;
	String note;
	private Double price;
	private Double discount;
	private int stock;
	int people;
	Integer time;
	private String discountStr;

	public Recipe() {
    }

	public Recipe(String rename, String brief, String image, String ingredient,int people, int time,double price, double discount) {
    	this.reid = reid;
    	this.rename = rename;
    	this.brief = brief;
    	this.image = image;
    	this.ingredient = ingredient;
    	this.people = people;
    	this.time = time;
    	this.price = price;
    	this.discount = discount;
    	this.stock = 0;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipeBean [reid=");
		builder.append(reid);
		builder.append(", rename=");
		builder.append(rename);
		builder.append(", brief=");
		builder.append(brief);
		builder.append(", image=");
		builder.append(image);
		builder.append(", people=");
		builder.append(people);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}

public Recipe(String rename,String brief,String image,String ingredient,String tip1,String tip2,String tip3,String tip4,String tip5,
		String tip6,String note,int people,int time, double price, double discount,Integer Stock) 
{
	this.reid = reid;
	this.rename = rename;
	this.brief = brief;
	this.image = image;
	this.ingredient = ingredient;
	this.tip1 = tip1;
	this.tip2 = tip2;
	this.tip3 = tip3;
	this.tip4 = tip4;
	this.tip5 = tip5;
	this.tip6 = tip6;
	this.note = note;
	this.people = people;
	this.time = time;	
	this.price = price;
	this.discount = discount;
	this.stock = stock;
    }

public Recipe(int reid, String rename, String brief, String image, String ingredient, String tip1, String tip2,
		String tip3, String tip4, String tip5, String tip6, String note, int people, Integer time) {
	super();
	this.reid = reid;
	this.rename = rename;
	this.brief = brief;
	this.image = image;
	this.ingredient = ingredient;
	this.tip1 = tip1;
	this.tip2 = tip2;
	this.tip3 = tip3;
	this.tip4 = tip4;
	this.tip5 = tip5;
	this.tip6 = tip6;
	this.note = note;
	this.people = people;
	this.time = time;
}

//	private String priceStr = null;
//
//	public String getPriceStr() {
//		return priceStr;
//	}
//
//	public void setPriceStr(String priceStr) {
//		this.priceStr = priceStr;
//	}

	@Column(name = "PRICE")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
		
	}
	
	@Column(name = "Discount")
	public Double getDiscount() {
		return discount;
	}

    public void setDiscount(Double discount) {
	this.discount = discount;
	if (discount == 1) {
		discountStr = "";
	} else {
		int dnt = (int)(discount * 100);
		if (dnt % 10 == 0) {
			discountStr = (dnt / 10) +"折";
		} else {
			discountStr = " "  + dnt+"折"; 
		} 
		
	}
}
    @Column(name = "STOCK")
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

public Recipe(int reid) {
	this.reid = reid;
}
    @Id @Column(name = "REID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getReid() {
		return reid;
	}

	public void setReid(int reid) {
		this.reid = reid;
	}
    
	@Column(name = "RNAME")
	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}
	@Column(name = "BRIEF")
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Column(name = "IMAGE")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	@Column(name = "TIP1")
	public String getTip1() {
		return tip1;
	}

	public void setTip1(String tip1) {
		this.tip1 = tip1;
	}
	@Column(name = "TIP2")
	public String getTip2() {
		return tip2;
	}

	public void setTip2(String tip2) {
		this.tip2 = tip2;
	}
	@Column(name = "TIP3")
	public String getTip3() {
		return tip3;
	}

	public void setTip3(String tip3) {
		this.tip3 = tip3;
	}

	@Column(name = "TIP4")
	public String getTip4() {
		return tip4;
	}

	public void setTip4(String tip4) {
		this.tip4 = tip4;
	}
	@Column(name = "TIP5")
	public String getTip5() {
		return tip5;
	}

	public void setTip5(String tip5) {
		this.tip5 = tip5;
	}

	@Column(name = "TIP6")
	public String getTip6() {
		return tip6;
	}

	public void setTip6(String tip6) {
		this.tip6 = tip6;
	}

	@Column(name = "Note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "PEOPLE")
	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	@Column(name = "TIME1")
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Column(name = "INGREDIENT")
	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

}