package com.masterproject.AUTOtech.agil.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masterproject.AUTOtech.agil.dto.ECUdto;
import com.masterproject.AUTOtech.agil.dto.EcuSoftwareDto;
import com.masterproject.AUTOtech.agil.entity.Architecture;
import com.masterproject.AUTOtech.agil.entity.ECU;
import com.masterproject.AUTOtech.agil.entity.EcuSoftware;
import com.masterproject.AUTOtech.agil.exceprions.ArchitectureNotFound;
import com.masterproject.AUTOtech.agil.exceprions.EcuNotFound;
import com.masterproject.AUTOtech.agil.mapper.ECUMapper;
import com.masterproject.AUTOtech.agil.mapper.EcuSoftwareMapper;
import com.masterproject.AUTOtech.agil.repository.ArchitectureRepository;
import com.masterproject.AUTOtech.agil.repository.ECURepository;
import com.masterproject.AUTOtech.agil.service.ECUService;

@Service
public class ECUserviceImpl implements ECUService{
	
	private ECURepository ecuRepository;
	private ArchitectureRepository architectureRepository;
	
	
	@Autowired
	public ECUserviceImpl(ECURepository ecuRepository, ArchitectureRepository architectureRepository) {
		super();
		this.ecuRepository = ecuRepository;
		this.architectureRepository = architectureRepository;
	}


	@Override
	public ECUdto createECU(Long architecture_id, ECUdto ecudto) {
		ECU ecu = ECUMapper.mapToECU(ecudto);

        Architecture architecture = architectureRepository.findById(architecture_id).orElseThrow(() -> new ArchitectureNotFound("Architecture with associated ECU could not be found!"));
        
        ecu.setArchitecture(architecture);

        ECU newEcu = ecuRepository.save(ecu);

        return ECUMapper.mapToECUdto(newEcu);
		
	}


	@Override
	public ECUdto getECUbyId(Long id) {
		ECU ecu = ecuRepository
				.findById(id)
				.orElseThrow(()->new EcuNotFound("ECU could not be found!"));
		return ECUMapper.mapToECUdto(ecu);
	}



	@Override
	public List<ECUdto> getAllEcusByArchitectureId(Long architecture_id) {
		//ECU ecu228 = ecuRepository.findById((long) 654654654).orElseThrow(()-> new EcuNotFound("ECU can not be found by ID!"));
		List<ECU> ecus = ecuRepository.findByArchitectureId(architecture_id);
		return ecus.stream().map(ecu -> ECUMapper.mapToECUdto(ecu)).collect(Collectors.toList());

	}



	@Override
	public ECUdto updateEcu(ECUdto ecuDto, Long id) {
		ECU ecu = ecuRepository
				.findById(id)
				.orElseThrow(()->new EcuNotFound("ECU could not be updated!"));
		
		ecu.setLabel(ecuDto.getLabel());
		ecu.setType(ecuDto.getType());
		ecu.setDescription(ecuDto.getDescription());
		ecu.setPositionX(ecuDto.getPositionX());
		ecu.setPositionY(ecuDto.getPositionY());
		ecu.setConnectedTo(ecuDto.getConnectedTo());
		
		ECU updatedEcu = ecuRepository.save(ecu); 	
		return ECUMapper.mapToECUdto(updatedEcu);
	}



	@Override
	public void deleteEcuId(Long id) {
		ECU ecu = ecuRepository
				.findById(id)
				.orElseThrow(()->new EcuNotFound("ECU could not be deleted!"));
		ecuRepository.delete(ecu);
	}




	

}
