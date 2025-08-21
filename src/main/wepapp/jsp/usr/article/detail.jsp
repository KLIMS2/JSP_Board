<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<title>게시물 상세보기</title>

<div class="container">
    <h3 class="text">> 게시물 상세보기 <</h3>

    <div class="left-box text">
        <div>
            <span>id: </span>
            ${article.getId()}
        </div>
        <div>
            <span>title: </span>
            ${article.getTitle()}
        </div>
        <div>
            <span>content: </span>
            ${article.getContent()}
        </div>
    </div>

    <div class="right-box">
        <a class="text" href="/usr/article/list">back</a>
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
        margin-bottom: 3rem;
    }

    a {
        display: inline-block;
        margin-top: 10px;
        font-size: 1.5rem;
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

    .left-box {
        text-align: start;
        background-color: white;
        border: solid black 4px;
    }

    .left-box > * {
        border: solid gray 2px;
        width: 100% - 4px;
        height: 3rem;
        overflow-wrap: break-word;
        overflow-y: auto;
    }

    .left-box > *:last-child {
        height: 24rem;
    }

    span {
        color: green;
    }
</style>