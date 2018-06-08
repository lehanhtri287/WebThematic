package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Donhang;
import com.example.demo.entities.Sanpham;
import com.example.demo.model.ProductCart;
import com.example.demo.service.CategoryService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;

@SuppressWarnings("unchecked")
@Controller
public class ShoppingCartController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "shoppingcart", method = { RequestMethod.POST, RequestMethod.GET })
	public void addCart(int prodId, HttpSession session, Model model) {
		int result = 0;

		Sanpham sanpham = productService.getProduct(prodId);

		if (session.getAttribute("list_detail") == null) {
			List<ProductCart> details = new ArrayList<>();
			ProductCart productCart = new ProductCart(sanpham, 1);
			details.add(productCart);
			session.setAttribute("list_detail", details);
			result = details.size();
			session.setAttribute("size", result);
			System.out.println(details);
		} else {
			List<ProductCart> details = (ArrayList<ProductCart>) session.getAttribute("list_detail");
			boolean tmp = false;
			for (ProductCart detail : details) {
				if (prodId == detail.getProduct().getIdSanpham()) {
					detail.setQuantityCart(detail.getQuantityCart() + 1);
					tmp = true;
				}
			}
			if (!tmp) {
				details.add(new ProductCart(sanpham, 1));
			}
			result = details.size();
			session.setAttribute("list_detail", details);
			session.setAttribute("size", result);
//			System.out.println(details);
		}

	}

	@RequestMapping(value = "showCart", method = RequestMethod.GET)
	public String getCart(HttpSession session, Model model) {
		List<ProductCart> details = (ArrayList<ProductCart>) session.getAttribute("list_detail");
		int totalAmount = 0;

		if (details == null) {
			details = new ArrayList<>();
		}

		totalAmount = getTotalAmount(details);
		model.addAttribute("totalAmount", totalAmount);
		model.addAttribute("productsCart", details);
		model.addAttribute("listCate", categoryService.getAllCategories());
		session.setAttribute("size", details.size());

		return "shoppingCart";
	}

	@RequestMapping(value = "deletecart/{idProduct}", method = RequestMethod.GET)
	public String deleteProductCart(@PathVariable int idProduct, HttpSession session) {
		List<ProductCart> productCarts = (ArrayList<ProductCart>) session.getAttribute("list_detail");

		for (int i = productCarts.size() - 1; i >= 0; i--) {
			if (productCarts.get(i).getProduct().getIdSanpham() == idProduct) {
				productCarts.remove(productCarts.get(i));
			}
		}
		session.setAttribute("list_detail", productCarts);
		session.setAttribute("size", productCarts.size());

		return "forward:/showCart";
	}

	@RequestMapping(value = "plusProduct/{idProduct}", method = RequestMethod.GET)
	public String plusProduct(@PathVariable int idProduct, HttpSession session) {
		List<ProductCart> productCarts = (ArrayList<ProductCart>) session.getAttribute("list_detail");
		for (int i = productCarts.size() - 1; i >= 0; i--) {
			if (productCarts.get(i).getProduct().getIdSanpham() == idProduct) {
				if (productCarts.get(i).getQuantityCart() >= productCarts.get(i).getProduct().getSoLuong()) {
					productCarts.get(i).setQuantityCart(productCarts.get(i).getProduct().getSoLuong());
				} else {
					productCarts.get(i).setQuantityCart(productCarts.get(i).getQuantityCart() + 1);
				}
			}
		}
		session.setAttribute("list_detail", productCarts);
		session.setAttribute("size", productCarts.size());

		return "forward:/showCart";
	}

	@RequestMapping(value = "minusProduct/{idProduct}", method = RequestMethod.GET)
	public String minusProduct(@PathVariable int idProduct, HttpSession session) {
		List<ProductCart> productCarts = (ArrayList<ProductCart>) session.getAttribute("list_detail");
		for (int i = productCarts.size() - 1; i >= 0; i--) {
			if (productCarts.get(i).getProduct().getIdSanpham() == idProduct) {
				if (productCarts.get(i).getQuantityCart() <= 1) {
					productCarts.get(i).setQuantityCart(1);
				} else {
					productCarts.get(i).setQuantityCart(productCarts.get(i).getQuantityCart() - 1);
				}
			}
		}
		session.setAttribute("list_detail", productCarts);
		session.setAttribute("size", productCarts.size());
		
		return "forward:/showCart";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(Donhang donhang, HttpSession session, Model model) {
		List<ProductCart> productCarts = (ArrayList<ProductCart>) session.getAttribute("list_detail");
		
		String resultMessage = "";
		
		int totalAmount = getTotalAmount(productCarts);
		donhang.setTongTien(totalAmount);
		donhang.setStatus(0);
		donhang.setNgayDh(new Date());

		boolean tmp = orderService.insertOrder(donhang);

		donhang.setIdDonhang(orderService.getInsertedID());

		
		for (ProductCart productCart : productCarts) {
			orderService.insertOrderDetail(donhang.getIdDonhang(), 
										   productCart.getProduct().getIdSanpham(),
										   productCart.getQuantityCart());
		}
		model.addAttribute("listCate", categoryService.getAllCategories());
		if(tmp) {
//			resultMessage = donhang.toString();
			model.addAttribute("messageSuccess", donhang);
			session.setAttribute("list_detail", null);
		} else {
			resultMessage = "Đã có lỗi xảy ra!";
			model.addAttribute("messageFailed", resultMessage);
		}
		return "successPayment";
	}

	private int getTotalAmount(List<ProductCart> details) {
		int result = 0;

		for (ProductCart productCart : details) {
			result += productCart.getProduct().getGia() * productCart.getQuantityCart();
		}

		return result;
	}
}
