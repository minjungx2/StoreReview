<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800"><i class="fas fa-store"></i> Store List</h1>

<div class="row">
	<c:forEach items="${list }" var="store">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="/review/view?sno=${store.sno}"><img class="card-img-top" style = "width: 100%; height: 200px; object-fit: cover;" src="/upload/store/${store.sno}.jpg" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">${store.name}</h4>
                <h5>${store.address}</h5>
                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
	</c:forEach>
</div>
 <!-- /.row -->

<ul class="pagination">
	<c:if test="${pageMaker.prev }">
		<li class="page-item ">
			<a class="page-link" href="/store/list?page=${pageMaker.start - 1 }" tabindex="-1">Previous</a>
		</li>
	</c:if>
	<c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
		<li class="page-item ${num == pageMaker.pageInfo.page?"active" : "" }">
			<a class="page-link" href="/store/list?page=${num}">${num}</a>
		</li>
	</c:forEach>
	<c:if test="${pageMaker.next }">
		<li class="page-item">
			<a class="page-link" href="/store/list?page=${pageMaker.end + 1 }">Next</a>
		</li>
	</c:if>
</ul>

<%@include file="../includes/footer.jsp"%>