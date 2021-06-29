package com.example.demo.p501.step4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

	//http://localhost:8080/birthday/1995/11/1
	@RequestMapping("/birthday/{year}/{month}/{day}")
	public String showAge(
			@PathVariable("year") int year,
			@PathVariable("month") int month,
			@PathVariable("day") int day
			) {

		// 受け取った年月日でLocalDateのオブジェクトを生成
		LocalDate birthday = LocalDate.of(year, month, day);

		// 現在日付
		LocalDate today = LocalDate.now();

		// 二つの年数の差分を計算
		long age = ChronoUnit.YEARS.between(birthday, today);

		// 返却
		//return "" + age;
		return String.valueOf(age);
	}

}
