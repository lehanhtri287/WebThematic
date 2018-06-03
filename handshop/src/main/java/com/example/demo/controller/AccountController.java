package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.Taikhoan;
import com.example.demo.model.TaikhoanSignup;
import com.example.demo.service.CategoryService;
import com.example.demo.service.TaikhoanService;

@Controller
@RequestMapping("/account/")
public class AccountController {
	
	@Autowired TaikhoanService taikhoanService;
	@Autowired CategoryService categoryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping(value="sign-up", method=RequestMethod.GET)
	public String signUpPage(Model model){
		model.addAttribute("taikhoanSignup", new TaikhoanSignup());
		model.addAttribute("listCate", categoryService.getAllCategories());
		return "signUp";
	}
	
	@RequestMapping(value="sign-up", method=RequestMethod.POST)
	public ModelAndView signUpProcess(@Validated TaikhoanSignup taikhoanSignup,
			BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
		ModelAndView mav = new ModelAndView();
		String emailAlreadyExists = taikhoanService.findByEmail(taikhoanSignup.getTenDangnhap());
		LOGGER.info("- emailAlreadyExists " + emailAlreadyExists);
		Taikhoan taikhoan = getTaikhoanFromTaikhoanSignup(taikhoanSignup);
		try{
			if(emailAlreadyExists != null) {
				bindingResult.rejectValue("tenDangnhap", "tenDangnhapError", "accSignup.email.exists");
				LOGGER.error("- Email da ton tai");
			}
			if(bindingResult.hasErrors()) {
				mav.setViewName("signUp");
				LOGGER.error("- Co loi email ton tai");
			} else if(!bindingResult.hasErrors()){
				if(taikhoanService.signUp(taikhoan)){
					mav.addObject("successMess", "Sign up successful");
					mav.addObject("taikhoanSignup", new TaikhoanSignup());
					mav.setViewName("signUp");
					LOGGER.info("- inserted");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	public Taikhoan getTaikhoanFromTaikhoanSignup(TaikhoanSignup taikhoanSignup){
		Taikhoan taikhoan = new Taikhoan(taikhoanSignup.getTenDangnhap(), taikhoanSignup.getMatKhau(),
				taikhoanSignup.getTenKh(), taikhoanSignup.getDiachi(), taikhoanSignup.getSdt());
		return taikhoan;
	}
	
	@RequestMapping("login")
	public String loginPage(Model model){
		model.addAttribute("listCate", categoryService.getAllCategories());
		return "login";
	}
	@RequestMapping("forgot-password")
	public String forgotPasswordPage(Model model){
		model.addAttribute("listCate", categoryService.getAllCategories());
		return "forgotPass";
	}
}
