package com.sbtech.service;

import java.util.List;

import com.sbtech.entities.Pooja;


public interface PoojaService {
   
	public Pooja savePooja(Pooja pooja);
	public Pooja getPooja(int id);
	public List<Pooja> getPoojas();
	public int deletePooja(int id);
	
}
