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

import de.byteinspace.mangaanime.entity.Autor;
import de.byteinspace.mangaanime.service.AutorService;

@Controller
@RequestMapping("/admin/autor")
public class AutorAdminController {
	
	
	@Autowired AutorService autorenService;


	@GetMapping("/")
	public String defaultAutor(Model model) {
		return showAllAutors(model);
	}
	
	@GetMapping("/show")
	public String showAllAutors(Model model) {
		model.addAttribute("autors", autorenService.getAllAutors());
		return "adminAutorShowAll";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteAutorByID(@PathVariable Long id, Model model) {
		autorenService.deleteAutorByID(id);
		return "adminAutorDeleted";
	}
	
	@GetMapping("/add")
	public String addNewAutor(Model model) {
		model.addAttribute("autor",  new Autor());
		model.addAttribute("action", "add");
		return "adminAutorAddEdit";
	}
	
	@PostMapping("/addConfirmation")
	public String addNewAutorConfirmation(@ModelAttribute Autor autor, @ModelAttribute("action") String action, @RequestParam("fileToUpload") MultipartFile  uploadFile, Model model) {
		autorenService.processAddUpdate(autor, action, uploadFile);
		return "adminAutorAdded";
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editAutor(@PathVariable Long id, Model model) {
		model.addAttribute("autor",  autorenService.getAutorByID(id));
		model.addAttribute("action", "edit");
		return "adminAutorAddEdit";
	}


}