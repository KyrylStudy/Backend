package com.masterproject.AUTOtech.agil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterproject.AUTOtech.agil.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Long>{
	List<Bus> findByArchitectureId(Long id);
}
