package com.example.demo;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OmikujiController502 {
	//http://localhost:8080/omikuji502で実行時に下記メソッドが呼び出される
	@PostMapping("/omikuji502")
	public ModelAndView omikuji(
			ModelAndView mv,
			@RequestParam("NAME") String name) {
		Random rand = new Random();

		String ans = "吉";
		int dice = rand.nextInt(6) + 1; // サイコロを振る

		if (dice == 1) {
			ans = "大吉";
		} else if (dice == 2) {
			ans = "小吉";
		} else if (dice == 3) {
			ans = "凶";
		}

		name = name.equals("") ? "ゲストさん" : name;

		mv.addObject("NAME", name);
		mv.addObject("RESULT", ans);

		mv.setViewName("omikujiResult"); //遷移先のThymeleafの設定

		return mv;
	}
}
