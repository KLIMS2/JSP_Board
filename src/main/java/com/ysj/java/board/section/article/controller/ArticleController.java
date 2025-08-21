package com.ysj.java.board.section.article.controller;

import com.ysj.java.board.global.common.contain.Container;
import com.ysj.java.board.global.process.Request;
import com.ysj.java.board.section.article.dto.Article;
import com.ysj.java.board.section.article.service.ArticleService;

import java.util.List;

import static com.ysj.java.board.global.common.object.Constant.ROUTING_NOTFOUND;

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
    rq.view("/usr/article/list");
  }

  public void showWrite(Request rq)
  {
    rq.view("/usr/article/write");
  }

  public void doWrite(Request rq)
  {
    String title = rq.getStringParam("title", "");
    String content = rq.getStringParam("content", "");

    Article newArticle = new Article(title, content);
    articleService.setArticle(newArticle);

    showList(rq);
  }

  public void showDetail(Request rq)
  {
    long id = rq.getLongParam("id", -1);

    if(id == -1)
    {
      rq.view(ROUTING_NOTFOUND);
      return;
    }

    Article article = articleService.getArticle(id);
    if(article == null)
    {
      rq.view(ROUTING_NOTFOUND);
      return;
    }

    rq.setAttr("article", article);
    rq.view("/usr/article/detail");
  }
}
