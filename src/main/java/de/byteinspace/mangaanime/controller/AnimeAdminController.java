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

import de.byteinspace.mangaanime.entity.Anime;
import de.byteinspace.mangaanime.service.AnimeService;
import de.byteinspace.mangaanime.service.AutorService;
import de.byteinspace.mangaanime.service.SerieService;

@Controller
@RequestMapping("/admin/anime")
public class AnimeAdminController {

	@Autowired AnimeService animeService;
	@Autowired SerieService serieService;
	@Autowired AutorService autorService;
	
	
	@GetMapping("/")
	public String showCreateAnimesForm(Model model) {
		model.addAttribute("animes", animeService.getAllAnimes());
		return "adminAnimeShowAll";
	}
	
	@GetMapping("/showall")
	public String showAllAnimes(Model model) {
		model.addAttribute("animes", animeService.getAllAnimes());
		return "adminAnimeShowAll";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteAnimeByID(@PathVariable Long id, Model model) {
		animeService.deleteAnimeByID(id);
		return "adminAnimeDeleted";
	}
	
	@GetMapping("/addNewAnime")
	public String addNewAnime(Model model) {
		model.addAttribute("anime",  new Anime());
		model.addAttribute("series", serieService.getAllSeries() );
		model.addAttribute("autors", autorService.getAllAutors());
		return "adminAnimeAddEdit";
	}
	
	@PostMapping("/addNewAnimeConfirmation")
	public String addNewAnimeConfirmation(@ModelAttribute Anime anime, @ModelAttribute("action") String action, @RequestParam("fileToUpload") MultipartFile  uploadFile, Model model) {
		animeService.processAddUpdate(anime, action, uploadFile);
		return "adminAnimeAdded";
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editSerie(@PathVariable Long id, Model model) {
		model.addAttribute("anime",  animeService.getAnimeByID(id));
		model.addAttribute("series", serieService.getAllSeries() );
		model.addAttribute("autors", autorService.getAllAutors());
		model.addAttribute("action", "edit");
		return "adminAnimeAddEdit";
	}
}