<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="pageTitle" value="게시물 작성" />

<%@ include file="/jsp/global/common/head.jspf"%>

<section class="main-section flex-1 flex flex-col">
    <div class="container mx-auto flex-1 flex flex-col items-center justify-center">
        <h1 class="text-4xl font-bold">> 게시물 작성 <</h1>
        <p class="mt-3">

            <form action="/usr/article/write" method="post">
                <div class="_form-content">
                    <div class="_text">
                        <label for="title_input">제목</label>
                    </div>
                    <input type="text" name="title" id="title_input" placeholder="제목을 입력해주세요.">

                    <div class="_text">
                        <label for="content_textarea">내용</label>
                    </div>
                    <textarea name="content" id="content_textarea" placeholder="내용을 입력해주세요." cols="55" rows="20"></textarea>

                    <div class="_text">
                        <button type="submit">작성</button>
                    </div>
                </div>
            </form>

            <div class="_right-box">
                <a class="_text" href="http://localhost:8080/">back</a>
            </div>

        </p>
    </div>
</section>

<!--<script>-->
<!--    function writeFormCheck(form)-->
<!--    {-->
<!--        form.title.value = form.title.value.trim();-->
<!--        if(form.title.value.length == 0)-->
<!--        {-->
<!--            alert(form.title.placeholder);-->
<!--            return;-->
<!--        }-->

<!--        form.content.value = form.content.value.trim();-->
<!--        if(form.content.value.length == 0)-->
<!--        {-->
<!--            alert(form.content.placeholder);-->
<!--            return;-->
<!--        }-->

<!--        form.submit();-->
<!--    }-->
<!--</script>-->

<style>
    body {
        margin: 0;
        padding: 0;
    }

    ._right-box {
        text-align: right;
        margin-right: 10px;
    }

    ._text {
        font-size: 200%;
    }

    button {
        font-size: 1.5rem;
    }

    input {
        width: 25rem;
        height: 2rem;
    }

    ._right-box > a {
        display: inline-block;
        margin-top: 10px;
        font-size: 1.5rem;
    }

    form {
        text-align: start;
    }

    ._form-content {
        margin-left: 16px;
    }

    input {
        margin-bottom: 16px;
    }

    textarea {
        margin-bottom: 16px;
    }

    a:hover {
        color: red;
    }
</style>

<%@ include file="/jsp/global/common/foot.jspf"%>