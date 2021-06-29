package com.example.demo.p04;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringGenerator {
	private final static int GENERATE_NUM = 10;

	public List<String> generate(int charLength, boolean withNumber) {
		List<String> list = new ArrayList<String>();

		for(int i = 0; i < GENERATE_NUM; i++) {
			if(withNumber) {
				//「半角アルファベットの大文字と小文字」を使用して
				//ランダムな文字列を生成する。（引数は桁数）
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else {
				//「半角アルファベットの大文字と小文字」に加え「半角数字」を使用して
				//ランダムな文字列を生成する。（引数は桁数）
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			}
		}
		return list;
	}
}
