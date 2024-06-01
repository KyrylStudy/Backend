package com.masterproject.AUTOtech.agil.exceprions;

public class EcuHardwareNotFound extends RuntimeException{
	
	private static final long serialVerisionUID = 1;

    public EcuHardwareNotFound(String message) {
        super(message);
    }
}

