<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="pageTitle" value="게시물 리스트" />

<%@ include file="/jsp/global/common/head.jspf"%>

<section class="main-section flex-1 flex flex-col">
    <div class="container mx-auto flex-1 flex flex-col items-center justify-center">
        <h1 class="text-4xl font-bold">> 게시물 리스트 <</h1>
        <h2 class="text-4xl font-bold">(id | title)</h2>
        <p class="mt-3">

            <table class="_text">
                <colgroup>
                    <col width="80px">
                    <col width="320px">
                </colgroup>
                <thead>
                <tr>
                    <th>
                        <span>id</span>
                    </th>
                    <th>
                        <span>title</span>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="article" items="${articles}">
                    <tr>
                        <td>
                            <a href="/usr/article/detail/free/${article.getId()}">
                                ${article.getId()}
                            </a>
                        </td>
                        <td>${article.getTitle()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="_right-box">
                <a class="_text" href="http://localhost:8080/">back</a>
            </div>

        </p>
    </div>
</section>

<style>
    body {
        margin: 0;
        padding: 0;
    }

    ._text {
        font-size: 200%;
    }

    ._right-box > a {
        display: inline-block;
        margin-top: 10px;
    }

    ._right-box {
        text-align: right;
        margin-right: 10px;
    }

    table {
        border-collapse: collapse;
        margin-left: auto;
        margin-right: auto;
        background-color: white;
        text-align: center;
    }

    table a {
        display: block;
        text-decoration: none;
    }

    a:hover {
        color: red;
    }

    span {
        color: green;
    }
</style>

<%@ include file="/jsp/global/common/foot.jspf"%>