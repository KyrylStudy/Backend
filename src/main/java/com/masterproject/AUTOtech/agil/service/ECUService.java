package com.masterproject.AUTOtech.agil.service;

import java.util.List;

import com.masterproject.AUTOtech.agil.dto.ECUdto;
import com.masterproject.AUTOtech.agil.entity.ECU;

public interface ECUService {
	
	ECUdto createECU(Long architecture_id, ECUdto ecudto);
	
	List<ECUdto> getAllEcusByArchitectureId(Long architecture_id);
	
	ECUdto getECUbyId(Long id);
	
	ECUdto updateEcu(ECUdto ecuDtro, Long id);
	
	void deleteEcuId(Long id);
	
	

}
