<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page import="gr.hua.dit.transfer.Servlet" %>

<div id="content1">
	<form:form action="${pageContext.request.contextPath}/authUser"
		method="POST">
		<h1>ΣΥΝΔΕΣΗ</h1>
		<label for="author">Α.Μ. ΧΡΗΣΤΗ</label>
		<br />
		<input type="text" id="user_id" name="username" placeholder="Α.Μ. ΧΡΗΣΤΗ">
		<br />
		<label for="password">ΚΩΔΙΚΟΣ</label>
		<br />
		<input type="password" id="password" name="password" placeholder="ΚΩΔΙΚΟΣ">
		<input type="submit" value="ΣΥΝΔΕΣΗ">
		<br />
	</form:form>
	<h3>ΔΕΝ ΕΧΕΙΣ ΛΟΓΑΡΙΑΣΜΟ?</h3>
	<button onclick="myFunction()">ΕΓΓΡΑΦΗ ΣΤΟ ΣΥΣΤΗΜΑ</button>
</div>
<div id="content2">
	<form action="Servlet" method="POST" enctype="multipart/form-data">
		<h1>ΕΓΓΡΑΦΗ ΣΤΟ ΣΥΣΤΗΜΑ</h1>
		<label for="username">ΟΝΟΜΑ</label>
		<br />
		<input type="text" id="username" name="username" placeholder="ΟΝΟΜΑ">
		<br />
		<label for="surname">ΕΠΩΝΥΜΟ</label>
		<br />
		<input type="text" id="surname" name="surname" placeholder="ΕΠΩΝΥΜΟ">
		<br />
		<label for="id">Α.Μ. ΧΡΗΣΤΗ</label>
		<br /> 
		<input type="text"	id="id" name="id" placeholder="Α.Μ. ΧΡΗΣΤΗ"> 
		<br /> 
		<label	for="title">ΚΩΔΙΚΟΣ</label>
		<br />
		<input type="password" id="password" name="password" placeholder="ΚΩΔΙΚΟΣ">
		<label for="university">ΕΠΕΛΕΞΕ ΠΑΝΕΠΙΣΤΗΜΙΟ</label> 
		<br /> 
		<select id="uni" name="uni">
			<option value="unknown">unknown</option>
			<option value="ekpa">ekpa</option>
			<option value="opa">opa</option>
		</select> 
		<br />
		<label for="year">ΕΤΟΣ ΓΕΝΝΗΣΗΣ</label>
		<br />
		<input type="text" id="year" name="year" placeholder="ΕΤΟΣ ΓΕΝΝΗΣΗΣ"> 
		<br /> 
		<label for="age">ΗΛΙΚΙΑ</label> 
		<br />
		<input type="text" id="age" name="age" placeholder="ΗΛΙΚΙΑ">
		<br /> 
		<label for="email">E-MAIL</label> 
		<br />
		<input type="text" id="email" name="email" placeholder="E-MAIL">
		<br /> 
		<label for="yoe">ΕΤΟΣ ΕΓΓΡΑΦΗΣ ΣΤΟ ΠΑΝΕΠΙΣΤΗΜΙΟ</label> 
		<br />
		<input type="text" id="yoe" name="yoe" placeholder="ΕΤΟΣ ΠΡΟΣΛΗΨΗΣ">
		<button name="add_external" type="submit" value="add">ΕΓΓΡΑΦΗ</button>
	</form>
</div>