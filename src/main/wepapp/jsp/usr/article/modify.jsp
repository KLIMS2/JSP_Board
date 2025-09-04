<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="pageTitle" value="게시물 수정" />

<%@ include file="/jsp/global/common/head.jspf"%>

<section class="main-section flex-1 flex flex-col">
    <div class="container mx-auto flex-1 flex flex-col items-center justify-center">
        <h1 class="text-4xl font-bold">> 게시물 수정 <</h1>

        <form action="/usr/article/modify/free/${article.getId()}" method="post">
            <div>
                <label for="title">제목</label>
            </div>
            <div>
                <input type="text" id="title" name="title" placeholder="제목을 입력해주세요." value="${article.getTitle()}">
            </div>

            <div>
                <label for="content">내용</label>
            </div>
            <div>
                <textarea id="content" name="content" placeholder="내용을 입력해주세요.">${article.getContent()}</textarea>
            </div>

            <div>
                <button type="submit">제출</button>
            </div>
        </form>

        <div class="_right-box">
            <a class="_text" href="/usr/article/detail/free/${article.getId()}">back</a>
        </div>
    </div>
</section>

<%@ include file="/jsp/global/common/foot.jspf"%>