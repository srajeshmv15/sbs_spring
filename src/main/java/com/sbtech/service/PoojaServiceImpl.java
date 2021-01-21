package com.sbtech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbtech.dao.PoojaDAO;
import com.sbtech.entities.Pooja;

@Service
public class PoojaServiceImpl implements PoojaService {

	@Autowired
	private PoojaDAO poojaDAO;
	
	@Transactional
	public Pooja savePooja(Pooja pooja) {
		List<Pooja> poojas = poojaDAO.getPoojas("from Pooja poo where poo.poojaDate = :pDate", pooja.getPoojaDate());
		if (poojas.isEmpty()) {
			return poojaDAO.savePooja(pooja);
		}
        return null;
	}

	@Transactional
	public Pooja getPooja(int id) {
		return poojaDAO.getPooja(id);
	}

	@Transactional
	public List<Pooja> getPoojas() {
		return poojaDAO.getPoojas();
	}

	@Transactional
	public int deletePooja(int id) {
		return poojaDAO.deletePooja(id);
	}

}
