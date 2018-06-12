package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Product;
import com.example.demo.service.AccountService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.FileStorageService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;

@Controller
public class AdminController {
	private final int PAGE_SIZE = 5;
	@Autowired
	AccountService accountService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	@Autowired
	FileStorageService fileStorageService;

	@RequestMapping(value = { "/admin/index", "/admin/" }, method = RequestMethod.GET)
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
		mav.addObject("numPages", productService.getNumPages(PAGE_SIZE));
		mav.addObject("products", productService.getProductsPagination(1, PAGE_SIZE));
		mav.setViewName("/admin/product");

		return mav;
	}
	@RequestMapping(value = "/admin/manageProduct/{page}", method = RequestMethod.GET)
	public ModelAndView manageProductPage(@PathVariable int page) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("productSize", productService.size());
		mav.addObject("numPages", productService.getNumPages(PAGE_SIZE));
		mav.addObject("products", productService.getProductsPagination(page, PAGE_SIZE));
		mav.setViewName("/admin/product");

		return mav;
	}
	
	@RequestMapping(value = "/admin/insertProduct", method = RequestMethod.GET)
	public ModelAndView showAddProduct() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("listCategories", categoryService.getAllCategories());
		mav.setViewName("/admin/add_product");

		return mav;
	}

	@RequestMapping(value = "/admin/insertProduct", method = RequestMethod.POST)
	public String insertProduct(Product product, int idcategory, @RequestParam("imageFile") MultipartFile multipartFile,
			Model model) {
		try {
			fileStorageService.store(multipartFile);
			product.setImages("images/" + multipartFile.getOriginalFilename());
			product.setCategory(categoryService.getCategory(idcategory));

			productService.addProduct(product);

			model.addAttribute("message", "Thêm sản phẩm thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Đã xảy ra lỗi! Vui lòng kiểm tra đường dẫn hình ảnh");
		}

		return "/admin/result";
	}
	
	@RequestMapping(value = "/admin/editProduct/{idProduct}", method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int idProduct) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("singleProduct", productService.getProduct(idProduct));
		mav.addObject("listCategories", categoryService.getAllCategories());
		mav.setViewName("/admin/edit_product");

		return mav;
	}	
	@RequestMapping(value = "/admin/editProduct", method = RequestMethod.POST)
	public String editProduct(Product product, int idcategory, Model model) {
		
		product.setCategory(categoryService.getCategory(idcategory));
		boolean tmp = productService.editProduct(product);
		
		if(tmp) {
			model.addAttribute("message", "Chỉnh sửa sản phẩm thành công!");
		} else {
			model.addAttribute("message", "Đã xảy ra lỗi, vui lòng thử lại sau!");
		}
		
		return "/admin/result";
	}	
	
	@RequestMapping(value = "/admin/deleteProduct/{idProduct}", method = RequestMethod.GET)
	public String editProduct(@PathVariable int idProduct, Model model) {
		
		boolean tmp = productService.deleteProduct(idProduct);
		
		if(tmp) {
			model.addAttribute("message", "Xóa sản phẩm thành công!");
		} else {
			model.addAttribute("message", "Đã xảy ra lỗi, vui lòng thử lại sau!");
		}
		
		return "/admin/result";
	}	
	
	@RequestMapping(value = "/admin/manageCategory", method = RequestMethod.GET)
	public ModelAndView manageCategory() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("categories", categoryService.getAllCategories());
		mav.setViewName("/admin/category");

		return mav;
	}
	
	@RequestMapping(value = "/admin/addCategory", method = RequestMethod.GET)
	public ModelAndView showAddCategory() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("type", "Thêm danh mục");
		mav.setViewName("/admin/add_category");
		
		return mav;
	}
	
	@RequestMapping(value = "/admin/editCategory/{idCategory}", method = RequestMethod.GET)
	public ModelAndView showEditCategory(int idCategory) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("category", categoryService.getCategory(idCategory));
		mav.addObject("type", "Chỉnh sửa danh mục");
		mav.setViewName("/admin/add_category");
		
		return mav;
	}
}
