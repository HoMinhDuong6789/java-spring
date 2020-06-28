package com.trungtamjava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trungtamjava.model.ProductDTO;
import com.trungtamjava.service.ProductService;

@Controller
public class ProductController {
	private static Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/list-product", method = RequestMethod.GET)
	public String getAllProduct(HttpServletRequest request, HttpSession session) {
		List<ProductDTO> products = productService.getAllProducts();
		request.setAttribute("msg",messageSource.getMessage("product.name", null, null));
		request.setAttribute("products", products);
		return "listProduct";

	}

	@RequestMapping(value = "/product-detail/{productId}", method = RequestMethod.GET)
	public String viewProduct(HttpServletRequest request, @PathVariable(name = "productId") int productId) {
		// List<User> users= userService.getAllUsers();
		request.setAttribute("product", productService.getProductById(productId));
		return "viewProduct";
	}

	@RequestMapping(value = "/product-insert", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest request) {
		request.setAttribute("product", new ProductDTO());
		return "addProduct";
	}

	@RequestMapping(value = "/product-insert", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, @ModelAttribute("product") ProductDTO product,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {// bien dung de kiem tra co loi hay ko, ==true thi co loi
			return "addProduct";
		}
		productService.addProduct(product);
		request.setAttribute("product", product);
		return "redirect:list-product";
	}

	@RequestMapping(value = "/product-delete/{productId}", method = RequestMethod.GET)
	public String deleteProduct(HttpServletRequest request, @PathVariable(name = "productId") int productId) {
		productService.deleteProduct(productId);
		return "redirect:/list-product";
	}

	@RequestMapping(value = "/product-edit/{productId}", method = RequestMethod.GET)
	public String editProduct(HttpServletRequest request, @PathVariable(name = "productId") int productId) {
		request.setAttribute("product", productService.getProductById(productId));
		return "editProduct";
	}

	@RequestMapping(value = "/product-edit", method = RequestMethod.POST)
	public String editProduct(HttpServletRequest request, @ModelAttribute("product") ProductDTO product,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {// bien dung de kiem tra co loi hay ko, ==true thi co loi
			return "editProduct";
		}
		productService.updateProduct(product);
		return "redirect:list-product";
	}

}
