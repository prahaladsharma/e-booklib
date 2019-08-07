package com.bookstoreWeb.model;

import java.util.List;

public class LoginModelResponse {
	
	private Boolean result;
    private String message;
    private List<SignUpModel> data;
	
    public LoginModelResponse() {}
    
    public LoginModelResponse(Boolean result, String message, List<SignUpModel> data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}

	/**
	 * @return the result
	 */
	public Boolean getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Boolean result) {
		this.result = result;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public List<SignUpModel> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<SignUpModel> data) {
		this.data = data;
	}
}
