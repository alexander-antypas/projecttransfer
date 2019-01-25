<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<form action="/Transfer/Internal_id_finder" method="get">
		<button>ΠΙΣΩ</button>
	</form>
	
	<div id="contentup">
	<form action="Servlet" method="post">
		
		<label for="username">ΟΝΟΜΑ</label>
		<br />
		<input type="text" id="username" name="username" value="${user.first_name}">
		<br />
		<label for="surname">ΕΠΩΝΥΜΟ</label>
		<br />
		<input type="text" id="surrname" name="surname" value="${user.last_name}">
		<br />
		<label for="id">Α.Μ. ΧΡΗΣΤΗ</label>
		<br /> 
		<input type="text"	id="id" name="id" value="${user.id}"> 
		<br /> 
		<label	for="title">ΚΩΔΙΚΟΣ</label>
		<br />
		<input type="password" id="password" name="password" value="${user.password}">
		<br />
		<label for="year">ΕΤΟΣ ΓΕΝΝΗΣΗΣ</label>
		<br />
		<input type="text" id="year" name="year" value="${user.year_of_birth}"> 
		<br /> 
		<label for="age">ΗΛΙΚΙΑ</label> 
		<br />
		<input type="text" id="age" name="age" value="${user.age}">
		<br /> 
		<label for="email">E-MAIL</label> 
		<br />
		<input type="text" id="email" name="email" value="${user.email}">
		<br />
		<label for="role">ΕΙΔΙΚΟΤΗΤΑ</label> <br /> 
		<select	id="role" name="role">
			<option value="${user.employee_type}">${user.employee_type}</option>
			<option value="ROLE_SECRETARIAT">ΓΡΑΜΜΑΤΕΙΑ</option>
			<option value="ROLE_PROFESSOR">ΚΑΘΗΓΗΤΗΣ</option>
		</select>
		<label for="yoe">ΕΤΟΣ ΠΡΟΣΛΗΨΗΣ</label> 
		<br />
		<input type="text" id="yoe" name="yoe" value="${user.year_of_recruitment}">
		<br />
		<label for="department">ΤΜΗΜΑ</label> <br /> 
		<select	id="department" name="department">
			<option value="${user.department}">${user.department}</option>
			<option value="ict">ΠΛΗΡΟΦΟΡΙΚΗΣ ΚΑΙ ΤΗΛΕΜΑΤΙΚΗΣ</option>
			<option value="he">ΟΙΚΙΑΚΗΣ ΟΙΚΟΝΟΜΙΑΣ</option>
			<option value="hs">ΔΙΑΙΤΟΛΟΓΙΑΣ</option>
			<option value="geo">ΓΕΩΓΡΑΦΙΑΣ</option>
		</select>
		<input type="hidden" id="id" name="identity" value="${user.id}">
		<input type="hidden" id="pw" name="pw" value="${user.password}">
		<button type="submit" name="update_internal" value="update_internal">ΕΝΗΜΕΡΩΣΗ ΣΤΟΙΧΕΙΩΝ ΧΡΗΣΤΗ</button>
	</form>
</div>