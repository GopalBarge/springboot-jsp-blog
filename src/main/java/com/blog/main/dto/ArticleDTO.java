package com.blog.main.dto;

import com.blog.main.model.Article;

import java.sql.Timestamp;

public class ArticleDTO {

    Long articleId;
    String autherName;

    String description;

    Timestamp created;
    Long viewCount;

    public ArticleDTO() {
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public ArticleDTO(Article article) {
        this.created = article.getCreated();
        this.viewCount = article.getViewCount();
        this.articleId = article.getArticleId();
        this.autherName = article.getAutherName();
        this.description = article.getDescription();
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
