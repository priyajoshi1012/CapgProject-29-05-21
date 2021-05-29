package com.cg.bookmydoctor.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;


@Entity

@Table(name = "Appointment")
public class Appointment {
	
	@Id
	@Column(name = "appointmentId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int appointmentId;
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId")
	private Doctor doctor;
	
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	@Column(name="appointmentDate")
	private LocalDate appointmentDate;
	
	@Column(name="appointmentStatus")
	private String appointmentStatus;//approved ,cancelled,completed	
	
	public Appointment() {}

	
	public Appointment(int appointmentId, Doctor doctor, Patient patient, LocalDate appointmentDate,
			String appointmentStatus) {
		super();
		this.appointmentId = appointmentId;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
	}

	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", doctor=" + doctor + ", patient=" + patient
				+ ", appointmentDate=" + appointmentDate + ", appointmentStatus=" + appointmentStatus + "]";
	}
	
	
	
}
