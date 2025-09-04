<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/jsp/global/common/head.jspf"%>

<section class="main-section flex-1 flex flex-col">
    <div class="container mx-auto flex-1 flex flex-col items-center justify-center">
        <h1 class="text-4xl font-bold">JSP_Board Test site</h1>
        <p class="mt-3">

            <a class="_text" href="http://localhost:8080/usr/article/list">게시물 리스트</a>
            <a class="_text" href="http://localhost:8080/usr/article/write">게시물 작성</a>

        </p>
    </div>
</section>

<style>
    a {
        display: block;
    }

    ._text {
        font-size: 200%;
    }

    a:hover {
        color: red;
    }
</style>

<%@ include file="/jsp/global/common/foot.jspf"%>