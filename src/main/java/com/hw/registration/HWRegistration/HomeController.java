package com.hw.registration.HWRegistration;



import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hw.registration.HWRegistration.entity.Users;
import com.hw.registration.HWRegistration.repo.UserDao;
import com.hw.registration.HWRegistration.repo.UserRepository;
import com.mysql.jdbc.PreparedStatement.ParseInfo;

@Controller
public class HomeController {

	@Autowired
	UserRepository ur;
	
	@Autowired
	UserDao udao;

	@RequestMapping("/")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping("/register")
	public ModelAndView confirm(@RequestParam("fName") String fname, @RequestParam("lName") String lname,@RequestParam("address1") String add1, @RequestParam("address2") String add2,@RequestParam("city") String city,
	@RequestParam("state") String state,@RequestParam("zip") String zip,@RequestParam("country") String country) {
		//getting current date & time
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		//Integer zipNum = Integer.parseInt(zip.replace("-", ""));
		// creating user object include all the information
		Users user = new Users(fname, lname, add1, add2, city, state, zip, country, currentTime);
		
		//insert into database
		udao.addUser(user);
		
		return new ModelAndView("confirmation","name",fname+" "+lname);
	}

	@RequestMapping("/adminreport")
	public ModelAndView report() {
		List<Users> uReport = ur.findAll();
		Collections.sort(uReport);
		Collections.reverse(uReport);
		return new ModelAndView("adminReport", "report",uReport);
	}
}
