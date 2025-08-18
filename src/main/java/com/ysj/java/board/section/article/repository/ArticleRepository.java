package com.ysj.java.board.section.article.repository;

import com.ysj.java.board.section.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository
{
  private List<Article> articles;

  public ArticleRepository()
  {
    articles = new ArrayList<>();
    makeTestData(10); //
  }

  private void makeTestData(int count)
  {
    IntStream.rangeClosed(1, count).forEach(a -> {
      articles.add(new Article("title" + a, "content" + a));
    });
  }

  public List<Article> getArticles()
  {
    return articles;
  }
}
