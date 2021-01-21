package com.sbtech.dao;

import java.util.List;

import com.sbtech.entities.Aarti;

public interface AartiDAO {

	public Aarti saveAarti(Aarti aarti);
	public Aarti getAarti(int id);
	public List<Aarti> getAarties();
	public int deleteAarti(int id);
	
}
