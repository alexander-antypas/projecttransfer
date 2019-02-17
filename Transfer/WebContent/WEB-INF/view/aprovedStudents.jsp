<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="gr.hua.dit.transfer.Servlet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class=list>
	<form action="Servlet" method="POST">
		
		<div>
			<center>
				<br/>
				<table border="1">
				<tr>
					<th> ΕΓΓΕΚΡΙΜΕΝΟΙ ΜΑΘΗΤΕΣ </th>
				</tr>
				</table>
				<c:forEach items="${usersID}" var="userID">
					AM:<td>${userID.check_id}</td>
					ΠΟΝΤΟΙ:<td>${userID.points} </td><br>
				</c:forEach>
				<br/>
			<center>
		</div>
		<br/><br/>
		<br/><br/>
		
		<button type="submit" name="match" value="match">ΑΝΤΙΣΤΟΙΧΗΣΗ ΘΕΣΕΩΝ</button>
		<br/><br/>
	</form>
</div>