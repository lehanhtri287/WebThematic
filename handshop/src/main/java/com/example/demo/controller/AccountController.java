package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Account;
import com.example.demo.model.AccountLogin;
import com.example.demo.model.AccountSignup;
import com.example.demo.service.AccountService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/account/")
public class AccountController {

	@Autowired
	AccountService accountService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@RequestMapping(value = "sign-up", method = RequestMethod.GET)
	public String signUpPage(Model model) {
		model.addAttribute("accountSignup", new AccountSignup());
		model.addAttribute("listCate", categoryService.getAllCategories());
		return "signUp";
	}

	@RequestMapping(value = "sign-up", method = RequestMethod.POST)
	public ModelAndView signUpProcess(@Validated AccountSignup accountSignup, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		String emailAlreadyExists = null;
		Account account = null;
		
		if (!accountSignup.getEmail().contains(" ")) {
			emailAlreadyExists = accountService.findByEmail(accountSignup.getEmail());
			account = getAccountFromAccountSignup(accountSignup);
		}
		if (accountSignup.getPassword() != "" && accountSignup.getConfirmPassword() != ""){
			if (!accountSignup.getPassword().equals(accountSignup.getConfirmPassword())){
				bindingResult.rejectValue("password", "accSignup.password.notMatch");
			}
		}
		if (emailAlreadyExists != null) bindingResult.rejectValue("email", "accSignup.email.exists");
		if (bindingResult.hasErrors()) {
			mav.addObject("listCate", categoryService.getAllCategories());
			mav.setViewName("signUp");
		} else {
			if (accountService.signUp(account)) {
				mav.addObject("successMess", "Đăng ký thành công");
				mav.addObject("accountSignup", new AccountSignup());
				mav.addObject("listCate", categoryService.getAllCategories());
				mav.setViewName("signUp");
			}
		}
		return mav;
	}

	public Account getAccountFromAccountSignup(AccountSignup accountSignup) {
		Account account = new Account(accountSignup.getEmail(), accountSignup.getPassword(),
				accountSignup.getFullName(), accountSignup.getAddress(), accountSignup.getPhoneNumber());
		return account;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("listCate", categoryService.getAllCategories());
		model.addAttribute("accLogin", new AccountLogin());
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView loginProcess(@Validated @ModelAttribute("accLogin") AccountLogin accountLogin, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		Account account = accountService.findByEmailAndPassword(accountLogin);

		if (accountLogin.getEmail().contains(" ")) bindingResult.rejectValue("email", "accSignup.email.invalid");
		if (accountLogin.getEmail() == "") bindingResult.rejectValue("email", "accLogin.empty");
		if (accountLogin.getEmail() != "" && accountLogin.getPassword() != "") {
			if (account == null) {
				bindingResult.rejectValue("email", "accLogin.invalid");
			}
		}
		if (bindingResult.hasErrors()) {
			mav.addObject("listCate", categoryService.getAllCategories());
			mav.setViewName("login");
		} else {
			mav.addObject("listCate", categoryService.getAllCategories());
			mav.addObject("listProducts", productService.getAllProduct());
			mav.addObject("loginSuccess", "Login successful");
			mav.setViewName("index");
		}
		return mav;
	}

	@RequestMapping(value = "forgot-password", method = RequestMethod.GET)
	public String forgotPasswordPage(Model model) {
		model.addAttribute("listCate", categoryService.getAllCategories());
		return "forgotPass";
	}
}
