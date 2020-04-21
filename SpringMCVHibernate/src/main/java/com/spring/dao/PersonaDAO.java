package com.spring.dao;

import java.util.List;

import com.spring.model.Persona;

public interface PersonaDAO {
	void addPersona(Persona p);
	void updatePersona(Persona p);
	List<Persona> listaPersone();
	Persona getPersonaById(int id);
	void removePersonaById(int id);
}
