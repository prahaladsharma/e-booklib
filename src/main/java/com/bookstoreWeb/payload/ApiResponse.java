package com.bookstoreWeb.payload;

public class ApiResponse {

	private String message;
	private Boolean success;
	
	/**
	 * @param message
	 * @param success
	 */
	public ApiResponse(String message, Boolean success) {
		super();
		this.message = message;
		this.success = success;
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
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
}
