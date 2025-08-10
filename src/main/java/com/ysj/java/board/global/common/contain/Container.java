package com.ysj.java.board.global.common.contain;

import com.ysj.java.board.section.article.controller.ArticleController;

public class Container
{
  public static ArticleController articleController;

  static
  {
    articleController = new ArticleController();
  }
}
