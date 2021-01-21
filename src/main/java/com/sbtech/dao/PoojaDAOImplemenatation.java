package com.sbtech.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbtech.entities.Pooja;

@Repository
public class PoojaDAOImplemenatation implements PoojaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Pooja savePooja(Pooja pooja) {
		// get current session
		Session currentSession = 
						sessionFactory.getCurrentSession();
				
		currentSession.saveOrUpdate(pooja);
		return pooja;
	}

	public Pooja getPooja(int id) {
		// get current session
				Session currentSession = 
								sessionFactory.getCurrentSession();
						
			   Pooja pooja = currentSession.get(Pooja.class, id);
			   return pooja;			

	}

	public List<Pooja> getPoojas() {
		// get current session
				Session currentSession = 
						sessionFactory.getCurrentSession();
				
			   List<Pooja> poojas = currentSession.createQuery("from Pooja", 
								Pooja.class).getResultList();
				
			  return poojas; 
	}

	public int deletePooja(int id) {
		// get current session
				Session currentSession = 
								sessionFactory.getCurrentSession();
				
				Query query = currentSession.
				    createQuery("delete from Pooja where id=:poojaId");
				query.setParameter("poojaId", id);     
				
				query.executeUpdate();	
				
				return id;
	}

	public List<Pooja> getPoojas(String queryString, Date pDate) {
		List<Pooja> poojas = null;
		// get current session
		Session currentSession = 
						sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery(queryString, Pooja.class);
		query.setParameter("pDate", pDate, DateType.INSTANCE);
         
		return poojas = query.getResultList();
		
	}

}
