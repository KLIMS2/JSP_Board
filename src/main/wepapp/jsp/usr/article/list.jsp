<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<title>게시물 리스트</title>

<div class="container">
    <h3 class="text">> 게시물 리스트 <</h3>
    <h4 class="text">(id | title)</h4>

    <table class="text" border="1">
        <colgroup>
            <col width="80px">
            <col width="320px">
        </colgroup>
        <thead>
            <tr>
                <th>id</th>
                <th>title</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="article" items="${articles}">
                <tr>
                    <td>
                        <a href="/usr/article/detail?id=${article.getId()}">
                            ${article.getId()}
                        </a>
                    </td>
                    <td>${article.getTitle()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="right-box">
        <a class="text" href="http://localhost:8080/">back</a>
    </div>
</div>

<style>
    body {
        margin: 0;
        padding: 0;
    }

    .text {
        font-size: 200%;
    }

    h3 {
        margin-bottom: 5px;
    }

    h4 {
        margin: 5px;
        margin-left: 0px;
    }

    .right-box > a {
        display: inline-block;
        margin-top: 10px;
    }

    .container {
        width: 66vw;
        height: 100vh;
        margin-left: auto;
        margin-right: auto;
        background-color: lightgray;
        text-align: center;
    }

    .right-box {
        text-align: right;
        margin-right: 10px;
    }

    table {
        border-collapse: collapse;
        margin-left: auto;
        margin-right: auto;
        background-color: white;
    }

    table a {
        display: block;
        text-decoration: none;
    }
</style>