package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyContoller03 {
	//HttpSessionのインスタンスを生成
	//HttpSession session = request.getSession(true);
	@Autowired
	private HttpSession session;

	//http://localhost:8080/th03で実行時に下記メソッドが呼び出される
	@RequestMapping("/th03")
	public ModelAndView th03(ModelAndView mv) {

		//セッション・オブジェクトにキー「COUNT」で格納されているデータを取得
		Integer count = (Integer)session.getAttribute("COUNT");

		if (count == null) {
			count = 0;
		}

		count++;

		//セッション・オブジェクトにキー「COUNT」でカウント値を格納
		session.setAttribute("COUNT", count);

		if (count >= 10) {
			session.removeAttribute("COUNT");
			//session.invalidate();
		}

		//Thymeleafで表示するデータを設定
		mv.addObject("count", count);

		mv.setViewName("th03"); //遷移先のThymeleafの設定

		return mv;
	}
}
