package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PersonaDAO;
import com.spring.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	private PersonaDAO pdao;
	
	public void setPersonaDAO(PersonaDAO pdao) {
		this.pdao=pdao;
	}
	
	@Transactional
	@Override
	public void addPersona(Persona p) {
		this.pdao.addPersona(p);
	}
	
	@Transactional
	@Override
	public void updatePersona(Persona p) {
		this.pdao.updatePersona(p);
	}
	
	@Transactional
	@Override
	public List<Persona> listaPersone() {
		return this.pdao.listaPersone();//errore
	}

	@Transactional
	@Override
	public Persona getPersonaById(int id) {
		return this.pdao.getPersonaById(id);
	}

	@Transactional
	@Override
	public void deletePersona(int id) {
		this.pdao.removePersonaById(id);
	}

}
