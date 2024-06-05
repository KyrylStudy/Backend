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

import com.masterproject.AUTOtech.agil.dto.BusDto;
import com.masterproject.AUTOtech.agil.dto.HardwareDto;
import com.masterproject.AUTOtech.agil.service.BusService;

@RestController
@RequestMapping("/api/bus")
public class BusController {
	
	private BusService busService;
	
	public BusController(BusService busService) {
		super();
		this.busService = busService;
	}
	
	//Add ECU REST API
	@PostMapping("/{architecture_id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BusDto> createBus(@PathVariable(value="architecture_id") Long architecture_id, @RequestBody BusDto busDto){
		return new ResponseEntity<>(busService.createBus(architecture_id, busDto), HttpStatus.CREATED);
	}
	
	//Get all Architecture REST API
	@GetMapping("/architecture/{architecture_id}")
	public ResponseEntity<List<BusDto>> getAllBuses(@PathVariable(value="architecture_id") Long architecture_id){
		return new ResponseEntity<>(busService.getAllBuses(architecture_id), HttpStatus.OK);
	}
	
	//Update Architecture by Id REST API
	@PutMapping("/{id}/update")
	public ResponseEntity<BusDto> updateArchitecture(@RequestBody BusDto busDto,@PathVariable("id") Long id) {
		BusDto response = busService.updateBus(busDto, id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Delete Architecture by Id REST API
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteBusId(@PathVariable("id") Long id) {
		busService.deleteBusId(id);
		return new ResponseEntity<>("Bus deleted!", HttpStatus.OK);
	}

}
