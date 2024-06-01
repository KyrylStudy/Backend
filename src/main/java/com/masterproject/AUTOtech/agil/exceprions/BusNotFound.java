package com.masterproject.AUTOtech.agil.exceprions;

public class BusNotFound extends RuntimeException{
	
	private static final long serialVerisionUID = 1;

    public BusNotFound(String message) {
        super(message);
    }

}
