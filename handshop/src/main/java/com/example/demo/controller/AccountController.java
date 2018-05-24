package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Taikhoan;
import com.example.demo.service.TaikhoanService;

@Controller
@RequestMapping("/account/")
public class AccountController {
	@Autowired
	TaikhoanService taikhoanService;
	
	@RequestMapping("sign-up")
	public String signUpPage(Model model){
		model.addAttribute(new Taikhoan());
		return "signUp";
	}
	
	@RequestMapping(value="sign-up/process", method=RequestMethod.POST)
	public String signUpProcess(Model model, Taikhoan taikhoan){
		String responseMessage = null;
		try{
			if(taikhoanService.signUp(taikhoan)){
				responseMessage = "Sign up successful";
				model.addAttribute("responseMessage", responseMessage);
				return "responePage";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		responseMessage = "Sign up fail";
		return "redirect:/account/sign-up";
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
