package br.com.cvc.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class HotelVO implements Serializable{

	private Long id;
	private String cityName;
	private List<QuartoVO> rooms;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<QuartoVO> getRooms() {
		return rooms;
	}
	public void setRooms(List<QuartoVO> rooms) {
		this.rooms = rooms;
	}
}
