package com.example.demo.p04;

import org.springframework.web.servlet.ModelAndView;

public class PC {
	//フィールド
	private USB usb;

	//コンストラクタ
	public PC(USB usb) {
		this.usb = usb;
	}

	public void setMessage(ModelAndView mv) {
		String message = usb.getMessage();

		mv.addObject("message", message);
	}
}
