<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Welcome Back, ${order.customer.name}</h1>

<ul>
<c:forEach items="${order.booksOrdered}" var="book">
	<li>${book.title}</li>
</c:forEach>
</ul>

