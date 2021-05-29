package com.cg.bookmydoctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.bookmydoctor.dao.*;
import com.cg.bookmydoctor.dto.Appointment;

@SpringBootApplication
public class BookMyDoctorAppApplication{ //implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(BookMyDoctorAppApplication.class, args);
	}
	/*@Autowired
	private IAppointmentDao appdao;
	
	@Autowired
	private IPatientDao patdao;
	
	@Override
	public void run(String...args) throws Exception{
		Patient p = new Patient();
		p.set
	}*/
}