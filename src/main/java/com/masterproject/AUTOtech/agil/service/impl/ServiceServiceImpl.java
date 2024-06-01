package com.masterproject.AUTOtech.agil.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.masterproject.AUTOtech.agil.dto.ECUdto;
import com.masterproject.AUTOtech.agil.dto.ServiceDto;
import com.masterproject.AUTOtech.agil.entity.ECU;
import com.masterproject.AUTOtech.agil.entity.ServiceEntity;
import com.masterproject.AUTOtech.agil.exceprions.EcuNotFound;
import com.masterproject.AUTOtech.agil.exceprions.ServiceNotFound;
import com.masterproject.AUTOtech.agil.mapper.ECUMapper;
import com.masterproject.AUTOtech.agil.mapper.ServiceMapper;
import com.masterproject.AUTOtech.agil.repository.ECURepository;
import com.masterproject.AUTOtech.agil.repository.ServiceRepository;
import com.masterproject.AUTOtech.agil.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService{

	private ServiceRepository serviceRepository;
	private ECURepository ecuRepository;
	
	
	@Autowired
	public ServiceServiceImpl(ServiceRepository serviceRepository, ECURepository ecuRepository) {
		super();
		this.ecuRepository = ecuRepository;
		this.serviceRepository = serviceRepository;
	}


	@Override
	public ServiceDto createService(Long ecu_id, ServiceDto serviceDto) {
		ServiceEntity serviceEntity = ServiceMapper.mapToService(serviceDto);

        ECU ecu = ecuRepository.findById(ecu_id).orElseThrow(() -> new EcuNotFound("ECU with associated Service could not be found!"));
        
        serviceEntity.setEcu(ecu);

        ServiceEntity newServiceEntity = serviceRepository.save(serviceEntity);

        return ServiceMapper.mapToServiceDto(newServiceEntity);
	}


	@Override
	public List<ServiceDto> getAllServicesByEcuId(Long ecu_id) {
			List<ServiceEntity> serviceEntities = serviceRepository.findByEcuId(ecu_id);
			return serviceEntities.stream().map(service -> ServiceMapper.mapToServiceDto(service)).collect(Collectors.toList());
	}


	@Override
	public ServiceDto updateService(ServiceDto serviceDto, Long id) {
		ServiceEntity serviceEntity = serviceRepository
				.findById(id)
				.orElseThrow(()->new ServiceNotFound("Service could not be updated!"));
		
		serviceEntity.setName(serviceDto.getName());
		serviceEntity.setType(serviceDto.getType());
		serviceEntity.setDescription(serviceDto.getDescription());
		serviceEntity.setPositionX(serviceDto.getPositionX());
		serviceEntity.setPositionY(serviceDto.getPositionY());
		serviceEntity.setConnectedTo(serviceDto.getConnectedTo());
		//serviceEntity.setParent_ecu_id(serviceDto.getParent_ecu_id());
		
		ServiceEntity updatedServiceEntity = serviceRepository.save(serviceEntity); 	
		return ServiceMapper.mapToServiceDto(updatedServiceEntity);
	}


	@Override
	public void deleteServiceId(Long id) {
		ServiceEntity serviceEntity = serviceRepository
				.findById(id)
				.orElseThrow(()->new EcuNotFound("Service could not be deleted!"));
		serviceRepository.delete(serviceEntity);
		
	}
}
