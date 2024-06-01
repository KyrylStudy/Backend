package com.masterproject.AUTOtech.agil.mapper;

import com.masterproject.AUTOtech.agil.dto.BusDto;
import com.masterproject.AUTOtech.agil.entity.Bus;

public class BusMapper {
	
	public static Bus mapToBus(BusDto busDto) {
		Bus bus = new Bus();

		bus.setName(busDto.getName());
		bus.setType(busDto.getType());
		bus.setDescription(busDto.getDescription());
		bus.setPositionFromX(busDto.getPositionFromX());
		bus.setPositionFromY(busDto.getPositionFromY());
		bus.setPositionToX(busDto.getPositionToX());
		bus.setPositionToY(busDto.getPositionToY());
		bus.setConnectedFrom(busDto.getConnectedFrom());
		bus.setConnectedTo(busDto.getConnectedTo());
		bus.setTwoWayConnection(busDto.getTwoWayConnection());

		
		return bus;
	}
	
	public static BusDto mapToBusDto(Bus bus) {
		BusDto busDto = new BusDto();
		
		busDto.setId(bus.getId());
		busDto.setName(bus.getName());
		busDto.setType(bus.getType());
		busDto.setDescription(bus.getDescription());
		busDto.setPositionFromX(bus.getPositionFromX());
		busDto.setPositionFromY(bus.getPositionFromY());
		busDto.setPositionToX(bus.getPositionToX());
		busDto.setPositionToY(bus.getPositionToY());
		busDto.setConnectedFrom(bus.getConnectedFrom());
		busDto.setConnectedTo(bus.getConnectedTo());
		busDto.setTwoWayConnection(bus.getTwoWayConnection());

			
		return busDto;
	}

}

