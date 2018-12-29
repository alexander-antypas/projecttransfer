<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class=list >
	<h1> Αποθετήριο Αιτήσεων</h1>
	</br>
	<%-- <form action="Sevlet" method="post">
			<h> Φόρτωση... </h>
			</br></br>
			<input type="submit" name="applicationlist" value="Open">
	</form> --%>
	
	</br> 
	<p> ID ΤΗΣ ΑΙΤΗΣΗΣ ΠΡΟΣ ΕΛΕΓΧΟ </p>
	<input type="text" id="appid" name="appid" placeholder="APPLICATION'S ID">
	</br>
	<form action="documents" method="get">
		<button type="submit">Επόμενο</button>
	</form>
	</br>
	<div>
		<form action="Servlet" method="get">
			</br>
			<p> ΑΙΤΗΣΗ ΠΡΩΤΗ ΠΟΥ ΠΕΡΙΛΑΜΒΑΝΕΙ ID ΣΤΟ ΟΝΟΜΑ </p>
			<p> ΑΙΤΗΣΗ ΔΕΥΤΕΡΗ ΠΟΥ ΠΕΡΙΛΑΜΒΑΝΕΙ ID ΣΤΟ ΟΝΟΜΑ </p>
			</br>
		</form>
		</br>
	</div>
	</br>
	</br>
	<form action="user-admin" method="get">
		<button type="submit">Πίσω</button>
	</form>
	</div>


