<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->

<div class="nav-link login">
	<form action="/store/list" method="get">
		<button type="submit" class="btn btn-primary" type="button">list</button>
	</form>
</div>
<pre>

</pre>

<div class="col-lg-9">
	<div class="card mt-4">
		<img class="card-img-top img-fluid" style = "width: 100%; height: 400px; object-fit: cover;" src="/upload/store/${store.sno}.jpg"
			alt="">
		<div class="card-body">
			<h3 class="card-title"><i class="fas fa-store"></i>${store.name}</h3>
			<h4>${store.address}</h4>
			<p class="card-text">${store.lat}/${store.lng}</p>
			<c:if test="${not empty sessionScope.userMid}">
				<form action="/review/register?sno=${store.sno}" method="get">
					<input type="hidden" name="sno" value="${store.sno}">
					<input type="hidden" name="name" value="${store.name}">
					<button type="submit" class="btn btn-success" type="button">review register</button>
				</form>
			</c:if>
		</div>

		<div class="card card-outline-secondary my-4">
			<div class="card-header">Reviews</div>
			<div class="card-body">
				<c:forEach items="${review }" var="review">
					<small class="text-muted">${review.mid }</small><br>
					<small class="text-muted">등록일 : ${review.regdate }</small>
					<c:choose>
						<c:when test="${review.score==1 }">
							<div class="text-muted">&#9733; &#9734; &#9734; &#9734; &#9734;</div>
						</c:when>
						<c:when test="${review.score==2 }">
							<div class="text-muted">&#9733; &#9733; &#9734; &#9734; &#9734;</div>
						</c:when>
						<c:when test="${review.score==3 }">
							<div class="text-muted">&#9733; &#9733; &#9733; &#9734; &#9734;</div>
						</c:when>
						<c:when test="${review.score==4 }">
							<div class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</div>
						</c:when>
						<c:when test="${review.score==5 }">
							<div class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9733;</div>
						</c:when>
					</c:choose>
					<div class="review">${review.context }</div>
					<p><img src="/fileView?name=${review.img }" style = "width: 50%; object-fit: cover;" alt="..."></p>
					<div class="bg-white">
						<div class="form-group">
							<form action="/review/like" method="post">
								<input type="hidden" name="rno" value="${review.rno}">
								<input type="hidden" name="mid" value="${userMid }">
									<button type="submit" class="btn btn-primary">like</button>
							</form>
						</div>
					</div>
					<hr>
				</c:forEach>

				<ul class="pagination">
					<c:if test="${pageMaker.prev }">
						<li class="page-item "><a class="page-link"
							href="/review/view?sno=${store.sno}&page=${pageMaker.start - 1 }&perSheet=${pageMaker.pageInfo.perSheet}"
							tabindex="-1">Previous</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
						<li class="page-item ${num == pageMaker.pageInfo.page?"active" : "" }"><a
							class="page-link"
							href="/review/view?sno=${store.sno}&page=${num}&perSheet=${pageMaker.pageInfo.perSheet}">${num}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next }">
						<li class="page-item"><a class="page-link"
							href="/review/view?sno=${store.sno}&page=${pageMaker.end + 1 }&perSheet=${pageMaker.pageInfo.perSheet}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>