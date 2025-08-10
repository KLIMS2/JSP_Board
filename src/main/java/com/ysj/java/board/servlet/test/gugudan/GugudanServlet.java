package com.ysj.java.board.servlet.test.gugudan;

import com.ysj.java.board.global.process.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudanTest")
public class GugudanServlet extends HttpServlet
{
  public void doGet(Request rq)
  {
    int dan = rq.getIntParam("dan", 2);

    rq.print("<h3>--> %d단 <--</h3>\n".formatted(dan));
    for(int a = 1; a <= 9; a++)
    {
      rq.print("<div>%d * %d = %d</div>\n".formatted(dan, a, dan * a));
    }

    rq.print("<a href=\"http://localhost:8080/\">back</a>\n");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Request rq = new Request(req, resp);
    rq.settingKorean();
    doGet(rq);
  }
}
