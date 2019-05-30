package com.gslab.akshay.controller;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gslab.akshay.pojo.Employee;
import com.gslab.akshay.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class HomeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/send")
	public String getDetails() {

		return "display";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerEmployee(@RequestParam("first_name") String fname,
			@RequestParam("last_name") String sname, @RequestParam("empNo") String empNo) throws NamingException {
		System.out.println("ïnside rregisterEmployee() in controller");
		Employee emp = new Employee(fname, sname, empNo);
		service.registerEmployee(emp);
		System.out.println("emp added successfully");
		return new ModelAndView("redirect:/employee/display");
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ModelAndView gotoHome() {
		return new ModelAndView("redirect:/display");
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getEmployee(@RequestParam("first_name") String fName) throws NamingException {
		Employee emp = service.getEmployee(fName);
		return new ModelAndView("/details", "Employee", emp);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("first_name") String fname) throws NamingException {
		System.out.println("ïnside deleteEmployee() in controller");
		System.out.println("this emp deleted successfully");
		return service.deleteEmployee(fname);
		//return new ModelAndView("redirect:/employee/delete");
	}
	@RequestMapping(value="/update", method=RequestMethod.POST )
	public String updateEmployee(@RequestParam("first_name") String fname,
			@RequestParam("last_name") String sname, @RequestParam("empNo") String empNo) throws NamingException{
		Employee emp = new Employee();
		emp.setEmpNo(empNo);
		emp.setFname(fname);
		emp.setSname(sname);
		service.updateEmployee(emp);
		System.out.println("this emp updated successfully");
		return "this emp updated successfully ...!!";
	}
}
