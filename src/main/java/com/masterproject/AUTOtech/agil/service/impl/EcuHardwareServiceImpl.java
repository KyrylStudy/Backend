package com.masterproject.AUTOtech.agil.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.masterproject.AUTOtech.agil.dto.EcuHardwareDto;
import com.masterproject.AUTOtech.agil.dto.EcuSoftwareDto;
import com.masterproject.AUTOtech.agil.entity.Hardware;
import com.masterproject.AUTOtech.agil.entity.EcuHardware;
import com.masterproject.AUTOtech.agil.entity.EcuSoftware;
import com.masterproject.AUTOtech.agil.exceprions.EcuHardwareNotFound;
import com.masterproject.AUTOtech.agil.exceprions.HardwareNotFound;
import com.masterproject.AUTOtech.agil.exceprions.EcuSoftwareNotFound;
import com.masterproject.AUTOtech.agil.mapper.EcuHardwareMapper;
import com.masterproject.AUTOtech.agil.mapper.EcuSoftwareMapper;
import com.masterproject.AUTOtech.agil.repository.HardwareRepository;
import com.masterproject.AUTOtech.agil.repository.EcuHardwareRepository;
import com.masterproject.AUTOtech.agil.service.EcuHardwareService;

@Service
public class EcuHardwareServiceImpl implements EcuHardwareService{
	
    private EcuHardwareRepository ecuHardwareRepository;
    private HardwareRepository hardwareRepository;

    public EcuHardwareServiceImpl(EcuHardwareRepository ecuHardwareRepository, HardwareRepository hardwareRepository) {
        this.ecuHardwareRepository = ecuHardwareRepository;
        this.hardwareRepository = hardwareRepository;
    }

	@Override
	public EcuHardwareDto createEcuHardware(Long ecu_id, EcuHardwareDto ecuHardwareDto) {
		EcuHardware ecuHardware = EcuHardwareMapper.mapToEcuHardware(ecuHardwareDto);

        Hardware hardware = hardwareRepository.findById(ecu_id).orElseThrow(() -> new HardwareNotFound("ECU with associated hardware could not be found!"));
        
        ecuHardware.setHardware(hardware);

        EcuHardware newEcuHardware = ecuHardwareRepository.save(ecuHardware);

        return EcuHardwareMapper.mapToEcuHardwareDto(newEcuHardware);
	}

	@Override
	public List<EcuHardwareDto> getAllEcuHardwareByEcuId(Long ecu_id) {
		List<EcuHardware> allHardware = ecuHardwareRepository.findByHardwareId(ecu_id);
		return allHardware.stream().map((hardware) -> EcuHardwareMapper.mapToEcuHardwareDto(hardware)).collect(Collectors.toList());
	}

	@Override
	public EcuHardwareDto updateEcuHardware(EcuHardwareDto ecuHardwareDto, Long id) {
		EcuHardware ecuHardware = ecuHardwareRepository
				.findById(id)
				.orElseThrow(()->new EcuHardwareNotFound("EcuHardware could not be updated!"));
		
		ecuHardware.setName(ecuHardwareDto.getName());
		ecuHardware.setValue(ecuHardwareDto.getValue());
	
		
		EcuHardware updatedecuHardware = ecuHardwareRepository.save(ecuHardware); 	
		return EcuHardwareMapper.mapToEcuHardwareDto(updatedecuHardware);
	}

	@Override
	public void deleteEcuHardwareId(Long id) {
		EcuHardware ecuHardware = ecuHardwareRepository
				.findById(id)
				.orElseThrow(()->new EcuHardwareNotFound("EcuSoftware could not be deleted!"));
		ecuHardwareRepository.delete(ecuHardware);
		
	}



}
