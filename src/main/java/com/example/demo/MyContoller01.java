package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyContoller01 {
	//http://localhost:8080/testで実行時に下記メソッドが呼び出される
	@RequestMapping("/test")
	public String test() {
		return "山田太郎";
	}

	//http://localhost:8080/test2で実行時に下記メソッドが呼び出される
	@RequestMapping("/test2")
	public String test2() {
		String name = "山田太郎";
		int age = 22;

		return name + "<br>" + age;
	}

	//http://localhost:8080/test3で実行時に下記メソッドが呼び出される
	//@RequestMapping(value="/test3", method=RequestMethod.POST)
	//required=falseリクエストパラメータが指定されなかった場合、引数の値はnullになる
	@PostMapping("/test3")
	public String test3(
		@RequestParam("NAME") String name,
		@RequestParam("AGE") int age,
		@RequestParam(name="COMPANY", required=false) String[] company
	) {
		String result = "";

		if (company == null) {
			result = "好きな会社はありません。";
		} else {
			for (String com : company) {
				result += " " + com;
			}
		}

		return name + "<br>" + age + "<br>" + result;
	}

	//http://localhost:8080/test4/・・・/・・・/で実行時に下記メソッドが呼び出される
	//http://localhost:8080/test4/山田太郎/22
	@RequestMapping(value="/test4/{NAME}/{AGE}")
	public String test4(
		@PathVariable("NAME") String name,
		@PathVariable("AGE") int age
	) {
		return name + "<br>" + age;
	}
}
