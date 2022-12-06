package br.com.qualifylead.lead.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@GetMapping
	@RequestMapping("/logout")
	public String sair() {
		return "logout";
	}
}
