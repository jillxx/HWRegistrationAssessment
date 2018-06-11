<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>

</head>
<body>
<script type="text/javascript" src="js/file.js"></script>

	<h1 style="color:#3399ff;">Please fill the form to register!</h1>
	<br>
	<form action="register" method="post" onSubmit="return formValidation();">
		<fieldset>
			<legend>Registration From:</legend>
			<table>
				<tr>
					<td>First Name:</td>
					<td><input id="fName" type="text" name="fName" placeholder="First Name" title="Name can have alphabet characters only" pattern ="^[A-Za-z\s]+$" required></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input id="lName" type="text" name="lName" placeholder="Last Name" title="Name can have alphabet characters only" pattern ="^[A-Za-z\s]+$" required></td>
				</tr>
				<tr>
					<td>Address1:</td>
					<td><input id="address1" type="text" name="address1" placeholder="Address line 1" title= "Address can have alphanumeric characters only" pattern ="^[0-9a-zA-Z\s]+$" required></td>
				</tr>
				<tr>
					<td>Address2:</td>
					<td><input id ="address2" type="text" name="address2" placeholder="Address line 2(optional)" title= "Address can have alphanumeric characters only" pattern ="^[0-9a-zA-Z\s]+$"></td>
				</tr>

				<tr>
					<td>City:</td>
					<td><input id ="city" type="text" name="city" placeholder="City"title = "Fcity can have alphabet characters only" pattern="^[A-Za-z]+$" required></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><select name="state" id = "state">
						<option selected="" value="Default">(Please select a
								state)</option>
						<option value="AL">AL</option>
						<option value="AK">AK</option>
						<option value="AR">AR</option>
						<option value="AZ">AZ</option>
						<option value="CA">CA</option>
						<option value="CO">CO</option>
						<option value="CT">CT</option>
						<option value="DC">DC</option>
						<option value="DE">DE</option>
						<option value="FL">FL</option>
						<option value="GA">GA</option>
						<option value="HI">HI</option>
						<option value="IA">IA</option>
						<option value="ID">ID</option>
						<option value="IL">IL</option>
						<option value="IN">IN</option>
						<option value="KS">KS</option>
						<option value="KY">KY</option>
						<option value="LA">LA</option>
						<option value="MA">MA</option>
						<option value="MD">MD</option>
						<option value="ME">ME</option>
						<option value="MI">MI</option>
						<option value="MN">MN</option>
						<option value="MO">MO</option>
						<option value="MS">MS</option>
						<option value="MT">MT</option>
						<option value="NC">NC</option>
						<option value="NE">NE</option>
						<option value="NH">NH</option>
						<option value="NJ">NJ</option>
						<option value="NM">NM</option>
						<option value="NV">NV</option>
						<option value="NY">NY</option>
						<option value="ND">ND</option>
						<option value="OH">OH</option>
						<option value="OK">OK</option>
						<option value="OR">OR</option>
						<option value="PA">PA</option>
						<option value="RI">RI</option>
						<option value="SC">SC</option>
						<option value="SD">SD</option>
						<option value="TN">TN</option>
						<option value="TX">TX</option>
						<option value="UT">UT</option>
						<option value="VT">VT</option>
						<option value="VA">VA</option>
						<option value="WA">WA</option>
						<option value="WI">WI</option>
						<option value="WV">WV</option>
						<option value="WY">WY</option>
					</select></td>
				</tr>

				<tr>
					<td>Zipcode:</td>
					<td><input type="text" id= "zip" name="zip" placeholder="##### or #####-####"
						title="Please enter a 5 or 9 digit Zip Code" 
						pattern="^\s*?\d{5}(?:[-\s]\d{4})?\s*?$" required></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><select name="country" id="country">
							<option selected="" value="Default">(Please select a
								country)</option>
							<option value="US">US</option>
					</select></td>
				</tr>


			</table>

			<input id="submitBtn" type="submit" value="Register">
		</fieldset>
	</form>





</body>
</html>