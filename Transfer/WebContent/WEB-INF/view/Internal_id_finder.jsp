<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<form action="/Transfer/admin" method="get">
	<button>ΠΙΣΩ</button>
	</form>
	
<div id="contentup">
	<form action="Servlet" method="post">
		<label for="user_id">Α.Μ. ΧΡΗΣΤΗ</label> <br /> 
		<input type="text" id="user_id" list="users" name="user_id" placeholder="Α.Μ. ΧΡΗΣΤΗ" required>
  			<datalist id="users">
  				<c:forEach items="${users}" var="user">
    				<option value="${user.id}">
    			</c:forEach>
  			</datalist>
		<button type="submit" name="search" value="search">ΕΠΕΞΕΡΓΑΣΙΑ ΣΤΟΙΧΕΙΩΝ ΧΡΗΣΤΗ</button><br /><br />
		<button type="submit" name="delete" value="delete">ΔΙΑΓΡΑΦΗ ΧΡΗΣΤΗ</button>
		<br /><br />
	</form>
</div>