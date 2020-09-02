package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.service.PublisherService;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
	
	@Autowired PublisherService publisherenService;
	
	@GetMapping("/")
	public String defaultSerie(Model model) {
		return showAllPublishers(model);
	}
	
	@GetMapping("/show")
	public String showAllPublishers(Model model) {
		model.addAttribute("publishers", publisherenService.getAllPublishers());
		return "publisherShowAll";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showOnePublisher(@PathVariable Long id, Model model ) {
		model.addAttribute("publisher", publisherenService.getPublisherByID(id));
		return "publisherShowDetail";
	}
	
}
