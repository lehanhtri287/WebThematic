package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.ProductDAO;

@Controller
public class HomeController1 {
	@RequestMapping(value = { "/home1" }, method = RequestMethod.GET)
	public String productList(Model model) {
		ProductDAO productDAO = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		model.addAttribute("listProducts", productDAO.getAllProduct());
		model.addAttribute("listCate", categoryDAO.getAllCategory());
		return "index";
	}
	
}
