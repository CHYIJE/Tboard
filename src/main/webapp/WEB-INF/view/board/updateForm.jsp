<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- header.jsp  -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- start of updateForm.jsp(xxx.jsp)   -->
<div class="container p-5">
    <div class="card">
        <div class="card-header"><b>게시글 수정 페이지</b></div>
        <div class="card-body">
            <form action="/board/updatefrom/${board.id}" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter author" name="writer" value="${board.writer}" required>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter title" name="title" value="${board.title}" required>
                </div>
                <div class="mb-3">
                    <textarea class="form-control" id="content" name="content" rows="4" required>${board.content}></textarea>
                </div>
                <button type="submit" class="btn btn-primary form-control">수정하기</button>
            </form>
        </div>
    </div>
</div>

<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>