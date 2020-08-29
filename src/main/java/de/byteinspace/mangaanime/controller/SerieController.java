package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.service.SerieService;

@Controller
@RequestMapping("/serie")
public class SerieController {

	@Autowired SerieService serienService;
	
	@GetMapping("/")
	public String defaultSerie(Model model) {
		return showAllSeries(model);
	}
	
	@GetMapping("/show")
	public String showAllSeries(Model model) {
		model.addAttribute("series", serienService.getAllSeries());
		return "serieShowAll";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showOneSerie(@PathVariable Long id, Model model ) {
		model.addAttribute("serie", serienService.getSerieByID(id));
		return "serieShowDetail";
	}
	
	
}
