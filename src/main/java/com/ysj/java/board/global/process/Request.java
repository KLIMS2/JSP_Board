package com.ysj.java.board.global.process;

import com.ysj.java.board.global.utility.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
    String urlPath = req.getRequestURI();
    String[] urlPathBits = urlPath.trim().split("/");

    if(urlPathBits.length <= 4)
    {
      return urlPath;
    }

    if(urlPathBits[4].equals("free"))
    {
      return "/%s/%s/%s".formatted(urlPathBits[1], urlPathBits[2], urlPathBits[3]);
    }

    return urlPath;
  }

  public <T> List<T> reverseList(List<T> list)
  {
    return Util.reverseList(list);
  }

  public String getMethod()
  {
    String method = getStringParam("_method", "");
    if(method.isEmpty())
    {
      return req.getMethod();
    }

    return method.toUpperCase();
  }

  public long getLongPathValue(int index, long defaultValue)
  {
    String[] urlPathBits = req.getRequestURI().trim().split("/");
    long pathVariable;

    try
    {
      pathVariable = Long.parseLong(urlPathBits[4 + index]);
    }
    catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
    {
      return defaultValue;
    }

    return pathVariable;
  }

  public void println(String html)
  {
    print(html + "\n");
  }

  public void historyBack()
  {
    println("""
        <script>
            history.back();
        </script>
        """);
  }

  public void historyBack(String msg)
  {
    println("""
        <script>
            alert("%s");
            history.back();
        </script>
        """.formatted(msg));
  }

  public void replace(String url)
  {
    println("""
        <script>
            location.replace("%s");
        </script>
        """.formatted(url));
  }

  public void replace(String url, String msg)
  {
    println("""
        <script>
            alert("%s");
            location.replace("%s");
        </script>
        """.formatted(msg, url));
  }
}
