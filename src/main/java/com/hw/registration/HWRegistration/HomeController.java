package com.hw.registration.HWRegistration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hw.registration.HWRegistration.entity.Users;
import com.hw.registration.HWRegistration.repo.UserDao;
import com.hw.registration.HWRegistration.repo.UserRepository;

/**
 * @author Jill Xu
 *
 */
@Controller
@Validated
public class HomeController {
	private static final Pattern alnumpattern = Pattern.compile("^[0-9a-zA-Z\\s]+$"); // address
	private static final Pattern alphpattern = Pattern.compile("^[A-Za-z\\s]+$"); // fname, lname, city
	private static final Pattern zippattern = Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$");// zipcode
	private static final Pattern statepattern = Pattern.compile(
			"^(AA|AE|AP|AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY)$");

	@Autowired
	UserRepository ur;

	@Autowired
	UserDao udao;

	@RequestMapping("/")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/register" )
	public ModelAndView confirm(
			@RequestParam("fName") @Size(min = 1, max = 45, message = "First Name cannot exceed 45 characters, please return and try again\n") String fname,
			@RequestParam("lName") @Size(min = 1, max = 45, message = "Last Name cannot exceed 45 characters, please return and try again\n") String lname,
			@RequestParam("address1") @Size(min = 1, max = 200, message = "Address1 cannot exceed 200 characters, please return and try again\n") String add1,
			@RequestParam("address2") @Size(min = 0, max = 100, message = "Address2 cannot exceed 100 characters, please return and try again\n") String add2,
			@RequestParam("city") @Size(min = 1, max = 45, message = "City cannot exceed 45 characters, please return and try again\n") String city,
			@RequestParam("state") String state, @RequestParam("zip") String zip,
			@RequestParam("country") String country) {

		// create validation matcher for each param
		Matcher matcherfname = alphpattern.matcher(fname);
		Matcher matcherlname = alphpattern.matcher(lname);
		Matcher matcheradd1 = alnumpattern.matcher(add1);
		Matcher matcheradd2 = alnumpattern.matcher(add2);
		Matcher matchercity = alphpattern.matcher(city);
		Matcher matcherstate = statepattern.matcher(state);
		Matcher matcherzip = zippattern.matcher(zip);
		
		//set up successful massage if all validation passed
		String message = " Congratulations! Your registration is successful.";
		boolean validated = true;

		// validation of the input, send message back
		if (!matcherfname.matches() || !matcherlname.matches()) {
			message = "Invalid name input, Please try again";
			validated = false;
		}
		if (!matcheradd1.matches()) {
			message = "Invalid address input, Please try again.";
			validated = false;
		}
		if (add2 != "" &&!matcheradd2.matches()) {
			message = "Invalid address input, Please try again.";
			validated = false;
		}
		if (!matchercity.matches()) {
			message = "Invalid city input, Please try again.";
			validated = false;
		}
		if (!matcherstate.matches()) {
			message = "Invalid state input, Please try again.";
			validated = false;
		}
		if (!matcherzip.matches()) {
			message = "Invalid zipcode input, Please try again.";
			validated = false;
		}
		if (!country.matches("US")) {
			message = "The country can only be US, Please try again.";
			validated = false;
		}
		
		if (validated) {
			// getting current date & time
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);

			// creating user object include all the information
			Users user = new Users(fname, lname, add1, add2, city, state, zip, country, currentTime);

			// insert into database
			udao.addUser(user);
		}

		return new ModelAndView("confirmation", "message", message);
	}

	@RequestMapping("/adminreport")
	public ModelAndView report() {
		List<Users> uReport = ur.findAll();
		Collections.sort(uReport);
		Collections.reverse(uReport);
		return new ModelAndView("adminReport", "report", uReport);
	}

	
}
