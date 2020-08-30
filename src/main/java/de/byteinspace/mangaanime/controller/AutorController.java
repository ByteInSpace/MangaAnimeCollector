package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.service.AutorService;

@Controller
@RequestMapping("/autor")
public class AutorController {

@Autowired AutorService autorenService;
	
	@GetMapping("/")
	public String defaultSerie(Model model) {
		return showAllAutors(model);
	}
	
	@GetMapping("/show")
	public String showAllAutors(Model model) {
		model.addAttribute("autors", autorenService.getAllAutors());
		return "autorShowAll";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showOneAutor(@PathVariable Long id, Model model ) {
		model.addAttribute("autor", autorenService.getAutorByID(id));
		return "autorShowDetail";
	}
	
}
