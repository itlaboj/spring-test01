package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyContoller02 {
	//http://localhost:8080/th01で実行時に下記メソッドが呼び出される
	@RequestMapping("/th01")
	public String th01(Model m) {
		//Modelにデータをセットする
		m.addAttribute("COMPANY", "株式会社ID");

		return "th01";
	}

	//http://localhost:8080/th02で実行時に下記メソッドが呼び出される
	@RequestMapping("/th02")
	public ModelAndView th02(ModelAndView mv) {
		//配列にデータを格納
		String[] ary = {"田中", "大久保", "外村"};

		//ArrayListにデータを格納
		ArrayList<String> list = new ArrayList<String>();

		list.add("秋山");
		list.add("立花");
		list.add("城");

		//Userクラスのインスタンスを生成
		User user = new User(1, "山田太郎");

		//年月日　時分秒
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");


		//ModelAndViewにデータをセットする
		mv.addObject("COMPANY", "株式会社ID");
		mv.addObject("ARY", ary);
		mv.addObject("LIST", list);
		mv.addObject("AGE", 22);
		mv.addObject("DATA", 1);
		mv.addObject("USER", user);
		mv.addObject("TIME", time.format(dtf));

		mv.setViewName("th02"); //遷移先のThymeleafの設定

		return mv;
	}
}
