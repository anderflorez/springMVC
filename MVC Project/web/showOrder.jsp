<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Welcome Back, ${order.customer.name}</h1>

<ul>
<c:forEach items="${order.booksOrdered}" var="book">
	<li>
		${book.title}
		
		<form method="post">
			<input type="submit" name="_eventId_removeBook" value="Remove Item" />
			<input type="hidden" name="id" value="${book.id}" />
		</form>
	</li>
</c:forEach>
</ul>

<form method="post">
	<input type="submit" name="_eventId_nextStep" value="Press here to continue">

</form>