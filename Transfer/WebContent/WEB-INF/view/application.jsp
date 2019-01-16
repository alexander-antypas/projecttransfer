<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class ="list">
		<form action="Servlet" method="post" enctype="multipart/form-data" >
			<h1>Αίτηση Μεταγγραφής</h1>
			
			
					<h> Πιστοποιητικό Οικογειακής Κατάστασης <h><br /><br />
					Select a file: <input type="file" name="family" size="50"><br /><br />
					<h>Εκκαθαριστικό της τρέχουσας χρονιάς <h><br /><br />
					Select a file: <input type="file" name="financially" size="50"><br /><br />
					<h>Βεβαίωση μόνιμης Κατοικίας <h><br /><br />
					Select a file: <input type="file" name="locality" size="50"><br /><br />

					<input type="submit" name="application" value="Submit"/>
			
					</br></br></br>
				    <h2><%=request.getAttribute("result")%></h2>
					</br></br></br>
		</form>
		
		
	</div>