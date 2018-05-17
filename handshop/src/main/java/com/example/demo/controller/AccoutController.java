package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/")
public class AccoutController {
	
	@RequestMapping("sign-up")
	public String signUpPage(){
		return "signUp";
	}
	
	@RequestMapping("login")
	public String loginPage(){
		return "login";
	}
	@RequestMapping("forgot-password")
	public String forgotPasswordPage(){
		return "forgotPass";
	}
}
