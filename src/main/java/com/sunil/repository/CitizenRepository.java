package com.sunil.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

	List<Citizen> findByNameAndDateOfBirthAndGenderAndSsn(String name, LocalDate dateOfBirth, String gender,
			String ssn);

	Citizen findBySsn(String ssn);
}
