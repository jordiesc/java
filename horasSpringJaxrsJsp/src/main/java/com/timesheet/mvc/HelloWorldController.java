package com.timesheet.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class HelloWorldController {

	@RequestMapping("/holamundo")
	public String helloWorld(Model model) {
		model.addAttribute("procedencia", "soc catala");
		return "hello-world";
	}

}