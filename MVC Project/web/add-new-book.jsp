<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Enter a new book</title>
<link href="<c:url value="/styles.css"/>" rel="Stylesheet"
	type="text/css" />
</head>

<body>
	<jsp:include page="/header.jsp" />

	<div id="addBook">
		<!-- the form uses the name of the backing object (domain object name given in the controller) -->
		<form:form commandName="book">
			<p>Please Enter the Details of the Book:</p>
			<!-- Path means the attribute of the object passed to the form (isbn of the book) -->
			<label><fmt:message key="book.isbn" /></label><form:input path="isbn" />
														  <form:errors path="isbn" cssClass="error" />
			<label><fmt:message key="book.title" /></label><form:input path="title" />
														   <form:errors path="title" cssClass="error" />
			<label><fmt:message key="book.author" /></label><form:input path="author" />
															<form:errors path="author" cssClass="error" />
			<label><fmt:message key="book.price" /></label><form:input path="price" />
														   <form:errors path="price" cssClass="error" />
			
			<input type="SUBMIT" value="Submit">
			<input type="RESET" />			
		</form:form>
	</div>

	<jsp:include page="/footer.jsp" />
</body>
</html>
