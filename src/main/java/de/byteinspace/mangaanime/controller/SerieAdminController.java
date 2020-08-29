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

import de.byteinspace.mangaanime.entity.Serie;
import de.byteinspace.mangaanime.service.SerieService;

@Controller
@RequestMapping("/admin/serie")
public class SerieAdminController {


	
	@Autowired SerieService serienService;
	
	
	@GetMapping("/")
	public String defaultSerie(Model model) {
		return showAllSeries(model);
	}
	
	@GetMapping("/show")
	public String showAllSeries(Model model) {
		model.addAttribute("series", serienService.getAllSeries());
		return "adminSerieShowAll";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteSerieByID(@PathVariable Long id, Model model) {
		serienService.deleteSerieByID(id);
		return "adminSerieDeleted";
	}
	
	@GetMapping("/add")
	public String addNewSerie(Model model) {
		model.addAttribute("serie",  new Serie());
		model.addAttribute("action", "add");
		return "adminSerieAddEdit";
	}
	
	@PostMapping("/addConfirmation")
	public String addNewSerieConfirmation(@ModelAttribute Serie serie, @ModelAttribute("action") String action, @RequestParam("fileToUpload") MultipartFile  uploadFile, Model model) {
		serienService.processAddUpdate(serie, action, uploadFile);
		return "adminSerieAdded";
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editSerie(@PathVariable Long id, Model model) {
		model.addAttribute("serie",  serienService.findSerieByID(id));
		model.addAttribute("action", "edit");
		return "adminSerieAddEdit";
	}
	
	
}
