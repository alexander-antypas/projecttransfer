<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="content1">
	<form action="show" method="GET">
		<h1>Sign In</h1>
		<label for="author">User Id</label>
		<br /> 
		<input type="text" id="user_id" name="user_id" placeholder="User Id"> 
			<br /> 
			<label for="title">Password</label>
			<br /> 
			<input type="text" id="password" name="password" placeholder="Password"> 
			<input type="submit"value="Log In">
			<br /><br />
	</form>
	<h3>Don't have account?</h3>
	<button onclick="myFunction()">Sign Up</button>
</div>
<div id="content2">
	<form action="action_page.php">
		<h1>Sign Up</h1>
		<label for="university">Choose University</label>
		<br /> 
		<select
			id="uni" name="uni">
			<option value="unknown">unknown</option>
			<option value="ekpa">ekpa</option>
			<option value="opa">opa</option>
		</select> 
		<label for="author">User Id</label>
		<br />
		 <input type="text" id="user_id" name="user_id" placeholder="User Id">
		 <br /> <label
			for="title">Password</label><br /> <input type="text" id="password"
			name="password" placeholder="Password"> <input type="submit"
			value="Sign Up">
	</form>
</div>