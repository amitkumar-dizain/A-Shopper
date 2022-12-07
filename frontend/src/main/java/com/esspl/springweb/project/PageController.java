package com.esspl.springweb.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esspl.backend.dao.CategoryDAO;
import com.esspl.backend.dao.ProductDAO;
import com.esspl.backend.model.Category;
import com.esspl.backend.model.Product;

@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO Categorydao;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home Page");
		mv.addObject("categories", Categorydao.list());
		logger.info("inside the pageController through SL4J ---INFO ");
		logger.debug("inside the pageController through SL4J ---DEBUG");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "about");
		mv.addObject("userClickabout", true);
		return mv;
	}

	@RequestMapping(value = { "/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product Page");
		mv.addObject("categories", Categorydao.list());
		mv.addObject("userClickProduct", true);
		return mv;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		Category cat = null;
		cat = Categorydao.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", cat.getName());
		mv.addObject("categories", Categorydao.list());
		mv.addObject("category", cat);
		mv.addObject("userClickCategoryProduct", true);
		return mv;

	}

	@RequestMapping(value = { "/show/{id}/product" })
	public ModelAndView showSingleProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);

		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickSingleProduct", true);

		return mv;

	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "about");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = { "/checkout" })
	public ModelAndView checkout() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "checkout");
		mv.addObject("userClickCheckOut", true);
		return mv;
	}

	@RequestMapping(value = { "/cart" })
	public ModelAndView cart() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "cart");
		mv.addObject("userClickCart", true);
		return mv;
	}
}
