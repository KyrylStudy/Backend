package com.masterproject.AUTOtech.agil.mapper;

import com.masterproject.AUTOtech.agil.dto.EcuHardwareDto;
import com.masterproject.AUTOtech.agil.entity.EcuHardware;

public class EcuHardwareMapper {
	
	public static EcuHardware mapToEcuHardware(EcuHardwareDto ecuHardwareDto) {
		EcuHardware ecuHardware = new EcuHardware();
		ecuHardware.setId(ecuHardwareDto.getId());
		ecuHardware.setName(ecuHardwareDto.getName());
		ecuHardware.setValue(ecuHardwareDto.getValue());		
		
		return ecuHardware;
	}
	
	public static EcuHardwareDto mapToEcuHardwareDto(EcuHardware ecuHardware) {
		EcuHardwareDto ecuHardwareDto = new EcuHardwareDto();
		ecuHardwareDto.setId(ecuHardware.getId());
		ecuHardwareDto.setName(ecuHardware.getName());
		ecuHardwareDto.setValue(ecuHardware.getValue());
			
		return ecuHardwareDto;
	}

}
