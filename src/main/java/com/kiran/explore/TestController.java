package com.kiran.explore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String welcomePage() {
		return "welcome page";
	}

	@GetMapping("/user")
	public String userPage() {
		return "welcome user";
	}

	@GetMapping("/admin")
	public String adminPage() {
		return "admin page";
	}

}
