package com.example.demo.p04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCController01 {
	@Autowired
	Ohno o;

	//http://localhost:8080/
	@RequestMapping("/")
	public String index() {
		return "p04/tasu";
	}

	//http://localhost:8080/mvc01
	@PostMapping("/mvc01")
	public ModelAndView mvc01(
			ModelAndView mv,
			@RequestParam("DATA1") int x,
			@RequestParam("DATA2") int y
			) {
		//Ohno o = new Ohno();
		int result = o.tasu(x, y);

		mv.addObject("RESULT", result);

		mv.setViewName("p04/soku");
		return mv;
	}
}
