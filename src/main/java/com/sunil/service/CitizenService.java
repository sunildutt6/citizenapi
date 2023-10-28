package com.sunil.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.model.Citizen;
import com.sunil.repository.CitizenRepository;

@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@Autowired
	private StateService stateService;
	
	public List<Citizen> getCitizenDetails(String name, LocalDate dateOfBirth, String gender, String ssn){
		List<Citizen> citizens = citizenRepository.findByNameAndDateOfBirthAndGenderAndSsn(name, dateOfBirth, gender, ssn);
		for(Citizen citizen : citizens) {
			String stateName = stateService.getStateName(citizen.getSsn());
			citizen.setStateName(stateName);
		}		
		return citizens;
		
	}
	
	public Citizen getCitizenDetailsBySsn(String ssn) {
		Citizen citizen = citizenRepository.findBySsn(ssn);
		String stateName = stateService.getStateName(citizen.getSsn());
		citizen.setStateName(stateName);
		return citizen;
	}
	

}
