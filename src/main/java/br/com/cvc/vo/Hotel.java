package br.com.cvc.vo;

import java.util.List;

public class Hotel {

	private Integer id;
	private String nome;
	private Integer cityCode;
	private String cityName;
	private List<Quarto> quartos;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Quarto> getQuartos() {
		return quartos;
	}
	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}
}
