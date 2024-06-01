package com.masterproject.AUTOtech.agil.service;

import java.util.List;

import com.masterproject.AUTOtech.agil.dto.BusPropertyDto;

public interface BusPropertyService {
	
	BusPropertyDto createBusProperty(Long bus_id, BusPropertyDto busPropertyDto);
	
	//EcuSoftwareDto getEcuSoftwareDtoById(Long id);
	
	List<BusPropertyDto> getAllBusPropertyByBusId(Long bus_id);
	
	BusPropertyDto updateBusProperty(BusPropertyDto busPropertyDto, Long id);
	
	void deleteBusPropertyId(Long id);

}

