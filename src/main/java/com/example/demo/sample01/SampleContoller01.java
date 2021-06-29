package com.example.demo.sample01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleContoller01 {
	//http://localhost:8080/th03で実行時に下記メソッドが呼び出される
	@RequestMapping("/sample01")
	public ModelAndView sample01(ModelAndView mv) {

		ID id = new Test01();
		id.execute(10, 20, mv);

		return mv;
	}
}
