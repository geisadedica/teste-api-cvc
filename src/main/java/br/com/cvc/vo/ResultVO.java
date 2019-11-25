package br.com.cvc.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultVO implements Serializable{
	
	@JsonProperty(value = "success")
	private boolean success;
	
	@JsonProperty(value = "error")
	private String error;
	
	@JsonProperty(value = "data")
	private Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
