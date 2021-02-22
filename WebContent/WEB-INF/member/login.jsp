<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<form action="/store/list" method="get">
	<button type="submit" class="btn btn-primary" type="button">list</button>
</form><br>

<h1 class="h3 mb-4 text-gray-800"><i class="fas fa-smile"></i> Login Page</h1>

<div class="form-group">
		<div class="col-sm-10">
			<input type="hidden" class="form-control" name="referer" value=${referer }>
		</div>
	</div>

<form class="form-horizontal" action="/member/login" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="mid">mid</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="mid">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success">Submit</button>
		</div>
	</div>
</form>

<%@include file="../includes/footer.jsp"%>