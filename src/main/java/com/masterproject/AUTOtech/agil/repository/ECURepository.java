package com.masterproject.AUTOtech.agil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterproject.AUTOtech.agil.entity.ECU;

public interface ECURepository extends JpaRepository<ECU, Long>{
	List<ECU> findByArchitectureId(Long id);

}
