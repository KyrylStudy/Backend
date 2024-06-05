package com.masterproject.AUTOtech.agil.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.masterproject.AUTOtech.agil.dto.ArchitectureDto;
import com.masterproject.AUTOtech.agil.dto.BusDto;
import com.masterproject.AUTOtech.agil.dto.HardwareDto;
import com.masterproject.AUTOtech.agil.entity.Architecture;
import com.masterproject.AUTOtech.agil.entity.Bus;
import com.masterproject.AUTOtech.agil.entity.Hardware;
import com.masterproject.AUTOtech.agil.exceprions.ArchitectureNotFound;
import com.masterproject.AUTOtech.agil.exceprions.BusNotFound;
import com.masterproject.AUTOtech.agil.exceprions.HardwareNotFound;
import com.masterproject.AUTOtech.agil.mapper.ArchitectureMapper;
import com.masterproject.AUTOtech.agil.mapper.BusMapper;
import com.masterproject.AUTOtech.agil.mapper.HardwareMapper;
import com.masterproject.AUTOtech.agil.repository.ArchitectureRepository;
import com.masterproject.AUTOtech.agil.repository.BusRepository;
import com.masterproject.AUTOtech.agil.service.BusService;

@Service
public class BusServiceImpl implements BusService{
	
	private BusRepository busRepository;
	private ArchitectureRepository architectureRepository;

	public BusServiceImpl(BusRepository busRepository, ArchitectureRepository architectureRepository) {
		super();
		this.busRepository = busRepository;
		this.architectureRepository = architectureRepository;
	}

	@Override
	public BusDto createBus(Long architecture_id, BusDto busDto) {
		Bus bus = BusMapper.mapToBus(busDto);
		Architecture architecture = architectureRepository.findById(architecture_id).orElseThrow(() -> new ArchitectureNotFound("Architecture with associated ECU could not be found!"));
		bus.setArchitecture(architecture);
		Bus savedBus = busRepository.save(bus);
		return BusMapper.mapToBusDto(savedBus);
	}

	@Override
	public List<BusDto> getAllBuses(Long architecture_id) {
		List<Bus> buses = busRepository.findByArchitectureId(architecture_id);
		return buses.stream().map(bus -> BusMapper.mapToBusDto(bus)).collect(Collectors.toList());
	}

	@Override
	public BusDto updateBus(BusDto busDto, Long id) {
		Bus bus = busRepository
				.findById(id)
				.orElseThrow(()->new BusNotFound("Architecture could not be updated!"));
		
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
		
		Bus updatedBus = busRepository.save(bus); 	
		return BusMapper.mapToBusDto(updatedBus);
	}

	@Override
	public void deleteBusId(Long id) {
		Bus bus = busRepository
				.findById(id)
				.orElseThrow(()->new BusNotFound("Bus could not be deleted!"));
		busRepository.delete(bus);
		
	}

}
