package com.ysj.java.board.section.article.controller;

import com.ysj.java.board.global.common.contain.Container;
import com.ysj.java.board.global.process.Request;
import com.ysj.java.board.section.article.dto.Article;
import com.ysj.java.board.section.article.service.ArticleService;

import javax.smartcardio.ATR;
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
    String title = rq.getStringParam("title", "").trim();
    String content = rq.getStringParam("content", "").trim();

    if(title.isEmpty())
    {
      rq.historyBack("제목을 입력해주세요.");
      return;
    }

    if(content.isEmpty())
    {
      rq.historyBack("내용을 입력해주세요.");
      return;
    }

    Article newArticle = new Article(title, content);
    articleService.setArticle(newArticle);

    rq.replace("/usr/article/list", "%d번 게시물이 생성되었습니다.".formatted(newArticle.getId()));
  }

  public void showDetail(Request rq)
  {
    long id = rq.getLongPathValue(1, -1);

    if(id == -1)
    {
      rq.historyBack("게시물 번호를 제대로 입력해 주세요.");
      return;
    }

    Article article = articleService.getArticle(id);
    if(article == null)
    {
      rq.historyBack("%d번 게시물은 존재하지 않습니다.".formatted(article.getId()));
      return;
    }

    rq.setAttr("article", article);
    rq.view("/usr/article/detail");
  }

  public void showModify(Request rq)
  {
    long id = rq.getLongPathValue(1, -1);
    if(id == -1)
    {
      rq.historyBack("게시물 번호를 제대로 입력해 주세요.");
      return;
    }

    Article article = articleService.getArticle(id);
    if(article == null)
    {
      rq.historyBack("게시물이 존재하지 않습니다.");
      return;
    }

    rq.setAttr("article", article);
    rq.view("/usr/article/modify");
  }

  public void doModify(Request rq)
  {
    long id = rq.getLongPathValue(1, -1);
    String title = rq.getStringParam("title", "");
    String content = rq.getStringParam("content", "");

    if(title.isEmpty())
    {
      rq.historyBack("제목을 입력해주세요.");
      return;
    }

    if(content.isEmpty())
    {
      rq.historyBack("내용을 입력해주세요.");
      return;
    }

    Article article = articleService.getArticle(id);
    article.setTitle(title);
    article.setContent(content);
    articleService.updateArticle(article);

    rq.replace("/usr/article/detail/free/%d".formatted(id), "%d번 게시물이 수정되었습니다.".formatted(id));
  }

  public void doDelete(Request rq)
  {
    long id = rq.getLongPathValue(1, -1);
    if(id == -1)
    {
      rq.historyBack("게시물 번호를 제대로 입력해 주세요.");
      return;
    }

    Article article = articleService.getArticle(id);
    if(article == null)
    {
      rq.historyBack("게시물이 존재하지 않습니다.");
      return;
    }

    articleService.deleteArticle(article);

    rq.replace("/usr/article/list", "%d번 게시물이 삭제되었습니다.".formatted(id));
  }
}
