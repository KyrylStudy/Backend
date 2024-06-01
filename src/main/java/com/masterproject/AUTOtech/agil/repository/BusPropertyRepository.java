package com.masterproject.AUTOtech.agil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterproject.AUTOtech.agil.entity.BusProperty;
import java.util.List;


public interface BusPropertyRepository extends JpaRepository<BusProperty, Long>{
	List<BusProperty> findByBusId(Long id);
} 

