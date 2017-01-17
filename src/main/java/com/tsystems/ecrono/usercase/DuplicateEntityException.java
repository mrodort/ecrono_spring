package com.tsystems.ecrono.usercase;

public class DuplicateEntityException extends Exception {

    private static final long serialVersionUID = 1L;

    public DuplicateEntityException(String message) {
	super(message);
    }

}
