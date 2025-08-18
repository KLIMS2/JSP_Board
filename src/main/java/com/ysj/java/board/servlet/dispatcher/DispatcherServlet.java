package com.ysj.java.board.servlet.dispatcher;

import com.ysj.java.board.global.common.contain.Container;
import com.ysj.java.board.global.process.Request;
import com.ysj.java.board.section.article.controller.ArticleController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet
{
  public void doGet(Request rq)
  {
    String urlPath = rq.getUrlPath();

    if(urlPath.startsWith("/usr/article"))
    {
      ArticleController articleController = Container.articleController;

      switch (urlPath)
      {
        case "/usr/article/list" -> articleController.showList(rq);
      }
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Request rq = new Request(req, resp);
    rq.settingKorean();
    doGet(rq);
  }
}
