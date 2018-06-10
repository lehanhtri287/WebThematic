package com.example.demo.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.CategoryService;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String infoPage(HttpSession session, @ModelAttribute("message") String message, Model model){
		if (session.getAttribute("user") != null) {
			model.addAttribute("message", message);
			model.addAttribute("accInfoUpdating", new Account());
			model.addAttribute("listCate", categoryService.getAllCategories());
			return "user/userInfo";
		} else {
			model.addAttribute("message", "Bạn chưa đăng nhập");
			return "user/userInfo";
		}
	}
	
	@RequestMapping(value = "info", method = RequestMethod.POST)
	public ModelAndView loginProcess(@Validated @ModelAttribute("accInfoUpdating") Account account,
			BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
			ModelAndView mav = new ModelAndView();
		if (session.getAttribute("user") != null) {
			if (accountService.updateAccountInfo(account)){
				redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
				session.setAttribute("user", account);
				mav.setViewName("redirect:/user/info");
			} else {
				bindingResult.rejectValue("password", "accUpdateInfo.password.wrong");
			}
			if(bindingResult.hasErrors()) mav.setViewName("user/userInfo");
		} else {
			mav.addObject("message", "Bạn chưa đăng nhập");
			mav.setViewName("user/userInfo");
		}
		return mav;
	}
}
