package com.masterproject.AUTOtech.agil.mapper;

import com.masterproject.AUTOtech.agil.dto.BusPropertyDto;
import com.masterproject.AUTOtech.agil.entity.BusProperty;

public class BusPropertyMapper {
	
	public static BusProperty mapToBusProperty(BusPropertyDto busPropertyDto) {
		BusProperty busProperty = new BusProperty();
		busProperty.setId(busPropertyDto.getId());
		busProperty.setName(busPropertyDto.getName());
		busProperty.setValue(busPropertyDto.getValue());		
		
		return busProperty;
	}
	
	public static BusPropertyDto mapToBusPropertyDto(BusProperty busProperty) {
		BusPropertyDto busPropertyDto = new BusPropertyDto();
		busPropertyDto.setId(busProperty.getId());
		busPropertyDto.setName(busProperty.getName());
		busPropertyDto.setValue(busProperty.getValue());
			
		return busPropertyDto;
	}

}

