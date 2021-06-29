package com.example.demo.p04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RandomStringController {

	@Autowired
	RandomStringGenerator gen;

	@RequestMapping("/random")
	public String index() {
		return "p04/random";
	}

	@RequestMapping(value="/generate", method=RequestMethod.POST)
	public ModelAndView generate(
			@RequestParam("charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "") String withNumber,
			ModelAndView mv
	) {
		boolean withNumFlag = "1".equals(withNumber);
		List<String> randomStringList = gen.generate(charLength, withNumFlag);
		mv.addObject("randList", randomStringList);

		mv.setViewName("p04/random");
		return mv;
	}
}
