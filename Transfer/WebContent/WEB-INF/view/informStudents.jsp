<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="content">
	<h1>Επιλογή μαθητών :</h1>
	<form action="Servlet" method="post">
		<input type="checkbox" name="st1" value="student1">Student1<br>
		<input type="checkbox" name="st2" value="student2">Student2<br>
		<input type="checkbox" name="st3" value="student3" checked>Student3<br><br>
		<button type="submit" name='SelectS' value="SelectS"> ΕΜΦΑΝΙΣΗ ΕΓΚΕΚΡΙΜΕΝΩΝ ΜΑΘΗΤΩΝ </button>
	</form>
	</br>
	</br>
	<form action="secretary" method="get">
		<button>ΠΙΣΩ</button>
	</form>
</div>