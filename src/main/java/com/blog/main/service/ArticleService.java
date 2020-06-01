package com.blog.main.service;

import java.util.List;

import com.blog.main.dto.ArticleDTO;

public interface ArticleService {

	public void createOrUpdateArticle(ArticleDTO empDTO);
	
	public List<ArticleDTO> getAllArticle();
	
	public void deleteArticle(Long id);
	
	public ArticleDTO editArticle(Long id);
	
}
