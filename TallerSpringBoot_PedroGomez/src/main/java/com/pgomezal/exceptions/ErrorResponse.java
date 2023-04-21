package com.pgomezal.exceptions;

public class ErrorResponse {
	private String type;
	private String title;
	private int status;
	private String detail;

	public ErrorResponse(String type, String title, int status, String detail) {
		this.type = type;
		this.title = title;
		this.status = status;
		this.detail = detail;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getDetail() {
		return detail;
	}

}
