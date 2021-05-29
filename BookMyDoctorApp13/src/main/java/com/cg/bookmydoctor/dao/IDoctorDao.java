package com.cg.bookmydoctor.dao;

import java.util.List;  
import java.util.Optional;

import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDoctorDao  extends CrudRepository<Doctor,Integer >
{


	Optional<Doctor> findBySpeciality(String speciality);

	

	//void saveAvailabilityDates(AvailabilityDates bean);


	/*public Doctor addDoctor(Doctor bean);
	public Doctor updateDoctorProfile(Doctor bean);
	public boolean addAvailability(AvailabilityDates bean);
	public boolean updateAvailability(AvailabilityDates bean);
	public Doctor getDoctor(Doctor doc);
	public Doctor removeDoctor(Doctor doc);
	public List<Doctor> getDoctorList();
	public List<Doctor> getDoctorList(String speciality);*/
}
