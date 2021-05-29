package com.cg.bookmydoctor.dao;


import java.util.Optional; 

import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAvailabilityDao  extends CrudRepository<Doctor,Integer> {

	//void saveAvailabilityDates(AvailabilityDates bean);

	void save(AvailabilityDates bean);

	//void save(AvailabilityDates bean);

	
	
}
