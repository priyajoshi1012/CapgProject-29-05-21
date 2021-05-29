package com.cg.bookmydoctor.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FeedBack")
public class FeedBack {
	
	@Id
	@Column(name = "ratingId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ratingId;
	
	//@OneToOne(targetEntity = Patient.class, cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "patientId", referencedColumnName = "patientId")
	private Patient patient;
	
	//@OneToOne(targetEntity = Doctor.class, fetch = FetchType.EAGER)
	@OneToOne
	@JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
	private Doctor doctor;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="feedback")
	private String feedback;
	
	public FeedBack() {}
	
	public FeedBack(int ratingId, Doctor doctor, Patient patient, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.doctor = doctor;
		this.patient = patient;
		this.rating = rating;
		this.feedback = feedback;
	}

	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "FeedBack [ratingId=" + ratingId + ", patient=" + patient + ", doctor=" + doctor + ", rating=" + rating
				+ ", feedback=" + feedback + "]";
	}
	
	

}
