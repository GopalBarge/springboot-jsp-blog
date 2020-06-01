package com.blog.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.blog.main.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.main.dto.ArticleDTO;
import com.blog.main.repository.ArticleRepository;
import com.blog.main.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	public void createOrUpdateArticle(ArticleDTO empDto) {
		Article emp = convertDtoToModel(empDto);
		articleRepository.save(emp);
	}
	
	public List<ArticleDTO> getAllArticle() {
		List<Article> list = articleRepository.findAll();
		List<ArticleDTO>articleList = list.stream()
	            .map(ArticleDTO::new)
	            .collect(Collectors.toCollection(ArrayList::new));
		return articleList;
	}
	
	public void deleteArticle(Long id) {
		Article emp = articleRepository.getOne(id);
		articleRepository.delete(emp);
	}
	
	public ArticleDTO editArticle(Long id) {
		Article emp = articleRepository.getOne(id);
		emp.setViewCount((emp.getViewCount()==null?0:emp.getViewCount()) + 1);
		articleRepository.save(emp);
		return convertModelToDTO(emp);
	}
	
	private Article convertDtoToModel(ArticleDTO empDto) {
		Article emp = new Article();
		if (empDto.getArticleId() != null) {
			emp.setArticleId(empDto.getArticleId());
		}
		emp.setAutherName(empDto.getAutherName());
		emp.setDescription(empDto.getDescription());
		emp.setTitle(empDto.getTitle());
		emp.setViewCount(empDto.getViewCount());
		return emp;
	}
	
	private ArticleDTO convertModelToDTO(Article emp) {
		ArticleDTO empDTO = new ArticleDTO();
		empDTO.setArticleId(emp.getArticleId());
		empDTO.setAutherName(emp.getAutherName());
		empDTO.setDescription(emp.getDescription());
		empDTO.setViewCount(emp.getViewCount());
		empDTO.setTitle(emp.getTitle());
		return empDTO;
	}

}
