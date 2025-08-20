<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container">
    <h3 class="text">> 게시물 작성 <</h3>

    <form action="" target="_blank">
        <div class="form-content">
            <div class="text">
                <label for="title_input">제목</label>
            </div>
            <input type="text" name="title" id="title_input" placeholder="제목을 입력해주세요." required>

            <div class="text">
                <label for="content_textarea">내용</label>
            </div>
            <textarea name="content" id="content_textarea" placeholder="내용을 입력해주세요." cols="55" rows="20" required></textarea>

            <div class="text">
                <button type="submit">작성</button>
            </div>
        </div>
    </form>

    <div class="right-box">
        <a class="text" href="http://localhost:8080/">back</a>
    </div>
</div>

<style>
    body {
        margin: 0;
        padding: 0;
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

    .text {
        font-size: 200%;
    }

    button {
        font-size: 1.5rem;
    }

    input {
        width: 25rem;
        height: 2rem;
    }

    a {
        display: inline-block;
        margin-top: 10px;
        font-size: 1.5rem;
    }

    h1 {
        margin-bottom: 5px;
    }

    form {
        text-align: start;
    }

    .form-content {
        margin-left: 16px;
    }

    input {
        margin-bottom: 16px;
    }

    textarea {
        margin-bottom: 16px;
    }
</style>