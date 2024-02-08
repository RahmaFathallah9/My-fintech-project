package com.example.demo.service.exception;

public class NotFoundBalanceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundBalanceException (String message) {
		super(message);
		}

}
