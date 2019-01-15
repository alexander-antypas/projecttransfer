<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class ="list">
		<form action="Servlet" method="get" >
			<h1>Αίτηση Μεταγγραφής</h1>
			<label for="family">Πιστοποιητικό Οικογενειακής Κατάστασης</label><br /><br />
			Select a file: <input type="file" name="family"><br /><br />
			<label for="financially">Εκκαθαριστικό της τρέχουσας χρονιάς</label><br /><br />
			Select a file: <input type="file" name="financially"><br /><br />
			<label for="locality">Πιστοποιητικό μόνιμης Κατοικίας</label><br /><br />
			Select a file: <input type="file" name="locality"><br /><br />
			
			<input type="submit" name="application" value="Submit"/>
			
			</br></br></br>
			${result}
			</br></br></br>
		</form>
		
		
	</div>