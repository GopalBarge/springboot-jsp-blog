package com.ems.main.service;

import java.util.List;

import com.ems.main.dto.ArticleDTO;

public interface ArticleService {

	public void createOrUpdateArticle(ArticleDTO empDTO);
	
	public List<ArticleDTO> getAllArticle();
	
	public void deleteArticle(Long id);
	
	public ArticleDTO editArticle(Long id);
	
}
