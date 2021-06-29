package com.example.demo.p501.step1;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OmikujiController {

	//http://localhost:8080/omikuji
	@RequestMapping("/omikuji")
	public String omikuji() {
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

//		switch (dice) {
//		case 1 :
//			ans = "大吉";
//			break;
//		case 2 :
//			ans = "小吉";
//			break;
//		case 3 :
//			ans = "凶";
//			break;
//		}

		return ans;
	}
}
