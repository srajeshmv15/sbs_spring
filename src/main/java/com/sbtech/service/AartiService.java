package com.sbtech.service;

import java.util.List;

import com.sbtech.entities.Aarti;

public interface AartiService {
   
	public Aarti saveAarti(Aarti aarti);
	public Aarti getAarti(int id);
	public List<Aarti> getAarties();
	public int deleteAarti(int id);
	
}
