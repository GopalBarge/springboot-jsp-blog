package com.ems.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.main.dto.ArticleDTO;
import com.ems.main.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/add")
	public String reg(Map<String, Object> model) {
		model.put("article", new ArticleDTO());
		return "Article";
	}
	
	@PostMapping("/home")
	public String createArticle(@ModelAttribute("employee") ArticleDTO empDto) {
		articleService.createOrUpdateArticle(empDto);
		return "redirect:/list";	
	}
	
	@GetMapping("/list")
	public String listOfArticle(Model model) {
		List<ArticleDTO> employeeList = articleService.getAllArticle();
		model.addAttribute("empList", employeeList);
		return "articleList";
	}
	
	@PostMapping("/delete")
	public String deleteArticle(@RequestParam("id") String id) {
		articleService.deleteArticle(Long.parseLong(id));
		return "redirect:/list";		
	}
	
	@GetMapping("/edit")
	public String editArticle(@RequestParam("id") String id, Map<String, Object> model) {
		ArticleDTO empDTO = articleService.editArticle(Long.parseLong(id));
		model.put("article", empDTO);
		return "Article";
	}
	
}
