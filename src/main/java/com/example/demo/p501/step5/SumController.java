package com.example.demo.p501.step5;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

	//http://localhost:8080/sum/10
	@RequestMapping("/sum/{num}")
	public String sum(
			@PathVariable("num") int num) {
		int total = 0;

		for (int i = 1; i <= num; i++) {
			total += i;
		}

		//return "" + total;
		return String.valueOf(total);
	}

}
