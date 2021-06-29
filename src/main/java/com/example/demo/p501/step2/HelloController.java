package com.example.demo.p501.step2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//http://localhost:8080/hello?name=リナクス太郎&age=25
	@GetMapping("/hello")
	public String helloQueryString(
			@RequestParam("name") String name,
			@RequestParam("age") int age
			) {

		return "こんにちは" + name + "さん。10年後は" + (age + 10) + "歳ですね！";
	}

	//http://localhost:8080/hello/リナクス太郎/25
	@RequestMapping("/hello/{name}/{age}")
	public String helloPathParameter(
			@PathVariable("name") String name,
			@PathVariable("age") int age
			) {

		return "こんにちは" + name + "さん。10年後は" + (age + 10) + "歳ですね！";
	}

}
