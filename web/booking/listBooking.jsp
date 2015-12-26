<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="booking" value="${bookings}" scope="request" />
<jsp:include page="../template.jsp">
	<jsp:param name="content" value="/booking/listBookingContent"/>    
	<jsp:param name="title" value="List Booking"/>
</jsp:include>