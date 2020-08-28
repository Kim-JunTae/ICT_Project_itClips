package com.ict.itClips;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String intro() {
		return "intro";
	}
	
	@RequestMapping(value = "moviePoster", method = RequestMethod.GET)
	public String moviePoster() {
		return "moviePoster";
	}
	
	@RequestMapping(value = "userHome", method = RequestMethod.GET)
	public String userHome() {
		return "userHome";
	}
	
	@RequestMapping(value="myPage", method = RequestMethod.GET)
	public String myPage() {
		return "myPage";
	}
	
	@RequestMapping(value="support", method = RequestMethod.GET)
	public String support() {
		return "support";
	}
}
