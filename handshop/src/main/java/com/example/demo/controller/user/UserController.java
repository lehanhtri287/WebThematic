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
import com.example.demo.model.AccountPassUpdating;
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
	public String updateInfoPage(HttpSession session, @ModelAttribute("message") String message, Model model){
		if (session.getAttribute("user") != null) {
			model.addAttribute("message", message);
			model.addAttribute("account", new Account());
			model.addAttribute("listCate", categoryService.getAllCategories());
			return "user/updateInfo";
		} else {
			model.addAttribute("message", "Bạn chưa đăng nhập");
			return "user/updateInfo";
		}
	}
	
	@RequestMapping(value = "info", method = RequestMethod.POST)
	public ModelAndView updateInfoProcess(@Validated Account account,
			BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
			ModelAndView mav = new ModelAndView();
		if (session.getAttribute("user") != null) {
			if (!account.getPassword().equals("")) {
				if (accountService.updateAccountInfo(account)){
					redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
					session.setAttribute("user", account);
					mav.setViewName("redirect:/user/info");
				} else {
					bindingResult.rejectValue("password", "field.password.wrong");
				}
			} else {
				bindingResult.rejectValue("password", "field.empty");
			}
			if(bindingResult.hasErrors()) mav.setViewName("user/updateInfo");
		} else {
			mav.addObject("message", "Bạn chưa đăng nhập");
			mav.setViewName("user/updateInfo");
		}
		return mav;
	}
	
	@RequestMapping(value = "info/password", method = RequestMethod.GET)
	public String updatePasswordPage(HttpSession session, @ModelAttribute("message") String message, Model model){
		if (session.getAttribute("user") != null) {
			model.addAttribute("message", message);
			model.addAttribute("accountPassUpdating", new AccountPassUpdating());
			model.addAttribute("listCate", categoryService.getAllCategories());
			return "user/updatePassword";
		} else {
			model.addAttribute("message", "Bạn chưa đăng nhập");
			return "user/updatePassword";
		}
	}
	
	@RequestMapping(value = "info/password", method = RequestMethod.POST)
	public ModelAndView updatePasswordProcess(@Validated AccountPassUpdating accountPassUpdating,
			BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
			ModelAndView mav = new ModelAndView();
		if (session.getAttribute("user") != null) {
			if (accountPassUpdating.getNewPassword().equals(accountPassUpdating.getConfirmNewPassword())){
				Account account = accountService.updateAccountPassWord(accountPassUpdating);
				if (account != null){
					redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
					session.setAttribute("user", account);
					mav.setViewName("redirect:/user/info/password");
				} else {
					bindingResult.rejectValue("password", "field.password.wrong");
				}
			} else {
				bindingResult.rejectValue("newPassword", "field.password.notMatch");
			}
			if(bindingResult.hasErrors()) mav.setViewName("user/updatePassword");
		} else {
			mav.addObject("message", "Bạn chưa đăng nhập");
			mav.setViewName("user/updatePassword");
		}
		return mav;
	}
}
