package com.masterproject.AUTOtech.agil.exceprions;

public class EcuNotFound extends RuntimeException{
	
	private static final long serialVerisionUID = 1;

    public EcuNotFound(String message) {
        super(message);
    }
}
