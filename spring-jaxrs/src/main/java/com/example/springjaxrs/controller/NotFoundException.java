package com.example.springjaxrs.controller;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

}
