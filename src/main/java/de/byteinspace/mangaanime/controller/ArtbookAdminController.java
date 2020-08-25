package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.entity.Artbook;
import de.byteinspace.mangaanime.repository.ArtbookRepository;
import de.byteinspace.mangaanime.repository.AutorRepository;
import de.byteinspace.mangaanime.repository.LanguageRepository;
import de.byteinspace.mangaanime.repository.SerieRepository;

@Controller
@RequestMapping("/admin/artbook")
public class ArtbookAdminController {

	@Autowired ArtbookRepository artbookRepository;
	@Autowired SerieRepository serieRepository;
	@Autowired AutorRepository autorRepository;
	@Autowired LanguageRepository languageRepository;
	
	@GetMapping("/")
	public String showCreateArtbooksForm(Model model) {
		model.addAttribute("artbooks", artbookRepository.findAll());
		return "adminArtbookShowAll";
	}
	
	@GetMapping("/showall")
	public String showAllArtbooks(Model model) {
		model.addAttribute("artbooks", artbookRepository.findAll());
		return "adminArtbookShowAll";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteArtbookByID(@PathVariable Long id, Model model) {
		artbookRepository.deleteById(id);
		return "adminArtbookDeleted";
	}
	
	@GetMapping("/addNewArtbook")
	public String addNewArtbook(Model model) {
		model.addAttribute("artbook",  new Artbook());
		model.addAttribute("series", serieRepository.findAll() );
		model.addAttribute("autors", autorRepository.findAll() );
		model.addAttribute("languages", languageRepository.findAll());
		return "adminArtbookAddNew";
	}
	
	@PostMapping("/addNewArtbookConfirmation")
	public String addNewArtbookConfirmation(@ModelAttribute Artbook artbook, Model model) {
		artbookRepository.save(artbook);
		return "adminArtbookAdded";
		
	}
}
