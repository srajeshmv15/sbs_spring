package com.sbtech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aarti")
public class Aarti {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="aarti_name")
	private String aartiName;
	
	@Column(name="time")
	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAartiName() {
		return aartiName;
	}

	public void setAartiName(String aartiName) {
		this.aartiName = aartiName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Aarti [id=" + id + ", aartiName=" + aartiName + ", time=" + time + "]";
	}
	
	
	
}
