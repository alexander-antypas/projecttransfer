<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class ="list">
		<form action="Servlet" method="POST" enctype="multipart/form-data" >
			<h1>Αίτηση Μεταγγραφής</h1>
			
					USER ID: <input type="text" name="userid" placeholder="User_id">
					<h3> Πιστοποιητικό Οικογειακής Κατάστασης </h3><br /><br />
					Select a file: <input type="file" name="family" size="50"><br /><br />
					<h3>Εκκαθαριστικό της τρέχουσας χρονιάς </h3><br /><br />
					Select a file: <input type="file" name="financially" size="50"><br /><br />
					<h3>Βεβαίωση μόνιμης Κατοικίας </h3><br /><br />
					Select a file: <input type="file" name="locality" size="50"><br /><br />

					<input type="submit" name="application" value="Submit"/>
			
					<br/><br/><br/>
				    <h2><%=request.getAttribute("result")%></h2>
					<br/><br/><br/>
		</form>
		
		
	</div>