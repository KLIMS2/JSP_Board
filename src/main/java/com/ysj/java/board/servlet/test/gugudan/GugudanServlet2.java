package com.ysj.java.board.servlet.test.gugudan;

import com.ysj.java.board.global.process.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet2 extends HttpServlet
{
  public void doGet(Request rq)
  {
    int dan = rq.getIntParam("dan", 2);
    rq.setAttr("dan", dan);
    rq.view("/test/gugudan.jsp");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Request rq = new Request(req, resp);
    rq.settingKorean();
    doGet(rq);
  }
}
