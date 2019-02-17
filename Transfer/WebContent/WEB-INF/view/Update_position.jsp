<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<div class=update>
	<form action="Servlet" method="post" enctype="multipart/form-data" >
	  Πληροφορική και Τηλεματική:
	  <input type="number" name="informatics"><br>
	  Διαιτολογία και Διατροφολογία:
	  <input type="number" name="health_science"><br>
	  Γεωγραφία:
	  <input type="number" name="geography"><br>
	  Οικιακή Οικονομία:
	  <input type="number" name="home_economics"><br>
	  
	  <button type="submit" name="Updateposi" value="Submit">ΥΠΟΒΟΛΗ</button>
    </form>
</div>