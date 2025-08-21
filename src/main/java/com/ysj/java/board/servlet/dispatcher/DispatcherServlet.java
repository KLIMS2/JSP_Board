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

import static com.ysj.java.board.global.common.object.Constant.ROUTING_NOTFOUND;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet
{
  public void run(Request rq)
  {
    String urlPath = rq.getUrlPath();
    String urlMethod = rq.getMethod();

    if(urlPath.startsWith("/usr/article"))
    {
      ArticleController articleController = Container.articleController;

      switch(urlMethod)
      {
        case "GET":
          switch (urlPath)
          {
            case "/usr/article/list" -> articleController.showList(rq);
            case "/usr/article/write" -> articleController.showWrite(rq);
            case "/usr/article/detail" -> articleController.showDetail(rq);
          }
          break;

        case "POST":
          switch (urlPath)
          {
            case "/usr/article/write" -> articleController.doWrite(rq);
          }
          break;
      }
    }
    else
    {
      rq.view(ROUTING_NOTFOUND);
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Request rq = new Request(req, resp);
    rq.settingKorean();
    run(rq);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Request rq = new Request(req, resp);
    rq.settingKorean();
    run(rq);
  }
}
