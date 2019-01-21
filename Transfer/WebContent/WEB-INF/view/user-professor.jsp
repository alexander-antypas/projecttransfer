<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="gr.hua.dit.transfer.Servlet" %>

<div class=list>
	<h1> Αποθετήριο Αιτήσεων</h1>

	<form action="documents" method="get">
		<p> Γράψτε το ID της αίτησης που θέλετε να ελέγξετε: </p>
		<input type="text" id="appid" name="appid" placeholder="APPLICATION'S ID">
		</br>
	
		<button type="submit">Επόμενο</button>
	</form>
	</br>
	
	<form action="Servlet" method="POST">
		<input type="submit" name="viewall" value="Repository"/>
		</br></br>
		<div>
			</br>
			${applications}
			</br></br>
		</div>
		
	</form>
</div>
