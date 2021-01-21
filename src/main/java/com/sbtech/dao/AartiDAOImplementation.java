package com.sbtech.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbtech.entities.Aarti;

@Repository
public class AartiDAOImplementation implements AartiDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Aarti saveAarti(Aarti aarti) {   
		// get current session
		Session currentSession = 
				sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(aarti);
		return aarti;
	}

	public Aarti getAarti(int id) {	
		// get current session
		Session currentSession = 
						sessionFactory.getCurrentSession();
				
	   Aarti aarti = currentSession.get(Aarti.class, id);
	   return aarti;			
	}

	public List<Aarti> getAarties() {
		// get current session
		Session currentSession = 
				sessionFactory.getCurrentSession();
		
	   List<Aarti> aartis = currentSession.createQuery("from Aarti", 
						Aarti.class).getResultList();
		
	  return aartis; 
	}

	public int deleteAarti(int id) {
		// get current session
		Session currentSession = 
						sessionFactory.getCurrentSession();
		
		Query query = currentSession.
		    createQuery("delete from Aarti where id=:aartiId");
		query.setParameter("aartiId", id);     
		
		query.executeUpdate();	
		
		return id;
	}

}
