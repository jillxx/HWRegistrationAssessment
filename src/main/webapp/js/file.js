/**
 * @author Jill XU
 */

function formValidation() {

	
	var fname = document.getElementById("fName").value;
	var lname = document.getElementById("lName").value;
	var add1 = document.getElementById("address1").value;
	var add2 = document.getElementById("address2").value;
	var city = document.getElementById("city").value;
	var state = document.getElementById("state").value;
	var zip = document.getElementById("zip").value;
	var country = document.getElementById("country").value;

	if (validatefirstname(fname)) {
		if (validatelastname(lname)) {
			if (validateaddress1(add1)) {
				if (validateaddress2(add2)) {
					if (validatecity(city)) {
						if (validatestate(state)) {						
							if (validatezipcode(zip)) {
								if (validatecountry(country)) {
									return true;
								}
							}
						}
					}
				}
			}
		}
	}
	return false;

}
function validatefirstname(fname) {

	if (/^[A-Za-z\s]+$/.test(fname)) {
		return true;
	} else {
		alert('Name can have alphabet characters only');

		return false;
	}
}
function validatelastname(lname) {

	if (/^[A-Za-z\s]+$/.test(lname)) {
		return true;
	} else {
		alert('Name can have alphabet characters only');
		return false;
	}
}

function validateaddress1(add1) {

	if (/^[0-9a-zA-Z\s]+$/.test(add1)) {
		return true;
	} else {
		alert('Address must have alphanumeric characters only');
		return false;
	}
}

function validateaddress2(add2) {
	var letters = /^[0-9a-zA-Z\s]+$/;
	if (add2 == "") {
		return true;
	} else {
		if (letters.test(add2)) {
			return true;
		} else {
			alert('User address must have alphanumeric characters only');

			return false;
		}
	}
}
function validatecity(city) {
	var letters = /^[A-Za-z]+$/;
	if (letters.test(city)) {
		return true;
	} else {
		alert('city can have alphabet characters only');
		// city.focus();
		return false;
	}
}
function validatezipcode(zip) {
	var numbers = /^\d{5}(-\d{4})?$/;
	if (numbers.test(zip)) {
		return true;
	} else {
		alert('Zip code must have numeric characters only');
		// zip.focus();
		return false;
	}
}
function validatestate(state) {
	if (state == "Default") {
		alert('Select your states from the list');
		return false;
	} else {
		return true;
	}

}

function validatecountry(country) {
	if (country == "Default") {
		alert('Select your country from the list');
		return false;
	} else {
		return true;
	}

}
