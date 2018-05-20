package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.serviceImpl.CategoryServiceImpl;
import com.example.demo.serviceImpl.ProductServiceImpl;

@Controller
public class HomeController1 {
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

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
	@RequestMapping(value = "/viewByCate/{idCate}", method = RequestMethod.GET)
	public String listProductsByCate(@PathVariable int idCate, Model model) {
		model.addAttribute("listProducts", productService.getProductByCate(idCate));

		return "index";
	}

}
