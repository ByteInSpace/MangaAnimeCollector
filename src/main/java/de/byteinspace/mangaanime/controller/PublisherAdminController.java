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

import de.byteinspace.mangaanime.entity.Publisher;
import de.byteinspace.mangaanime.service.PublisherService;

@Controller
@RequestMapping("/admin/publisher")
public class PublisherAdminController {
	
	
	@Autowired PublisherService publisherenService;


	@GetMapping("/")
	public String defaultPublisher(Model model) {
		return showAllPublishers(model);
	}
	
	@GetMapping("/show")
	public String showAllPublishers(Model model) {
		model.addAttribute("publishers", publisherenService.getAllPublishers());
		return "adminPublisherShowAll";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deletePublisherByID(@PathVariable Long id, Model model) {
		publisherenService.deletePublisherByID(id);
		return "adminPublisherDeleted";
	}
	
	@GetMapping("/add")
	public String addNewPublisher(Model model) {
		model.addAttribute("publisher",  new Publisher());
		model.addAttribute("action", "add");
		return "adminPublisherAddEdit";
	}
	
	@PostMapping("/addConfirmation")
	public String addNewPublisherConfirmation(@ModelAttribute Publisher publisher, @ModelAttribute("action") String action, @RequestParam("fileToUpload") MultipartFile  uploadFile, Model model) {
		publisherenService.processAddUpdate(publisher, action, uploadFile);
		return "adminPublisherAdded";
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editPublisher(@PathVariable Long id, Model model) {
		model.addAttribute("publisher",  publisherenService.getPublisherByID(id));
		model.addAttribute("action", "edit");
		return "adminPublisherAddEdit";
	}


}