<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="gr.hua.dit.transfer.Servlet" %>

<form action="user-professor" method="get">
	<button type="submit">ΠΙΣΩ</button>
</form>
<br/><br/>
<div class= list>
	<br/><br/><br/>
	
	<form action="Servlet" method="POST">
		${param.appid} <br/>
		<input type="hidden" id="appid" name="appid" value="${param.appid}">
		<button type="submit" name="openapp" value="Open">ΑΝΟΙΓΜΑ ΑΙΤΗΣΗΣ</button><br/><br/>
			<table border="1">
				<tr> 
					<th> Πιστοποιητικό Οικογενειακής Κατάστασης </th>
					<th> Εκκαθαριστικό</th>
					<th> Βεβαίωση Μόνιμης Κατοικίας </th>		
				</tr>
				<tr>
					<th>${app.family}</th>
					<th>${app.financially}</th>
					<th>${app.locality}</th>
				</tr>
			</table>
		<br/><br/>	
	</form>	
	
	<form action="Servlet" method="post">
		<h1> Καταγράψτε τον αριθμό των δικαιολογητικών: </h1> 
		<br/><br/>
		<input name="documents" type="number">
		<button type="submit" name="button" value="Submit">ΥΠΟΒΟΛΗ</button>
		<br/><br/>
		${decision}

	</form>
	<br/><br/>
 
	<form action="points" method="get">
		<button type="submit">ΕΓΚΡΙΣΗ</button>
		<input type="hidden" id="appid" name="appid" value="${param.appid}">
	</form>
	<br/>
	<form action="Servlet" method="post">
		<input type="hidden" name="is_Approved" value="0">
		<input type="hidden" name="points" value="0">
		<input type="hidden" name="appid" value="${param.appid}">
		
		<button type="submit" name="declined" value="declined">ΑΠΟΡΡΙΨΗ</button>
	</form>

	<br/><br/>
	
</div>