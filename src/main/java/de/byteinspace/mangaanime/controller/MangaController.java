package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.entity.Manga;
import de.byteinspace.mangaanime.service.MangaService;

@Controller
@RequestMapping("/manga")
public class MangaController {

@Autowired MangaService mangaService;
	
	
	@GetMapping("/all")
	public Iterable<Manga> getAllManga() {
		return mangaService.getAllMangas();
	}
	
	@GetMapping("/")
	public String getAllMangaHome(Model model) {
		model.addAttribute("mangas", mangaService.getAllMangas());
		return "showAllManga";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showOneManga(@PathVariable Long id, Model model ) {
		model.addAttribute("manga", mangaService.getMangaByID(id));
		return "showDetailManga";
	}
	
	@GetMapping("/showall")
	public String showAllManga(Model model) {
		model.addAttribute("mangas", mangaService.getAllMangas());
		return "showAllManga";
	}


}
