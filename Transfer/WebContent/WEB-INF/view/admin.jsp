<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<form id="forma" action="/Transfer/admin" method="get">
	<button>ΠΙΣΩ</button>
	</form>
	
<div id="content1">
	<button onclick="myFunction()">ΔΗΜΙΟΥΡΓΙΑ ΧΡΗΣΤΗ</button>
	<br />
	<br />
	<form action="Servlet" method="post">
	<button type="submit" name="show_users" value="show_users">ΕΠΕΞΕΡΓΑΣΙΑ ΧΡΗΣΤΗ</button>
	</form>
	<br />
	${message_for_admin}
	<br />
</div>

<div id="content2">

	<form action="Servlet" method="post">	
		<label for="username">ΟΝΟΜΑ</label>
		<br />
		<input type="text" id="username" name="username" placeholder="ΟΝΟΜΑ" required>
		<br />
		<label for="surname">ΕΠΩΝΥΜΟ</label>
		<br />
		<input type="text" id="surrname" name="surname" placeholder="ΕΠΩΝΥΜΟ" required>
		<br />
		<label for="id">Α.Μ. ΧΡΗΣΤΗ</label>
		<br /> 
		<input type="text"	id="id" name="id" placeholder="Α.Μ. ΧΡΗΣΤΗ" required> 
		<br /> 
		<label	for="title">ΚΩΔΙΚΟΣ</label>
		<br />
		<input type="password" id="password" name="password" placeholder="ΚΩΔΙΚΟΣ" required>
		<br />
		<label for="year">ΕΤΟΣ ΓΕΝΝΗΣΗΣ</label>
		<br />
		<input type="number" id="year" name="year" min="1980" max="2019" placeholder="ΕΤΟΣ ΓΕΝΝΗΣΗΣ" required>
		<br /> 
		<label for="age">ΗΛΙΚΙΑ</label> 
		<br />
		<input type="number" id="age" name="age" placeholder="ΗΛΙΚΙΑ" required min="17" max="99">
		<br /> 
		<label for="email">E-MAIL</label> 
		<br />
		<input type="text" id="email" name="email" placeholder="E-MAIL" required>
		<br />
		<label for="role">ΕΙΔΙΚΟΤΗΤΑ</label> <br /> 
		<select	id="role" name="role" required>
			<option value="null"></option>
			<option value="ROLE_SECRETARIAT">ΓΡΑΜΜΑΤΕΙΑ</option>
			<option value="ROLE_PROFESSOR">ΚΑΘΗΓΗΤΗΣ</option>
		</select>
		<label for="yoe">ΕΤΟΣ ΠΡΟΣΛΗΨΗΣ</label> 
		<br />
		<input type="number" id="yoe" name="yoe" placeholder="ΕΤΟΣ ΠΡΟΣΛΗΨΗΣ" required min="2000" max="2019">
		<br />
		<label for="department">ΤΜΗΜΑ</label> <br /> 
		<select	id="department" name="department" required>
			<option value="null"></option>
			<option value="ict">ΠΛΗΡΟΦΟΡΙΚΗΣ ΚΑΙ ΤΗΛΕΜΑΤΙΚΗΣ</option>
			<option value="he">ΟΙΚΙΑΚΗΣ ΟΙΚΟΝΟΜΙΑΣ</option>
			<option value="hs">ΔΙΑΙΤΟΛΟΓΙΑΣ</option>
			<option value="geo">ΓΕΩΓΡΑΦΙΑΣ</option>
		</select>
		<button type="submit" name="add_internal" value="add_internal">ΚΑΤΑΧΩΡΗΣΗ ΧΡΗΣΤΗ</button>
	</form>
	<br />
</div>