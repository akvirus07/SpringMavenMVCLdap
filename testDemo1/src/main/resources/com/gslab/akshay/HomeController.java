package com.gslab.akshay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/test")
public class HomeController {
	public String getEmployee() {
		return "test";
	}
}