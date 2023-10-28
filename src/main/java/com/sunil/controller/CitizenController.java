package com.sunil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.model.Citizen;
import com.sunil.repository.CitizenRepository;
import com.sunil.service.CitizenService;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {
	
	@Autowired
	private CitizenRepository citizenRepository;

	@Autowired
	private CitizenService citizenService;
	
	
	@GetMapping("/{ssn}")
	public ResponseEntity<Citizen> getCitizenDetailsBySsn(@PathVariable String ssn){
		Citizen citizen = citizenService.getCitizenDetailsBySsn(ssn);
		if(citizen == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(citizen);
	}
	
	@PostMapping("/citizen")
	public Citizen addCitizen(@RequestBody Citizen citizen) {
		return citizenRepository.save(citizen);
	}
	
}
