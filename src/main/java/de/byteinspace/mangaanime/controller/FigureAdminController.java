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

import de.byteinspace.mangaanime.entity.Figure;
import de.byteinspace.mangaanime.service.FigureService;
import de.byteinspace.mangaanime.service.PublisherService;
import de.byteinspace.mangaanime.service.SerieService;

@Controller
@RequestMapping("/admin/figure")
public class FigureAdminController {

	@Autowired FigureService figureService;
	@Autowired SerieService serieService;
	@Autowired PublisherService publisherService;
	
	
	@GetMapping("/")
	public String showCreateFiguresForm(Model model) {
		model.addAttribute("figures", figureService.getAllFigures());
		return "adminFigureShowAll";
	}
	
	@GetMapping("/showall")
	public String showAllFigures(Model model) {
		model.addAttribute("figures", figureService.getAllFigures());
		return "adminFigureShowAll";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteFigureByID(@PathVariable Long id, Model model) {
		figureService.deleteFigureByID(id);
		return "adminFigureDeleted";
	}
	
	@GetMapping("/addNewFigure")
	public String addNewFigure(Model model) {
		model.addAttribute("figure",  new Figure());
		model.addAttribute("series", serieService.getAllSeries() );
		model.addAttribute("publishers", publisherService.getAllPublishers() );
		return "adminFigureAddEdit";
	}
	
	@PostMapping("/addNewFigureConfirmation")
	public String addNewFigureConfirmation(@ModelAttribute Figure figure, @ModelAttribute("action") String action, @RequestParam("fileToUpload") MultipartFile  uploadFile, Model model) {
		figureService.processAddUpdate(figure, action, uploadFile);
		return "adminFigureAdded";
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editSerie(@PathVariable Long id, Model model) {
		model.addAttribute("figure",  figureService.getFigureByID(id));
		model.addAttribute("series", serieService.getAllSeries() );
		model.addAttribute("publishers", publisherService.getAllPublishers() );
		model.addAttribute("action", "edit");
		return "adminFigureAddEdit";
	}
}