package com.ysj.java.board.section.article.service;

import com.ysj.java.board.global.common.contain.Container;
import com.ysj.java.board.section.article.dto.Article;
import com.ysj.java.board.section.article.repository.ArticleRepository;

import java.util.List;

public class ArticleService
{
  private ArticleRepository articleRepository;

  public ArticleService()
  {
    articleRepository = Container.articleRepository;
  }

  public List<Article> getArticles()
  {
    return articleRepository.getArticles();
  }

  public void setArticle(Article article)
  {
    articleRepository.setArticle(article);
  }

  public Article getArticle(long id)
  {
    return articleRepository.getArticle(id);
  }

  public void updateArticle(Article article)
  {
    articleRepository.updateArticle(article);
  }

  public void deleteArticle(Article article)
  {
    articleRepository.deleteArticle(article);
  }
}
