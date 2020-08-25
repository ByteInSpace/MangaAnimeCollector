package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.repository.ArtbookRepository;

@Controller
@RequestMapping("/admin/artbook")
public class ArtbookAdminController {

	@Autowired ArtbookRepository artbookRepository;
	
	@GetMapping("/")
	public String showCreateArtbooksForm() {
		return "showArtbooksCreateForm";
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
}
