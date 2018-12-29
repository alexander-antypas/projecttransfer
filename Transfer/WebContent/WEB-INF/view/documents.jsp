<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="gr.hua.dit.transfer.Servlet" %>

<form action="applist" method="get">
	<button type="submit">Πίσω</button>
</form>
</br>
</br>
<div class= list>
	</br>
	</br>
	</br>
	<form action="Servlet" method="post">
		<h> Καταγράψτε τον αριθμό των δικαιολογητικών: </h> 
		</br>
		</br>
		<input name="documents" type="number">
		<input type="submit" name="button" value="Submit">
		</br>
		</br>
		${decision}
	</form>
	</br>
	</br>
	<button type="button">Έκριση</button>
	<button type="button">Απόρριψη</button>
	</br>
	</br>
	<form action="points" method="get">
		<button type="submit">Καταμέτρηση Πόντων</button>	
	</form>
	</br>
</div>