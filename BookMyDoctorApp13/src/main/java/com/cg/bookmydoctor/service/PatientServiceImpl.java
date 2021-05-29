package com.cg.bookmydoctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.dao.IPatientDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List; 
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cg.bookmydoctor.dao.*;

@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
	private IPatientDao patientDao;
	
	private IDoctorDao docDao;
	
	private AppointmentServiceImpl appImpl;
	
	Appointment a;

	private IAppointmentDao appDao;

	@Override
	//working
	public Patient addPatient(Patient bean) {
		//Optional<Doctor> findById = docDao.findById(dr.getDoctorId());
		if(bean == null) {
			throw new PatientException("Passed object can't be null");
		} else {
			return patientDao.save(bean);
		}
	}

	@Override
	//working
	public Patient editPatientProfile(Patient bean) {
		Optional<Patient> patientDb = patientDao.findById(bean.getPatientId());
		if (patientDb.isPresent()) {
			patientDao.save(bean);
		} 
		else
			throw new PatientException("Patient with ID: " + bean.getPatientId() + "does not exists");
		return bean;

	} 
		
	@Override
	//working
	public Patient removePatientDetails(Patient bean) {
		Patient Patient1 = bean;
		Optional<Patient> docdb = patientDao.findById(bean.getPatientId());
		if(docdb.isPresent()) {
			patientDao.delete(bean);	
		} else {
			throw new PatientException("The passed object can't be null");
		}
		return Patient1;
	}
	
	@Override
	//working
	public Patient getPatient(Patient patient) {
		Optional<Patient> patientDb = this.patientDao.findById(patient.getPatientId());
		if(patientDb.isPresent()) {
			return patientDb.get();
		}
		else {
			throw new PatientException("Record not found with id : " + patient.getPatientId());
		}
	}
	
	@Override
	//working
	public List<Patient> getAllPatient(){
		Iterable<Patient> result = patientDao.findAll();
		List<Patient> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}
	
	
	
	/*@Override
	public List<Patient> getPatientListByDoctor(Doctor doctor){
		Doctor thisDoctor = getDoctor(doctor.getDoctorId());
		//if(this.appDao.count()>0) {
			List<Appointment> appt = appDao.findByDoctor(doctor);
			List<Patient> pat = new ArrayList<>();
			//int id = doctor.getDoctorId();
			if(!appt.isEmpty()) {
				for(Appointment i : appt) {
					//for(Appointment i : appt) {
						if(i.getDoctor()==doctor)
							pat.add(i.getPatient());
					}
				//for(Appointment k : appt) {
					//if(i.getDoctor().getDoctorId() == id)
						//pat.add(i.getPatient());
				//}
			
		}
		return pat;
		}else {
			return null;
		}
	}*/
	@Override
	public List<Patient> getPatientListByDoctor(Doctor doctor){
		//Doctor thisDoctor = getDoctor(doctor.getDoctorId());
		List<Patient> list = appDao.findByDoctorId(doctor.getDoctorId());
		return list;
		
	//try to run this once	
	}
	//@Override
	//public List<Patient> getPatientListByDoctor(Doctor doctor){
	//	return null;
	//}
	
	@Override
	public List<Patient> getPatientListByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("appointmentDate") LocalDate appdate){
	//	a.getClass();
		//LocalDate localDate = a.getAppointmentDate();
		List<Patient> p1 = appDao.findByDate(appdate);
		//List<Doctor> doctors = doctorDao.findByDoctor(doctor)
		//List<Appointment> appt  = appImpl.getAppointments(appdate);

		//if(localDate == appdate) {
			//p1.add(a.getPatient());
		//}
		/*Iterable<Appointment> appt = appDao.findAll();
		Iterator<Appointment> iterator = appt.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getAppointmentDate() == appdate)
				p1.add(iterator.next().getPatient());
		}
		Iterator<Appointment> iterator = appt.iterator();
		while(iterator.hasNext()) {
			p1.add(iterator.next().getPatient());
		}*/
		return p1;
	}
}