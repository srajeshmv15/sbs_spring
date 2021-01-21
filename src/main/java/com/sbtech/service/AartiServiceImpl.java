package com.sbtech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbtech.dao.AartiDAO;
import com.sbtech.entities.Aarti;

@Service
public class AartiServiceImpl implements AartiService {

	@Autowired
	private AartiDAO aartiDao;
	
	@Transactional
	public Aarti saveAarti(Aarti aarti) {
		return aartiDao.saveAarti(aarti);
	}

	@Transactional
	public Aarti getAarti(int id) {
		return aartiDao.getAarti(id);
	}

	@Transactional
	public List<Aarti> getAarties() {
		return aartiDao.getAarties();
	}

	@Transactional
	public int deleteAarti(int id) {
        return aartiDao.deleteAarti(id);
	}

}
