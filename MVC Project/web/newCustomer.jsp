<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>PLease enter the new customer's details</h1>

<form:form commandName="order">
	<p>Name: <form:input path="customer.name"/></p>
	<p>Delivery Address: <form:textarea path="customer.address"/></p>
	
	<input type="submit" name="_eventId_addCustomer" value="Add Customer" />
</form:form>