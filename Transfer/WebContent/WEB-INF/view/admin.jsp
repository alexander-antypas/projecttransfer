<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

	<form id="forma" action="" method="get">
	<button>ΠΙΣΩ</button>
	</form>
	
<div id="content1">
	<button onclick="myFunction()">ΔΗΜΙΟΥΡΓΙΑ ΧΡΗΣΤΗ</button>
	<br />
	<br />
	<button onclick="myFunction1()">ΕΠΕΞΕΡΓΑΣΙΑ ΧΡΗΣΤΗ</button>
</div>

<div id="content2">

	<form action="Servlet" method="post">	
		<label for="username">ΟΝΟΜΑ</label>
		<br />
		<input type="text" id="username" name="username" placeholder="ΟΝΟΜΑ">
		<br />
		<label for="surname">ΕΠΩΝΥΜΟ</label>
		<br />
		<input type="text" id="surrname" name="surname" placeholder="ΕΠΩΝΥΜΟ">
		<br />
		<label for="id">Α.Μ. ΧΡΗΣΤΗ</label>
		<br /> 
		<input type="text"	id="id" name="id" placeholder="Α.Μ. ΧΡΗΣΤΗ"> 
		<br /> 
		<label	for="title">ΚΩΔΙΚΟΣ</label>
		<br />
		<input type="password" id="password" name="password" placeholder="ΚΩΔΙΚΟΣ">
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
		<label for="role">ΕΙΔΙΚΟΤΗΤΑ</label> <br /> 
		<select	id="role" name="role">
			<option value="null"></option>
			<option value="ROLE_SECRETARIAT">ΓΡΑΜΜΑΤΕΙΑ</option>
			<option value="ROLE_PROFESSOR">ΚΑΘΗΓΗΤΗΣ</option>
		</select>
		<label for="yoe">ΕΤΟΣ ΠΡΟΣΛΗΨΗΣ</label> 
		<br />
		<input type="text" id="yoe" name="yoe" placeholder="ΕΤΟΣ ΠΡΟΣΛΗΨΗΣ">
		<br />
		<label for="department">ΤΜΗΜΑ</label> <br /> 
		<select	id="department" name="department">
			<option value="null"></option>
			<option value="ict">ΠΛΗΡΟΦΟΡΙΚΗΣ ΚΑΙ ΤΗΛΕΜΑΤΙΚΗΣ</option>
			<option value="he">ΟΙΚΙΑΚΗΣ ΟΙΚΟΝΟΜΙΑΣ</option>
			<option value="hs">ΔΙΑΙΤΟΛΟΓΙΑΣ</option>
			<option value="geo">ΓΕΩΓΡΑΦΙΑΣ</option>
		</select>
		<button type="submit" name="save_user" value="add_internal">ΚΑΤΑΧΩΡΗΣΗ ΧΡΗΣΤΗ</button>
	</form>
	<br />
</div>

<div id="content3">
	<form action="Sevlet" method="get">
		<label for="author">Α.Μ. ΧΡΗΣΤΗ</label> <br /> <input type="text"
			id="user_id" name="username" placeholder="Α.Μ. ΧΡΗΣΤΗ"> 
			<button type="submit" name="search" value="search">ΑΝΑΖΗΤΗΣΗ</button>
			<br /><br />
	</form>
	<br />
	<form action="Servlet" method="get">
	<button type="submit" name="show_users" value="show_users">ΕΜΦΑΝΙΣΗ ΛΙΣΤΑΣ ΧΡΗΣΤΩΝ</button>
	</form>
</div>