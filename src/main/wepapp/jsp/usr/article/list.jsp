<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container">
    <h3 class="text">> 게시물 리스트 <</h3>
    <h4 class="text">(id | title)</h4>

    <c:forEach var="article" items="${articles}">
        <div class="text">
            <span>${article.getId()}: </span>
            <span>${article.getTitle()}</span>
        </div>
    </c:forEach>

    <div class="right-box">
        <a class="text" href="http://localhost:8080/">back</a>
    </div>
</div>

<style>
    body {
        margin: 0;
        padding: 0;
    }

    h3 {
        margin: 5px;
    }

    h4 {
        margin: 5px;
        margin-left: 0px;
    }

    span {
        margin-left: 7px;
        margin-right: 3px;
    }

    a {
        display: inline-block;
        margin-top: 10px;
        font-size: 1.5rem;
    }

    .container {
        width: 50vw;
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
</style>