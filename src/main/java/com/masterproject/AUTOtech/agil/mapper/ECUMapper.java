package com.masterproject.AUTOtech.agil.mapper;

import com.masterproject.AUTOtech.agil.dto.ECUdto;
import com.masterproject.AUTOtech.agil.entity.ECU;

public class ECUMapper {
	
	public static ECU mapToECU(ECUdto ecuDto) {
		ECU ecu = new ECU();
			//ecuDto.getId(),
			ecu.setLabel(ecuDto.getLabel());
			ecu.setType(ecuDto.getType());
			ecu.setDescription(ecuDto.getDescription());
			ecu.setPositionX(ecuDto.getPositionX());
			ecu.setPositionY(ecuDto.getPositionY());
			ecu.setConnectedTo(ecuDto.getConnectedTo());
			
		
		return ecu;
	}
	
	public static ECUdto mapToECUdto(ECU ecu) {
		ECUdto ecuDto = new ECUdto();
			ecuDto.setId(ecu.getId());
			ecuDto.setLabel(ecu.getLabel());
			ecuDto.setType(ecu.getType());
			ecuDto.setDescription(ecu.getDescription());
			ecuDto.setPositionX(ecu.getPositionX());
			ecuDto.setPositionY(ecu.getPositionY());
			ecuDto.setConnectedTo(ecu.getConnectedTo());
			
		
			
		return ecuDto;
	}

}
