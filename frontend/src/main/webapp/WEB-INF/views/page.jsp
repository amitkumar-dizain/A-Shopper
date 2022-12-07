<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="assets" value="/xyz/assets" />
<spring:url var="css" value="/xyz/css" />
<spring:url var="js" value="/xyz/js" />
<spring:url var="images" value="/xyz/images" />
<spring:url var="scss" value="/xyz/scss" />
<spring:url var="lib" value="/xyz/lib" />
<spring:url var="mail" value="/xyz/mail" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />


<title>Multi Shop- ${title}</title>

<!-- Favicon -->
<link rel="icon" type="image/x-icon" href="${assets}/favicon.ico" />
<!-- Customized Bootstrap Stylesheet -->
<link href="${css}/style.css" rel="stylesheet">
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<!-- Data Table -->
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
	rel="stylesheet">
<!-- Libraries Style Sheet -->
<link href="${lib}/animate.min.css" rel="stylesheet">
<link href="${lib}/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">


<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

</head>
<body>
	<div class="wrapper">

		<div class="content">
			<%@ include file="./shared/navbar.jsp"%>

			<div class="container-fluid">

				<c:if test="${userClickHome==true}">
					<%@ include file="home.jsp"%>
				</c:if>
				<c:if test="${userClickabout==true}">
					<%@ include file="about.jsp"%>
				</c:if>
				<c:if
					test="${userClickProduct==true or userClickCategoryProduct==true}">
					<%@ include file="product.jsp"%>
				</c:if>
				<c:if test="${userClickSingleProduct==true}">
					<%@ include file="singleproduct.jsp"%>
				</c:if>
				<c:if test="${userClickManageProduct==true}">
					<%@ include file="manageproduct.jsp"%>
				</c:if>
				<c:if test="${userClickCheckOut==true}">
					<%@ include file="checkout.jsp"%>
				</c:if>
				<c:if test="${userClickContact==true}">
					<%@ include file="contact.jsp"%>
				</c:if>
				<c:if test="${userClickCart==true}">
					<%@ include file="cart.jsp"%>
				</c:if>

			</div>


			<%@ include file="./shared/footer.jsp"%>
		</div>
	</div>






	<script src="${js}/bootstrap.js"></script>
	<script src="${js}/jquery-1.10.2.js"></script>
	<script src="${js}/myapp.js"></script>
	<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

	<!-- JavaScript Libraries -->
	<script src="${js}/jquery-3.4.0.min.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>
	<script src="${lib}/easing.min.js"></script>
	<script src="${lib}/owl.carousel.min.js"></script>

	<!-- Contact Java script File -->
	<script src="${mail}/jqBootstrapValidation.min.js"></script>
	<script src="${mail}/contact.js"></script>

	<!-- Template Java script -->
	<script src="${js}/main.js"></script>

</body>
</html>
