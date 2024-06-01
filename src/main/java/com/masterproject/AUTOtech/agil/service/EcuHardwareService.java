package com.masterproject.AUTOtech.agil.service;


import java.util.List;

import com.masterproject.AUTOtech.agil.dto.EcuHardwareDto;


public interface EcuHardwareService {
	
	EcuHardwareDto createEcuHardware(Long ecu_id, EcuHardwareDto ecuHardwareDto);
	
	List<EcuHardwareDto> getAllEcuHardwareByEcuId(Long ecu_id);
	
	EcuHardwareDto updateEcuHardware(EcuHardwareDto ecuHardwareDto, Long id);
	
	void deleteEcuHardwareId(Long id);

}
