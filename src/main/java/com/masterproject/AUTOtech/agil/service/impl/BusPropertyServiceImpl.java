package com.masterproject.AUTOtech.agil.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.masterproject.AUTOtech.agil.dto.BusPropertyDto;
import com.masterproject.AUTOtech.agil.entity.Bus;
import com.masterproject.AUTOtech.agil.entity.BusProperty;
import com.masterproject.AUTOtech.agil.exceprions.BusNotFound;
import com.masterproject.AUTOtech.agil.exceprions.BusPropertyNotFound;
import com.masterproject.AUTOtech.agil.mapper.BusPropertyMapper;
import com.masterproject.AUTOtech.agil.repository.BusPropertyRepository;
import com.masterproject.AUTOtech.agil.repository.BusRepository;
import com.masterproject.AUTOtech.agil.service.BusPropertyService;

@Service
public class BusPropertyServiceImpl implements BusPropertyService {

    private BusRepository busRepository;
    private BusPropertyRepository busPropertyRepository;

    public BusPropertyServiceImpl(BusPropertyRepository busPropertyRepository, BusRepository busRepository) {
        this.busPropertyRepository = busPropertyRepository;
        this.busRepository = busRepository;
    }

    @Override
    public BusPropertyDto createBusProperty(Long bus_id, BusPropertyDto busPropertyDto) {
    	BusProperty busProperty = BusPropertyMapper.mapToBusProperty(busPropertyDto);

        Bus bus = busRepository.findById(bus_id).orElseThrow(() -> new BusNotFound("Bus with associated Bus Property could not be found!"));
        
        busProperty.setBus(bus);

        BusProperty newBusProperty = busPropertyRepository.save(busProperty);

        return BusPropertyMapper.mapToBusPropertyDto(newBusProperty);
    }

   /* @Override
    public EcuSoftwareDto getEcuSoftwareDtoById(Long id) {
        EcuSoftware ecuSoftware = ecuSoftwareRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("EcuSoftware does not exist"));
        return EcuSoftwareMapper.mapToEcuSoftwareDto(ecuSoftware);
    }*/

	@Override
	public List<BusPropertyDto> getAllBusPropertyByBusId(Long bus_id) {
		List<BusProperty> allBusProperty = busPropertyRepository.findByBusId(bus_id);
		return allBusProperty.stream().map((busProperty) -> BusPropertyMapper.mapToBusPropertyDto(busProperty)).collect(Collectors.toList());

	}

	@Override
	public BusPropertyDto updateBusProperty(BusPropertyDto busPropertyDto, Long id) {
		BusProperty busProperty = busPropertyRepository
				.findById(id)
				.orElseThrow(()->new BusPropertyNotFound("Bus Property could not be updated!"));
		
		busProperty.setName(busPropertyDto.getName());
		busProperty.setValue(busPropertyDto.getValue());
	
		
		BusProperty updatedBusProperty = busPropertyRepository.save(busProperty); 	
		return BusPropertyMapper.mapToBusPropertyDto(updatedBusProperty);
	}

	@Override
	public void deleteBusPropertyId(Long id) {
		BusProperty busProperty = busPropertyRepository
				.findById(id)
				.orElseThrow(()->new BusPropertyNotFound("Bus Property could not be deleted!"));
		busPropertyRepository.delete(busProperty);
	}


}
