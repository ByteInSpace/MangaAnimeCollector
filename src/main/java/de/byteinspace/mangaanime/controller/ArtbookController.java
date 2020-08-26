package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.entity.Artbook;
import de.byteinspace.mangaanime.service.ArtbookService;

@Controller
@RequestMapping("/artbook")
public class ArtbookController {

	@Autowired ArtbookService artbookService;
	
	
	@GetMapping("/all")
	public Iterable<Artbook> getAllArtbooks() {
		return artbookService.getAllArtbooks();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showOneArtbook(@PathVariable Long id, Model model ) {
		model.addAttribute("artbook", artbookService.getArtbookByID(id));
		return "showDetailArtbook";
	}
	
	@GetMapping("/showall")
	public String showAllArtbooks(Model model) {
		model.addAttribute("artbooks", artbookService.getAllArtbooks());
		return "showAllArtbooks";
	}
}

