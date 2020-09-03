package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.entity.Anime;
import de.byteinspace.mangaanime.service.AnimeService;

@Controller
@RequestMapping("/anime")
public class AnimeController {

@Autowired AnimeService animeService;
	
	
	@GetMapping("/all")
	public Iterable<Anime> getAllAnimes() {
		return animeService.getAllAnimes();
	}
	
	@GetMapping("/")
	public String getAllAnimesHome(Model model) {
		model.addAttribute("animes", animeService.getAllAnimes());
		return "showAllAnimes";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showOneAnime(@PathVariable Long id, Model model ) {
		model.addAttribute("anime", animeService.getAnimeByID(id));
		return "showDetailAnime";
	}
	
	@GetMapping("/showall")
	public String showAllAnimes(Model model) {
		model.addAttribute("animes", animeService.getAllAnimes());
		return "showAllAnimes";
	}


}

