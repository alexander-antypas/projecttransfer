<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<form action="documents" method="get">
	<button type="submit">Πίσω</button>
</form>

<div class=list> 
	<form action="Servlet" method="post"> 
		<h> Συμπλήρωσε τη φόρμα με τα δεδομένα που ζητούνται: </h>
		</br></br></br></br>
		Έχει ο φοιτητής αδέρφο/αδερφή που σπουδάζει σε άλλη πόλη; (ΝΑΙ-1, ΟΧΙ-0)
		<input type="number" name="stdsibling">
		</br></br>
		Αριθμός ανήλικων αδερφών (αν δεν έχει, βάλε '0' στο παρακάτω πεδίο):
		<input type="number" name="numbersiblings">
		</br></br>
		Ετήσιο οικογενειακό εισόδημα:
		<input type="number" name="income">
		</br></br>
		Βρίσκεται το ίδρυμα στην ίδια πόλη με αυτή της μονιμης κατοικίας του φοιτητή; (ΝΑΙ-1, ΟΧΙ-0)
		<input type="number" name="town">
		</br></br> 
		<input type="submit" name="points" value="Points" />
		</br></br>
		${points}
		</br></br> 
	</form>
	
	<button type="submit">Προσθήκη πόντων του φοιτητή στην βάση</button>
	</br>
	</br>
	<form action="applist" method="get">
		<button type="submit">Άνοιγμα Αποθετηρίου Αιτήσεων</button>	
	</form>



</div>