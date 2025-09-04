<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="pageTitle" value="게시물 상세 보기" />

<%@ include file="/jsp/global/common/head.jspf"%>

<section class="main-section flex-1 flex flex-col">
    <div class="container mx-auto flex-1 flex flex-col items-center justify-center">
        <h1 class="text-4xl font-bold">> 게시물 상세보기 <</h1>

        <div class="_left-box text">
            <div class="_text">
                <span>id: </span>
                ${article.getId()}
            </div>
            <div class="_text">
                <span>title: </span>
                ${article.getTitle()}
            </div>
            <div class="_text">
                <span>content: </span>
                ${article.getContent()}
            </div>
        </div>

        <ul class="mx-auto flex gap-x-10">
            <li><a class="btn" href="/usr/article/modify/free/${article.getId()}">수정</a></li>
            <li><a class="btn" href="/usr/article/delete/free/${article.getId()}?_method=delete" onclick="if(!confirm('삭제하시겠습니까?')) return false;">삭제</a></li>
        </ul>

        <div class="_right-box">
            <a class="_text" href="/usr/article/list">back</a>
        </div>
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

    a {
        display: inline-block;
        margin-top: 10px;
        font-size: 1.5rem;
    }

    ._right-box {
        text-align: right;
        margin-right: 10px;
    }

    ._left-box {
        text-align: start;
        background-color: white;
        border: solid black 4px;
    }

    ._left-box > * {
        border: solid gray 2px;
        width: 100% - 4px;
        height: 3rem;
        overflow-wrap: break-word;
        overflow-y: auto;
    }

    ._left-box > *:last-child {
        height: 24rem;
    }

    span {
        color: green;
    }

    a:hover {
        color: red;
    }
</style>

<%@ include file="/jsp/global/common/foot.jspf"%>