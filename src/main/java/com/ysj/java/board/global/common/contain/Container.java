package com.ysj.java.board.global.common.contain;

import com.ysj.java.board.section.article.controller.ArticleController;
import com.ysj.java.board.section.article.repository.ArticleRepository;
import com.ysj.java.board.section.article.service.ArticleService;

public class Container
{
  public static ArticleRepository articleRepository;
  public static ArticleService articleService;
  public static ArticleController articleController;

  static
  {
    articleRepository = new ArticleRepository();
    articleService = new ArticleService();
    articleController = new ArticleController();
  }
}
