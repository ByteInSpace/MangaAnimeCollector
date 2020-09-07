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

import de.byteinspace.mangaanime.entity.Manga;
import de.byteinspace.mangaanime.service.AutorService;
import de.byteinspace.mangaanime.service.LanguageService;
import de.byteinspace.mangaanime.service.MangaService;
import de.byteinspace.mangaanime.service.PublisherService;
import de.byteinspace.mangaanime.service.SerieService;

@Controller
@RequestMapping("/admin/manga")
public class MangaAdminController {
	
	@Autowired MangaService mangaService;
	@Autowired SerieService serieService;
	@Autowired AutorService autorService;
	@Autowired LanguageService languageService;
	@Autowired PublisherService publisherService;
	
	
	@GetMapping("/")
	public String showCreateMangasForm(Model model) {
		model.addAttribute("mangas", mangaService.getAllMangas());
		return "adminMangaShowAll";
	}
	
	@GetMapping("/showall")
	public String showAllMangas(Model model) {
		model.addAttribute("mangas", mangaService.getAllMangas());
		return "adminMangaShowAll";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteMangaByID(@PathVariable Long id, Model model) {
		mangaService.deleteMangaByID(id);
		return "adminMangaDeleted";
	}
	
	@GetMapping("/addNewManga")
	public String addNewManga(Model model) {
		model.addAttribute("manga",  new Manga());
		model.addAttribute("series", serieService.getAllSeries() );
		model.addAttribute("autors", autorService.getAllAutors());
		model.addAttribute("languages", languageService.getAllLanguages());
		model.addAttribute("publishers", publisherService.getAllPublishers());
		return "adminMangaAddEdit";
	}
	
	@PostMapping("/addNewMangaConfirmation")
	public String addNewMangaConfirmation(@ModelAttribute Manga manga, @ModelAttribute("action") String action, @RequestParam("fileToUpload") MultipartFile  uploadFile, Model model) {
		mangaService.processAddUpdate(manga, action, uploadFile);
		return "adminMangaAdded";
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editSerie(@PathVariable Long id, Model model) {
		model.addAttribute("manga",  mangaService.getMangaByID(id));
		model.addAttribute("series", serieService.getAllSeries() );
		model.addAttribute("autors", autorService.getAllAutors());
		model.addAttribute("languages", languageService.getAllLanguages());
		model.addAttribute("publishers", publisherService.getAllPublishers());
		model.addAttribute("action", "edit");
		return "adminMangaAddEdit";
	}
}