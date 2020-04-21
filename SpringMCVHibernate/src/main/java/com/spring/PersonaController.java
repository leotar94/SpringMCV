package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Persona;
import com.spring.service.PersonaService;

@Controller
public class PersonaController {
	private PersonaService pService;
	
	@Autowired(required=true)
	@Qualifier(value="pService")
	public void setPersonaService(PersonaService ps) {
		this.pService=ps;
	}
	
	@RequestMapping(value = "/persone", method = RequestMethod.GET)
	public String listaPersone(Model model) {
		model.addAttribute("persona", new Persona());
		model.addAttribute("listaPersone",this.pService.listaPersone());
		return "persona";
	}
	
	@RequestMapping(value="/persona/add", method=RequestMethod.POST)
	public String addPersona(@ModelAttribute("persona")Persona p) {
		if(p.getId()==0) {
			this.pService.addPersona(p);
		}else {
			this.pService.updatePersona(p);
		}
		return "redirect:/persone";
	}
	
	@RequestMapping("remove/{id}")
	public String removePersona(@PathVariable("id")int id, Model model) {
		this.pService.deletePersona(id);
		return "redirect:/persone";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPersona(@PathVariable("id")int id, Model model) {
		model.addAttribute("persona",this.pService.getPersonaById(id));
		model.addAttribute("listaPersone",this.pService.listaPersone());
		return "persona";
	}
}
