package com.cg.bookmydoctor.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmydoctor.dao.IDoctorDao;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.service.PatientServiceImpl;


//@CrossOrigin("http://localhost:3500")
@RestController
@RequestMapping("/PatientService")

public class PatientController {
	
	
	private IDoctorDao docDao;
	@Autowired(required = true)
	PatientServiceImpl PatientService;

	//working
	@PostMapping("/addPatient")
	@ExceptionHandler(PatientException.class)
	public Patient addPatient(@RequestBody Patient bean) {
		return PatientService.addPatient(bean);
	}

	//working
	@PutMapping("/updatePatient")
	@ExceptionHandler(PatientException.class)
	public Patient editPatientProfile(@RequestBody Patient bean) {
		return PatientService.editPatientProfile(bean);
	}
	
	//working
	@DeleteMapping("/removePatientDetails")
	@ExceptionHandler(PatientException.class)
	public Patient removePatientDetails(@RequestBody Patient bean) {
		return PatientService.removePatientDetails(bean);
	}
	
	//working    
	@GetMapping("/getPatient/{patientId}")
	@ExceptionHandler(PatientException.class)
	public Patient getPatient(@PathVariable("patientId") Patient Patient) {
		return PatientService.getPatient(Patient);
	}
	//working
	@GetMapping("/allPatient")
	public List<Patient> getAllPatient() {
		return PatientService.getAllPatient();
	}
	public Doctor getDoctor(int docId) {
		Optional<Doctor> docdb = docDao.findById(docId);
		if(docdb.isPresent()) {
			return docdb.get();
		} else {
			throw new PatientException("NOOOOOOOOOOOOOOOOOOOOOOOO");
		}
	}
	
	@GetMapping("/allPatientByDoctor/{doctorId}")
	public List<Patient> getPatientListByDoctor(@PathVariable("doctorId") int doctorId) {
		
		return PatientService.getPatientListByDoctor(getDoctor(doctorId));
	}
	
	
	@GetMapping("/allPatientByDate")
	public List<Patient> getPatientListByDate(@PathVariable("appDate") LocalDate appdate) {
		return PatientService.getPatientListByDate(appdate);
	}

}