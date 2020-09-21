package culong.com.Construction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/loginConstruct", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model) {

		return "homeConstruct";
	}
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String logout(Model model) {

		return "login";
	}
}
