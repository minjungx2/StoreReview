<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<form action="/store/list" method="get">
	<button type="submit" class="btn btn-primary" type="button">list</button>
</form><br>

<h1 class="h3 mb-4 text-gray-800">${store.name } 리뷰등록</h1>

<form class="form-horizontal" action="/review/register" method="post"  enctype="multipart/form-data">
	<div class="form-group">
		<div class="col-sm-10">
			<input type="hidden" class="form-control" name="sno" value="${store.sno }" readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="mid">mid</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="mid" value="${userMid}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="context">context</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="context">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="score">score</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="score">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="img">img</label>
		<div class="col-sm-10">
			<input type="file" name="file" multiple="multiple" >
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success">Submit</button>
		</div>
	</div>
</form>

<%@include file="../includes/footer.jsp"%>