package com.dfyx.crm.entity;

import lombok.Getter;
import lombok.Setter;

//商品表
@Getter
@Setter
public class Commodity {

	private int id;
	private String name;//商品名
	private String brand;//商品品牌
	private String category;//商品类别
	private float price;//单价
	private float discount;//折扣
	private float points;//积分
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}*/
	
	
	
}
