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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import de.byteinspace.mangaanime.entity.Artbook;
import de.byteinspace.mangaanime.service.ArtbookService;
import de.byteinspace.mangaanime.service.AutorService;
import de.byteinspace.mangaanime.service.LanguageService;
import de.byteinspace.mangaanime.service.SerieService;

@Controller
@RequestMapping("/admin/artbook")
public class ArtbookAdminController {

	@Autowired ArtbookService artbookService;
	@Autowired SerieService serieService;
	@Autowired AutorService autorService;
	@Autowired LanguageService languageService;
	
	
	@GetMapping("/")
	public String showCreateArtbooksForm(Model model) {
		model.addAttribute("artbooks", artbookService.getAllArtbooks());
		return "adminArtbookShowAll";
	}
	
	@GetMapping("/showall")
	public String showAllArtbooks(Model model) {
		model.addAttribute("artbooks", artbookService.getAllArtbooks());
		return "adminArtbookShowAll";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteArtbookByID(@PathVariable Long id, Model model) {
		artbookService.deleteArtbookByID(id);
		return "adminArtbookDeleted";
	}
	
	@GetMapping("/addNewArtbook")
	public String addNewArtbook(Model model) {
		model.addAttribute("artbook",  new Artbook());
		model.addAttribute("series", serieService.getAllSeries() );
		model.addAttribute("autors", autorService.getAllAutors());
		model.addAttribute("languages", languageService.getAllLanguages());
		return "adminArtbookAddEdit";
	}
	
	@PostMapping("/addNewArtbookConfirmation")
	public String addNewArtbookConfirmation(@ModelAttribute Artbook artbook, @ModelAttribute("action") String action, @RequestParam("fileToUpload") MultipartFile  uploadFile, Model model) {
		artbookService.processAddUpdate(artbook, action, uploadFile);
		return "adminArtbookAdded";
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editSerie(@PathVariable Long id, Model model) {
		model.addAttribute("artbook",  artbookService.getArtbookByID(id));
		model.addAttribute("series", serieService.getAllSeries() );
		model.addAttribute("autors", autorService.getAllAutors());
		model.addAttribute("languages", languageService.getAllLanguages());
		model.addAttribute("action", "edit");
		return "adminArtbookAddEdit";
	}
}
