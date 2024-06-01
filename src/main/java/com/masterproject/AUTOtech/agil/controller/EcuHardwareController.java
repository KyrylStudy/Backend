package com.masterproject.AUTOtech.agil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masterproject.AUTOtech.agil.dto.EcuHardwareDto;
import com.masterproject.AUTOtech.agil.dto.EcuSoftwareDto;
import com.masterproject.AUTOtech.agil.service.EcuHardwareService;


@RestController
@RequestMapping("/api/")
public class EcuHardwareController {
	
	private EcuHardwareService ecuHardwareService;

	
    public EcuHardwareController(EcuHardwareService ecuHardwareService) {
		super();
		this.ecuHardwareService = ecuHardwareService;
	}


	// Add Ecu Hardware REST API
    @PostMapping("/ecus/{ecu_id}/hardware")
    public ResponseEntity<EcuHardwareDto> addEcuHardware(@PathVariable(value="ecu_id") Long ecu_id, @RequestBody EcuHardwareDto ecuHardwareDto) {
        return new ResponseEntity<>(ecuHardwareService.createEcuHardware(ecu_id, ecuHardwareDto), HttpStatus.CREATED);
    }
    
    //Get All hardware REST API
    @GetMapping("/ecus/{ecu_id}/hardwares")
    public ResponseEntity<List<EcuHardwareDto>> getAllEcuHardware(@PathVariable(value="ecu_id") Long ecu_id){
    	List<EcuHardwareDto> ecuHardware = ecuHardwareService.getAllEcuHardwareByEcuId(ecu_id);
    	return ResponseEntity.ok(ecuHardware);
    }
    
	//Update Ecu hardware by Id REST API
	@PutMapping("hardware/{id}/update")
	public ResponseEntity<EcuHardwareDto> updateEcuHardware(@RequestBody EcuHardwareDto ecuHardwareDto,@PathVariable("id") Long id) {
		EcuHardwareDto response = ecuHardwareService.updateEcuHardware(ecuHardwareDto, id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
    
	//Delete ECU hardware by Id REST API
	@DeleteMapping("hardware/{id}/delete")
	public ResponseEntity<String> deleteEcuHardwareId(@PathVariable("id") Long ecuId) {
		ecuHardwareService.deleteEcuHardwareId(ecuId);
		return new ResponseEntity<>("ECU Hardware deleted!", HttpStatus.OK);
	}
}
