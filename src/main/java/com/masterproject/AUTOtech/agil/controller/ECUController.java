package com.masterproject.AUTOtech.agil.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import com.masterproject.AUTOtech.agil.dto.ECUdto;
import com.masterproject.AUTOtech.agil.dto.EcuSoftwareDto;
import com.masterproject.AUTOtech.agil.service.ECUService;

@RestController
@RequestMapping("/api/ecus")
public class ECUController {

	private ECUService ecuService;

	public ECUController(ECUService ecuService) {
		super();
		this.ecuService = ecuService;
	}
	
	//Add ECU REST API
	@PostMapping("/{architecture_id}/ecu")
	public ResponseEntity<ECUdto> createECU(@PathVariable(value="architecture_id") Long architecture_id, @RequestBody ECUdto ecuDto){
		return new ResponseEntity<>(ecuService.createECU(architecture_id, ecuDto), HttpStatus.CREATED);
	}
	
	//Get all ECUs by architecture id REST API
	@GetMapping("/architecture/{architecture_id}")
	public ResponseEntity<List<ECUdto>> getAllEcusByArchitectureId(@PathVariable(value="architecture_id") Long architecture_id){
		return new ResponseEntity<>(ecuService.getAllEcusByArchitectureId(architecture_id), HttpStatus.OK);
	}
	
	//Get ECU by Id REST API
	@GetMapping("/{id}")
	public ResponseEntity<ECUdto> getECUbyId(@PathVariable Long id) {
		return ResponseEntity.ok(ecuService.getECUbyId(id));
	}

	//Update ECU by Id REST API
	@PutMapping("/{id}/update")
	public ResponseEntity<ECUdto> updateEcu(@RequestBody ECUdto ecuDto,@PathVariable("id") Long ecuId) {
		ECUdto response = ecuService.updateEcu(ecuDto, ecuId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	//Delete ECU by Id REST API
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteEcuId(@PathVariable("id") Long ecuId) {
		ecuService.deleteEcuId(ecuId);
		return new ResponseEntity<>("ECU deleted!", HttpStatus.OK);
	}
	
	
	
}
