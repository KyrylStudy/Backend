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
import org.springframework.web.bind.annotation.RestController;

import com.masterproject.AUTOtech.agil.dto.BusPropertyDto;
import com.masterproject.AUTOtech.agil.service.BusPropertyService;



@RestController
@RequestMapping("/api/")
public class BusPropertyController {

    private BusPropertyService busPropertyService;

    public BusPropertyController(BusPropertyService busPropertyService) {
        super();
        this.busPropertyService = busPropertyService;
    }

    // Add Bus Property REST API
    @PostMapping("bus_property/{bus_id}")
    public ResponseEntity<BusPropertyDto> addBusProperty(@PathVariable(value="bus_id") Long bus_id, @RequestBody BusPropertyDto busPropertyDto) {
        return new ResponseEntity<>(busPropertyService.createBusProperty(bus_id, busPropertyDto), HttpStatus.CREATED);
    }

    // Get EcuSoftware REST API
    /*@GetMapping("/{id}")
    public ResponseEntity<EcuSoftwareDto> getEcuSoftwareById(@PathVariable Long id) {
        EcuSoftwareDto ecuSoftwareDto = ecuSoftwareService.getEcuSoftwareDtoById(id);
        return ResponseEntity.ok(ecuSoftwareDto);
    }*/
    
    //Get All Bus Properties REST API
    @GetMapping("bus_properties/{bus_id}")
    public ResponseEntity<List<BusPropertyDto>> getAllBusProperties(@PathVariable(value="bus_id") Long bus_id){
    	List<BusPropertyDto> busProperty = busPropertyService.getAllBusPropertyByBusId(bus_id);
    	return ResponseEntity.ok(busProperty);
    }
    
	//Update Bus Property by Id REST API
	@PutMapping("bus_property/{id}/update")
	public ResponseEntity<BusPropertyDto> updateBusProperty(@RequestBody BusPropertyDto busPropertyDto,@PathVariable("id") Long id) {
		BusPropertyDto response = busPropertyService.updateBusProperty(busPropertyDto, id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
    
	//Delete Bus Property by Id REST API
	@DeleteMapping("bus_property/{id}/delete")
	public ResponseEntity<String> deleteBusPropertyId(@PathVariable("id") Long id) {
		busPropertyService.deleteBusPropertyId(id);
		return new ResponseEntity<>("Bus Property deleted!", HttpStatus.OK);
	}
}


