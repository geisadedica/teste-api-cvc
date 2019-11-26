package br.com.cvc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class QuartoBean implements Serializable{
	
	private Long roomID;
	private String categoryName;
	private LinkedHashMap<String, BigDecimal> price;
	
	public Long getRoomID() {
		return roomID;
	}
	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public LinkedHashMap<String, BigDecimal> getPrice() {
		return price;
	}
	public void setPrice(LinkedHashMap<String, BigDecimal> price) {
		this.price = price;
	}
}