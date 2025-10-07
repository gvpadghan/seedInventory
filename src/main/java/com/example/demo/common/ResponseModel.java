package com.example.demo.common;


public class ResponseModel {
	private String statusCode; // e.g., 
    private String message;    // e.g., "Success", "Email not found"
    private String status;     // e.g., "SUCCESS", "FAILURE"
    private Object data;       // response data (can be null)

	public ResponseModel() {

	}

	public ResponseModel(int status, String message) {
		this.status = status + "";
		this.message = message;
	}

	public ResponseModel(String status, String statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
		this.status = status;
	}
	
	public ResponseModel(String status, String statusCode, String message, Object data) {
		this.statusCode = statusCode;
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public ResponseModel(String status, String statusCode, Object data) {
		this.statusCode = statusCode;
		this.status = status;
		this.data = data;
	}

	public ResponseModel(int status, String message, Object ent, String statusCode) {
		this.status = status + "";
		this.message = message;
		this.data = ent;
		this.statusCode = statusCode;
	}

	public ResponseModel(int status, String message, Object ent) {
		this.status = status + "";
		this.message = message;
		this.data = ent;

	}

	public static ResponseModel ok() {
		return new ResponseModel(200, "SUCCESS");
	}

	public static ResponseModel ok(Object data) {
		return new ResponseModel(200, "SUCCESS", data, String.valueOf(200));
	}

	public static ResponseModel ok(String message, Object ent) {
		return new ResponseModel(200, message, ent);
	}

	public static ResponseModel error(String message) {
		return new ResponseModel(500, message);
	}

	public static ResponseModel error(int staus, String message) {
		return new ResponseModel(staus, message);
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
