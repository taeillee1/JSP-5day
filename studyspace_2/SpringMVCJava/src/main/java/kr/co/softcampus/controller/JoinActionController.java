package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinActionController {
	@RequestMapping(value="/joinAction", method = RequestMethod.POST)
	public String joinAction() {
		return "joinAction";
	}
}
