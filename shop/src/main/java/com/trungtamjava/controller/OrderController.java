package com.trungtamjava.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trungtamjava.model.OrderDTO;
import com.trungtamjava.model.OrderItemDTO;
import com.trungtamjava.model.ProductDTO;
import com.trungtamjava.service.ProductService;

/**
 * @author minhpc
 *
 */

@Controller
public class OrderController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/add-cart/{productId}", method = RequestMethod.GET)
	public String addToCart(HttpServletRequest request, @PathVariable(name = "productId") int productId,
			HttpSession session) {
		// request.setAttribute("product", productService.getProductById(productId));
		ProductDTO productDTO = productService.getProductById(productId);
		if (session.getAttribute("cart") == null) {
			OrderDTO orderDTO = new OrderDTO();
			OrderItemDTO orderItemDTO = new OrderItemDTO();
			orderItemDTO.setNumber(1);
			orderItemDTO.setProductDTO(productDTO);
			List<OrderItemDTO> orderitemDTOs = new ArrayList<OrderItemDTO>();
			orderitemDTOs.add(orderItemDTO);
			orderDTO.setItemsDTO(orderitemDTOs);
			session.setAttribute("cart", orderDTO);
			request.setAttribute("order", orderDTO);
		} else {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			List<OrderItemDTO> orderitemDTOs = orderDTO.getItemDTOs();
			boolean flag = false; // dung de kiem tra id co trong gio hang chua
			for (OrderItemDTO orderItemDTO : orderitemDTOs) {
				if (orderItemDTO.getProductDTO().getId() == productDTO.getId()) {
					orderItemDTO.setNumber(orderItemDTO.getNumber() + 1);
					flag = true;
				}
			}

			if (!flag) { // neu truong hop trong gio hang chua co san pham nay
				OrderItemDTO orderItemDTO = new OrderItemDTO();
				orderItemDTO.setNumber(1);
				orderItemDTO.setProductDTO(productDTO);
				orderitemDTOs.add(orderItemDTO);
			}

			session.setAttribute("cart", orderDTO);
			request.setAttribute("order", orderDTO);
		}

		return "cart";
	}

	@RequestMapping(value = "/view-cart", method = RequestMethod.GET)
	public String viewToCart(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			request.setAttribute("order", orderDTO);
		}
		return "cart";
	}

	@RequestMapping(value = "/delete-cart/{productId}", method = RequestMethod.GET)
	public String deleteCart(HttpServletRequest request, HttpSession session,
			@PathVariable(name = "productId") int productId) {
		if (session.getAttribute("cart") != null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			List<OrderItemDTO> orderitemDTOs = orderDTO.getItemDTOs();
			Iterator<OrderItemDTO> iterator = orderitemDTOs.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getProductDTO().getId() == productId) {
					iterator.remove();
				}
			}

			if (orderitemDTOs.isEmpty()) {
				session.removeAttribute("cart");
			}
			request.setAttribute("order", orderDTO);
		}
		return "cart";
	}

}
