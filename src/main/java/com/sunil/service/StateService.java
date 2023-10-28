package com.sunil.service;

import org.springframework.stereotype.Service;

@Service
public class StateService {

	public String getStateName(String ssn) {

		String stateName;
		if (ssn.startsWith("1")) {
			stateName = "New Jersey";
		} else if (ssn.startsWith("2")) {
			stateName = "Ohio";
		} else if (ssn.startsWith("3")) {
			stateName = "Texas";
		} else if (ssn.startsWith("4")) {
			stateName = "California";
		} else if (ssn.startsWith("5")) {
			stateName = "Rhode Island";
		} else if (ssn.startsWith("6")) {
			stateName = "Kentucky";
		} else {
			stateName = "Invalid SSN";
		}

		return stateName;
	}
}
