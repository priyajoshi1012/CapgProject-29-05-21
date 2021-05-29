package com.cg.bookmydoctor.dto;

import java.io.Serializable;  
import java.util.Date;

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
//import com.cg.bookmydoctor.dto.*;
@Entity
@Table(name = "AvailabilityDates")
public class AvailabilityDates implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "availabiltyId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int availabilityId;
	
	@OneToOne
	@JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
	private Doctor doctor;
	
	
	
	@Column(name="fromDate")
	private Date fromDate;
	
	@Column(name="toDate")
	private Date toDate;
	
	
	public AvailabilityDates() {}
	
	
	public AvailabilityDates(int availabilityId, Doctor doctor, Date fromDate, Date toDate) {
		super();
		this.availabilityId = availabilityId;
		this.doctor = doctor;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	
	public int getAvailabilityId() {
		return availabilityId;
	}
	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "AvailabilityDates [availabilityId=" + availabilityId + ", doctor=" + doctor + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	
	
	
}
