package br.com.cvc.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Quarto implements Serializable{
	
	private Integer roomID;
	private String categoryName;
	private BigDecimal priceAdult;
	private BigDecimal priceChild;
	private BigDecimal totalPrice;
	
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public BigDecimal getPriceAdult() {
		return priceAdult;
	}
	public void setPriceAdult(BigDecimal priceAdult) {
		this.priceAdult = priceAdult;
	}
	public BigDecimal getPriceChild() {
		return priceChild;
	}
	public void setPriceChild(BigDecimal priceChild) {
		this.priceChild = priceChild;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
