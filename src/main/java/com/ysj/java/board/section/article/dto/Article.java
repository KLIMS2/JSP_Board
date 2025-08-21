package com.ysj.java.board.section.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article
{
  private static long lastId;
  private long id;
  private String title;
  private String content;

  static
  {
    lastId = 0L;
  }

  public Article(String title, String content)
  {
    this(++lastId, title, content);
  }
}
