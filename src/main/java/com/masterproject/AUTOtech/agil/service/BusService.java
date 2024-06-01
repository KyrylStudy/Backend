package com.masterproject.AUTOtech.agil.service;

import java.util.List;

import com.masterproject.AUTOtech.agil.dto.BusDto;

public interface BusService {
	
	BusDto createBus(Long architecture_id, BusDto busDto);
	
	List<BusDto> getAllBuses(Long architecture_id);
	
	//ECUdto getECUbyId(Long id);---------
	
	BusDto updateBus(BusDto busDto, Long id);
	
	void deleteBusId(Long id);

}
