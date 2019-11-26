package br.com.cvc.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class HotelBean implements Serializable{

	private Long id;
	private String name;
	private Long cityCode;
	private String cityName;
	private List<QuartoBean> rooms;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCityCode() {
		return cityCode;
	}
	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<QuartoBean> getRooms() {
		return rooms;
	}
	public void setRooms(List<QuartoBean> rooms) {
		this.rooms = rooms;
	}
}
