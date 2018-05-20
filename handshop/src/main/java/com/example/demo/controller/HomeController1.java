package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
public class HomeController1 {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/home1" , method = RequestMethod.GET)
	public String productList(Model model) {
//		ProductDAO productDAO = new ProductDAO();
		model.addAttribute("listProducts", productService.getAllProduct());
		model.addAttribute("listCate", categoryService.getAllCategories());
		return "index";
	}
	

	@RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
	public String singleProduct(@PathVariable int id, Model model) {
		
		model.addAttribute("singleProduct", productService.getProduct(id));
		
		return "single";
	}

}
