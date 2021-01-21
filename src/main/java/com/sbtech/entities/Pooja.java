package com.sbtech.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="pooja")
public class Pooja {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="pooja_name")
	private String poojaName;
	
	@Column(name="pooja_date")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date poojaDate;
	
	@Column(name="person_name")
	private String personName;
	
	@Column(name="couples")
	private boolean couples;
	
	@Column(name="contact_no")
	private long contactNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoojaName() {
		return poojaName;
	}

	public void setPoojaName(String poojaName) {
		this.poojaName = poojaName;
	}

	public Date getPoojaDate() {
		return poojaDate;
	}

	public void setPoojaDate(Date poojaDate) {
		this.poojaDate = poojaDate;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public boolean isCouples() {
		return couples;
	}

	public void setCouples(boolean couples) {
		this.couples = couples;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Pooja [id=" + id + ", poojaName=" + poojaName + ", poojaDate=" + poojaDate + ", personName="
				+ personName + ", couples=" + couples + ", contactNo=" + contactNo + "]";
	}
	
	
	
}
