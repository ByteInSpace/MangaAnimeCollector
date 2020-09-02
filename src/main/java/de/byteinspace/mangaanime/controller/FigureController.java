package de.byteinspace.mangaanime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.byteinspace.mangaanime.entity.Figure;
import de.byteinspace.mangaanime.service.FigureService;

@Controller
@RequestMapping("/figure")
public class FigureController {
	
@Autowired FigureService figureService;
	
	
	@GetMapping("/all")
	public Iterable<Figure> getAllFigures() {
		return figureService.getAllFigures();
	}
	
	@GetMapping("/")
	public String getAllFiguresHome(Model model) {
		model.addAttribute("figures", figureService.getAllFigures());
		return "showAllFigures";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showOneFigure(@PathVariable Long id, Model model ) {
		model.addAttribute("figure", figureService.getFigureByID(id));
		return "showDetailFigure";
	}
	
	@GetMapping("/showall")
	public String showAllFigures(Model model) {
		model.addAttribute("figures", figureService.getAllFigures());
		return "showAllFigures";
	}


}
