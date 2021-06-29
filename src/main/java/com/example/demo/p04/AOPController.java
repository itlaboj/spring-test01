package com.example.demo.p04;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AOPController {
	@Autowired
	private HttpSession session;

	//http://localhost:8080/aspect01
	@RequestMapping("/aspect01")
	public ModelAndView aspect01(ModelAndView mv) {
		session.invalidate();

		mv.setViewName("p04/aspect01"); //フォワード先
		return mv;
	}

	//http://localhost:8080/aspect02
	@RequestMapping("/aspect02")
	public ModelAndView aspect02(ModelAndView mv) {
		session.setAttribute("NAME", "山田太郎");

		String name = (String)session.getAttribute("NAME");
		mv.addObject("name", name);

		mv.setViewName("p04/aspect02"); //フォワード先
		return mv;
	}

	//http://localhost:8080/aspect03
	@RequestMapping("/aspect03")
	public ModelAndView aspect03(ModelAndView mv) {
		String name = (String)session.getAttribute("NAME");
		mv.addObject("name", name);

		mv.setViewName("p04/aspect03"); //フォワード先
		return mv;
	}
}
