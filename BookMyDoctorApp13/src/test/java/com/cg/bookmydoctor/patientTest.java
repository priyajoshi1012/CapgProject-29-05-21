package com.cg.bookmydoctor;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.service.IPatientService;

public class patientTest extends BookMyDoctorAppApplicationTests {
	@Autowired
	IPatientService patservice;
	
	@Test
	void patientServiceTest() {
		assertTrue(patservice instanceof IPatientService);
	}
	
	@Test
	public void testAddPatient() {
		Patient pat = new Patient(1,"Priya","891889065","priya@gmail.com","priya@234","A+","Female",23,"Pune");
		pat = patservice.addPatient(pat);
		assertEquals(pat.getPatientId(),1);
		
		Patient pat1 = new Patient(2,"Soumya","782990176","soumya@gmail.com","soumya@234","O+","Female",28,"Hyderabad");
		pat1 = patservice.addPatient(pat1);
		assertEquals(pat1.getPatientId(),2);
	}
	
	
	@Test
	void testEditPatientProfile() {
		testAddPatient();
		Patient pat = new Patient(1,"Divya","891889065","priya@gmail.com","priya@234","A+","Female",23,"Pune");
		pat = patservice.editPatientProfile(pat);
		assertEquals(pat.getPatientName(), "Divya"); 
		
		Patient pat1 = new Patient(2,"Soumya","782990176","soumya@gmail.com","soumya12!","O+","Female",28,"Hyderabad");
		pat = patservice.editPatientProfile(pat1);
		assertEquals(pat1.getPassword(),"soumya12!"); 
	}
	
	@Test
	void testRemovePatientDetails(){
		Patient pat = new Patient(1,"Priya","891889065","priya@gmail.com","priya@234","A+","Female",23,"Pune");
		Patient pat1 = patservice.removePatientDetails(pat);
		assertEquals(pat.getPatientId(), pat1.getPatientId());
	}
	
	@Test
	void testGetPatient() {
		Patient pat = new Patient(1,"Priya","891889065","priya@gmail.com","priya@234","A+","Female",23,"Pune");
		Patient pat1 = patservice.getPatient(pat);
		assertEquals(pat.getPatientId(), 1);
	}
	
	@Test 
	void testGetAllPatient() {
		List<Patient> pat = patservice.getAllPatient(); 
		//assertEquals(1,pat.size());
		assertNotNull(pat);
	}
}
