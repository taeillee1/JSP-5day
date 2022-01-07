package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WriteActionController {
	@RequestMapping(value="/writeAction", method = RequestMethod.POST)
	public String WriteAction() {
		return "writeAction";
	}
}
