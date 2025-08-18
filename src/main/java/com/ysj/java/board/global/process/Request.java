package com.ysj.java.board.global.process;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Request
{
  private HttpServletRequest req;
  private HttpServletResponse resp;

  public Request(HttpServletRequest req, HttpServletResponse resp)
  {
    this.req = req;
    this.resp = resp;
  }

  public long getLongParam(String key, long defaultValue)
  {
    long param;

    try
    {
      param = Long.parseLong(req.getParameter(key));
    }
    catch (NumberFormatException e)
    {
      return defaultValue;
    }

    return param;
  }

  public int getIntParam(String key, int defaultValue)
  {
    int param;

    try
    {
      param = Integer.parseInt(req.getParameter(key));
    }
    catch (NumberFormatException e)
    {
      return defaultValue;
    }

    return param;
  }

  public String getStringParam(String key, String defaultValue)
  {
    String param = req.getParameter(key);

    if(param == null || param.isEmpty())
    {
      return defaultValue;
    }

    return param;
  }

  public void settingKorean()
  {
    try
    {
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html; charset=utf-8");
    }
    catch (UnsupportedEncodingException e)
    {
      throw new RuntimeException(e);
    }
  }

  public void setAttr(String key, Object value)
  {
    req.setAttribute(key, value);
  }

  public Object getAttr(String key)
  {
    return req.getAttribute(key);
  }

  public void print(String html)
  {
    try
    {
      resp.getWriter().append(html);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public void view(String path)
  {
    path = "/jsp" + path; path += ".jsp";

    try
    {
      req.getRequestDispatcher(path).forward(req, resp);
    }
    catch (ServletException | IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public String getUrlPath()
  {
    return req.getRequestURI();
  }
}
