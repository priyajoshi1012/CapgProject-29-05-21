package com.cg.bookmydoctor.service;





import java.util.ArrayList;   
import java.util.List;      
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.dao.*;


@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao docDao;
	Doctor doctor;
	@Autowired
	private IAvailabilityDao availDao;
	//AvailabilityDates availDates;
	
	//all the details doctors
	//working
	@Override
	public List<Doctor> getDoctorList() {
		Iterable<Doctor> result = docDao.findAll();
		List<Doctor> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}
	
	//working
	@Override
	public Doctor addDoctor(Doctor dr) {
		//Optional<Doctor> findById = docDao.findById(dr.getDoctorId());
		if(dr == null) {
			throw new DoctorException("Passed object can't be null");
		} else {
			return docDao.save(dr);
		}
	}

	//working
	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		// TODO Auto-generated method stub
		//Optional<Doctor> findById = docDao.findById(bean.getDoctorId());
		if(bean == null) {
			throw new DoctorException("Passed object can't be null");
		} else {
			return docDao.save(bean);
		}
	}
	
	
	//working
	@Override
	public Doctor removeDoctor(Doctor doc) {
		Doctor dr = doc;
		//Optional<Doctor> docdb = docDao.findById(doc.getDoctorId());
		if(doc == null) {
			throw new DoctorException("The passed object can't be null");

		} else {
			docDao.deleteById(doc.getDoctorId());	
		}
		return dr;
	}
	
	
	//working
	public Doctor getDoctor(Doctor doc) {
		Optional<Doctor> docdb = docDao.findById(doc.getDoctorId());
			return docdb.get();
		
	}
	
	
	//working
		@Override
		public List<Doctor> getDoctorList(String speciality) {
			
			Optional<Doctor> findById = docDao.findBySpeciality(speciality);
			List<Doctor> doclist = new ArrayList<>();
			if (findById.isPresent()) {
				doclist.add(findById.get());
			} else
				throw new DoctorException("Doctor with the speciality : " + speciality + "not exists");

			return doclist;
		}

	public boolean updateAvailability(int availabilityId) {
		if(availabilityId > 0) {
			//ad.setAvailabilityId(ad.getAvailabilityId());
			ad.setDoctor(ad.getDoctor());
			ad.setFromDate(ad.getFromDate());
			ad.setToDate(ad.getToDate());
			return true;		
		} else {
			return false;
		}
	}


	private AvailabilityDates ad;

	public boolean addAvailability(AvailabilityDates availDates) {
		//if(bean != null) {
			//if(doctor.getDoctorId() ==  bean.getDoctor().getDoctorId()) {
				availDao.save(availDates);
				return true;
		//}	
		//return false;
	}
	
}
