<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header.jsp  -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- start of saveForm.jsp(xxx.jsp)   -->
<div class="container p-5">
    <div class="card">
        <div class="card-header"><b>게시글 작성 페이지</b></div>
        <div class="card-body">
            <form action="/board/save" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter writer" name="writer">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter title" name="title">
                </div>
                <div class="mb-3">
                    <textarea class="form-control" rows="5" name="content"></textarea>
                </div>
                <button type="submit" class="btn btn-primary form-control">게시글 작성</button>
            </form>
        </div>
    </div>
</div>

<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>