package com.leysoft.project.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.leysoft.project.converter.imple.NoticiaConverter;
import com.leysoft.project.entity.Noticia;
import com.leysoft.project.model.ImagenModel;
import com.leysoft.project.service.inter.NoticiaService;
import com.leysoft.project.validator.ImagenValidator;

@Controller
public class HomeController {
	
	@Autowired @Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	@Autowired @Qualifier("noticiaConverter")
	NoticiaConverter noticiaConverter;
	
	@Autowired @Qualifier("imagenValidator")
	ImagenValidator imagenValidator;
	
	@InitBinder("imagen")
	protected void initBinderImagen(WebDataBinder binder) {
		binder.setValidator(imagenValidator);
	}
	
	@GetMapping(value = "/")
	public String noticia(Model model) {
		model.addAttribute("noticia", new Noticia());
		model.addAttribute("noticias", noticiaConverter.entityToModel(noticiaService.findAll()));
		return "home";
	}
	
	@PostMapping(value = "/")
	public String noticia(@Valid @ModelAttribute("noticia") Noticia noticia, 
			BindingResult result, Model model) {
		if(!result.hasErrors()) {
			noticiaService.save(noticia);
			return "redirect:/noticia/"+noticia.getId()+"/add-imagen";
		} else {
			model.addAttribute("noticias", noticiaConverter.entityToModel(noticiaService.findAll()));
			return "home";
		}
	}
	
	@GetMapping(value = "/noticia/{id}/add-imagen")
	public String noticiaAddImagen(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("noticia", noticiaService.findById(id));
		model.addAttribute("imagen", new ImagenModel());
		return "add_imagen";
	}
	
	@PostMapping(value = "/noticia/{id}/add-imagen")
	public String noticiaAddImagen(@Valid @ModelAttribute("imagen") ImagenModel imagen, BindingResult resutl,
			@PathVariable("id") Integer id, Model model) throws IOException {
		imagenValidator.validate(imagen, resutl);
		Noticia noticia = noticiaService.findById(id);
		if(!resutl.hasErrors()) {
			noticia.setImagen(imagen.getFile().getBytes());
			noticiaService.update(noticia);
			return "redirect:/";
		} else {
			model.addAttribute("noticia", noticia);
			return "add_imagen";
		}
	}
}