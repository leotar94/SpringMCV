package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.model.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonaDAOImpl.class);
	
	private SessionFactory sessFact;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessFact=sf;
	}
	
	@Override
	public void addPersona(Persona p) {
		Session sess = this.sessFact.getCurrentSession();
		sess.persist(p);
		logger.info("Persona salvata con successo, Dettagli: "+p);//p.toString?
	}

	@Override
	public void updatePersona(Persona p) {
		Session sess = this.sessFact.getCurrentSession();
		sess.update(p);
		logger.info("Aggiornamento completato con successo. Dettagli: "+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listaPersone() {
		Session sess = this.sessFact.getCurrentSession();
		List<Persona> persone = sess.createQuery("from Persona").list();//errore
		persone.forEach(p->logger.info("Lista ::"+p));
		return persone;
	}

	@Override
	public Persona getPersonaById(int id) {
		Session sess = this.sessFact.getCurrentSession();
		Persona p = (Persona) sess.get(Persona.class, id);
		logger.info("Recupero dati effettuato correttamente. Dettagli: "+p);
		return p;
	}

	@Override
	public void removePersonaById(int id) {
		Persona p = getPersonaById(id);
		Session sess= this.sessFact.getCurrentSession();
		sess.delete(p);
		logger.info("Eliminazione effettuata con successo. Dettagli: "+p);
	}

}

// nota bene, non stiamo usando le transaction poichè se ne occupa il framework spring
