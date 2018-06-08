package com.example.demo.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping(value = "sign-up", method = RequestMethod.GET)
	public String signUpPage(Model model) {
		model.addAttribute("accountSignup", new AccountSignup());
		model.addAttribute("listCate", categoryService.getAllCategories());
		return "signUp";
	}

	@RequestMapping(value = "sign-up", method = RequestMethod.POST)
	public ModelAndView signUpProcess(@Validated AccountSignup accountSignup, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		String emailAlreadyExists = accountService.findByEmail(accountSignup.getEmail());
		Account account = getAccountFromAccountSignup(accountSignup);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<AccountSignup>> violations = validator.validate(accountSignup); // errors
																								// list

		if (emailAlreadyExists != null) {
			bindingResult.rejectValue("email", "accSignup.email.exists");
		}
		if (bindingResult.hasErrors()) {
			mav.addObject("listCate", categoryService.getAllCategories());
			mav.setViewName("signUp");
			for (ConstraintViolation<AccountSignup> violation : violations) {
				LOGGER.error("+ " + violation.getMessage());
			}
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

	// @RequestMapping(value = "sign-up/validateEmail", method =
	// RequestMethod.POST)
	// public ModelAndView signUpValidate(String email) {
	// ModelAndView mav = new ModelAndView();
	// String emailAlreadyExists = accountService.findByEmail(email);
	// if (emailAlreadyExists != null) {
	// mav.addObject("listCate", categoryService.getAllCategories());
	// mav.addObject("emailAlreadyExists", "Email đã tồn tại");
	// mav.setViewName("signUp");
	// }
	// return mav;
	// }

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
	public ModelAndView loginProcess(@Validated @ModelAttribute("accLogin") AccountLogin accountLogin,
			BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		Account account = accountService.findByEmailAndPassword(accountLogin);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<AccountLogin>> violations = validator.validate(accountLogin); // errors list

		if (accountLogin.getEmail() == null || accountLogin.getEmail() == "")
			bindingResult.rejectValue("email", "accLogin.empty");
		else {
			if (account == null) {
				bindingResult.rejectValue("email", "accLogin.invalid");
			}
		}
		if (bindingResult.hasErrors()) {
			mav.addObject("listCate", categoryService.getAllCategories());
			mav.setViewName("login");
			for (ConstraintViolation<AccountLogin> violation : violations) {
				LOGGER.error("+ " + violation.getMessage());
			}
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
