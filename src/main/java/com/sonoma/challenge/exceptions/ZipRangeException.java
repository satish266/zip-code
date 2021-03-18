package com.sonoma.challenge.exceptions;

public class ZipRangeException extends Exception {
	String msg;
	String details;

	private static final long serialVersionUID = 1L;

	public ZipRangeException() {
		super();
	}

	public ZipRangeException(String msg) {
		this.msg = msg;
	}

	public ZipRangeException(String msg, String details) {
		this.msg = msg;
		this.details = details;
	}
}
