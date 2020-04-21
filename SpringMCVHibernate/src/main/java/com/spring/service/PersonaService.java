package com.spring.service;

import java.util.List;

import com.spring.model.Persona;

public interface PersonaService {
	void addPersona(Persona p);
	void updatePersona(Persona p);
	List<Persona> listaPersone();
	Persona getPersonaById(int id);
	void deletePersona(int id);
}
