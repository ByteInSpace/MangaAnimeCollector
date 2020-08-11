package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.entity.Artbook;
import de.byteinspace.mangaanime.repository.ArtbookRepository;

@Controller
@RequestMapping("/artbook")
public class ArtbookController {

	@Autowired private ArtbookRepository artbookRepository;
	
	@GetMapping("/all")
	public Iterable<Artbook> getAllArtbooks() {
		return artbookRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showOneArtbook(@PathVariable Long id, Model model ) {
		model.addAttribute("artbook", artbookRepository.findArtbookById(id));
		return "showDetailArtbook";
	}
	
	@GetMapping("/showall")
	public String showAllArtbooks(Model model) {
		model.addAttribute("artbooks", artbookRepository.findAll());
		return "showAllArtbooks";
	}
}

