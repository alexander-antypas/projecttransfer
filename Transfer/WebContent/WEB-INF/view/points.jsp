<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<form action="documents" method="get">
	<input type="hidden" id="appid" name="appid" value="${param.appid}">
	<button type="submit">ΠΙΣΩ</button>
</form>

<div class=list> 
	${param.appid} <br/>
	<form action="Servlet" method="post"> 
		<h> Συμπλήρωσε τη φόρμα με τα δεδομένα που ζητούνται: </h>
		<br/><br/><br/><br/>
		Έχει ο φοιτητής αδέρφο/αδερφή που σπουδάζει σε άλλη πόλη; (ΝΑΙ-1, ΟΧΙ-0)
		<input type="number" name="stdsibling">
		<br/><br/>
		Αριθμός ανήλικων αδερφών (αν δεν έχει, βάλε '0' στο παρακάτω πεδίο):
		<input type="number" name="numbersiblings">
		<br/><br/>
		Ετήσιο οικογενειακό εισόδημα:
		<input type="number" name="income">
		<br/><br/>
		Βρίσκεται το ίδρυμα στην ίδια πόλη με αυτή της μονιμης κατοικίας του φοιτητή; (ΝΑΙ-1, ΟΧΙ-0)
		<input type="number" name="town">
		<br/><br/> 
		<input type="hidden" id="appid" name="appid" value="${param.appid}">
		<button type="submit" name="score" value="Points">ΚΑΤΑΜΕΤΡΗΣΗ ΒΑΘΜΟΛΟΓΙΑΣ</button>
		<br/><br/>
		${points}
		<br/><br/> 
	</form>
	
	<form action= "Servlet" method="post">
		<input type="hidden" name="is_Approved" value="1">
		<input type="hidden" name="points" value="${points}">
		<input type="hidden" name="appid" value="${param.appid}">
		
		<button type="submit" name="check" value="check">ΚΑΤΑΧΩΡΗΣΗ ΤΗΣ ΒΑΘΜΟΛΟΓΙΑΣ ΣΤΗ ΒΑΣΗ</button>
	</form>
	${result}
	<br/>
	<br/>
	<form action="user-professor" method="get">
		<button type="submit">ΑΝΟΙΓΜΑ ΑΠΟΘΕΤΗΡΙΟΥ ΑΙΤΗΣΕΩΝ</button>	
	</form>



</div>