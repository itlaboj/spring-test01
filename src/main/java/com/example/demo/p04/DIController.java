package com.example.demo.p04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DIController {

	//http://localhost:8080/test01
	@RequestMapping("/test01")
	public ModelAndView test01(ModelAndView mv) {
		USB usb = new Memory();
		//USB usb = new WebCamera();

		PC pc = new PC(usb);
		pc.setMessage(mv);

		mv.setViewName("p04/test01");
		return mv;
	}
}
