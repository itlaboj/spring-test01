package com.example.demo.sample01;

import org.springframework.web.servlet.ModelAndView;

public class Test01 implements ID {

	@Override
	public void execute(int x, int y, ModelAndView mv) {
		//Thymeleafで表示するデータを設定
		mv.addObject("result", x + y);

		mv.setViewName("sample01"); //遷移先のThymeleafの設定
	}

}
