<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="gr.hua.dit.transfer.Servlet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=list>
	<h1> Αποθετήριο Αιτήσεων</h1>

	<form action="Servlet" method="POST">
		<p> Γράψτε το ID της αίτησης που θέλετε να ελέγξετε: </p>
		<input type="text" id="appid" name="appid" placeholder="APPLICATION'S ID"><br/>	
		<button type="submit" name="searchuserid" value="searchuserid">ΕΠΟΜΕΝΟ</button> <br/><br/>

		${message}
	</form>
	<br/>
	
	<form action="Servlet" method="POST">
		<button type="submit" name="viewall" value="Repository">ΑΠΟΘΕΤΗΡΙΟ ΑΙΤΗΣΕΩΝ</button>
		<br/><br/>
		<div id=contentup>
			<br/>
			<table border="1">
			<tr>
				<th> User_id </th>
			</tr>
			</table>
			<c:forEach items="${applications}" var="application">
				${application.application_id} <br/>
			</c:forEach>
			<br/>
		</div>
		
	</form>
</div>
