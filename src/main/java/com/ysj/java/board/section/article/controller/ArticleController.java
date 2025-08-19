package com.ysj.java.board.section.article.controller;

import com.ysj.java.board.global.common.contain.Container;
import com.ysj.java.board.global.process.Request;
import com.ysj.java.board.section.article.dto.Article;
import com.ysj.java.board.section.article.service.ArticleService;

import java.util.List;

public class ArticleController
{
  private ArticleService articleService;

  public ArticleController()
  {
    articleService = Container.articleService;
  }

  public void showList(Request rq)
  {
    List<Article> articles = articleService.getArticles();
    articles = rq.reverseList(articles);
    rq.setAttr("articles", articles);
    rq.view(rq.getUrlPath());
  }
}
