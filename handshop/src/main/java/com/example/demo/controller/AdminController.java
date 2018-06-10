package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.AccountService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;

@Controller
public class AdminController {

	@Autowired
	AccountService accountService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView indexAdmin() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("productSize", productService.size());
		mav.addObject("orderSize", orderService.size());
		mav.addObject("accountSize", accountService.size());
		mav.addObject("newProducts", productService.getNewProducts());
		mav.addObject("newOrders", orderService.getNewOrders());
		mav.setViewName("/admin/indexAdmin");

		return mav;
	}
	@RequestMapping(value = "/admin/manageProduct", method = RequestMethod.GET)
	public ModelAndView manageProduct() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("productSize", productService.size());
		mav.setViewName("/admin/product");
		
		return mav;
	}
	@RequestMapping(value = "/admin/insertProduct", method = RequestMethod.GET)
	public ModelAndView insertProduct() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("listCategories", categoryService.getAllCategories());
		mav.setViewName("/admin/add_product");
		
		return mav;
	}
	@RequestMapping(value = "/admin/insertProduct", method = RequestMethod.GET)
	public String insertProduc(Model model) {
		return "";
	}
}
