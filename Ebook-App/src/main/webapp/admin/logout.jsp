<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>

	<div class="col-md-3">
		<c:if test="${not empty userobj }">
			<a class="btn btn-success text-white"><i class="fas fa-user"></i>
				${ userobj.name}</a>
			<a data-toggle="modal" data-target="#exampleModalCenter"
				class="btn btn-primary text-white"><i class="fas fa-sign-in-alt"></i>
				Logout</a>
		</c:if>
		<c:if test="${empty userobj }">
			<a href="../login.jsp" class="btn btn-success"><i
				class="fas fa-sign-in-alt"></i> Login</a>
			<a href="../register.jsp" class="btn btn-primary text-white"><i
				class="fas fa-user-plus"></i> Register</a>
		</c:if>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="text-center">
						<h4>Do you want logout</h4>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<a href="../logout" class="btn btn-primary text-white">Logout</a>
					</div>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
</body>
</html>