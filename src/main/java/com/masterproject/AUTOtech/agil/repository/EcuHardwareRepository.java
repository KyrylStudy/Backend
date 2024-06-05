package com.masterproject.AUTOtech.agil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masterproject.AUTOtech.agil.entity.EcuHardware;
import java.util.List;

//@Repository
public interface EcuHardwareRepository extends JpaRepository<EcuHardware, Long>{
	List<EcuHardware> findByHardwareId(Long id);
} 


