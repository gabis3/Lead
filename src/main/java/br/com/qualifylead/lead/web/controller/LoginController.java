package br.com.qualifylead.lead.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class LoginController {
	@GetMapping("/logar")
	public String logar() {
		return "/usuario/login";
	}
}