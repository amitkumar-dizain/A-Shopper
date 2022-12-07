package com.esspl.springweb.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esspl.backend.dao.CategoryDAO;
import com.esspl.backend.dao.ProductDAO;
import com.esspl.backend.model.Category;
import com.esspl.backend.model.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public ModelAndView manageProduct(@RequestParam(name="success",required=false) String success) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product Management");
		mv.addObject("userClickManageProduct", true);

		Product nproduct = new Product();

		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		mv.addObject("product", nproduct);
		
		if(success !=null)
		{
			if(success.equals("product"))
			{
				mv.addObject("message","Product Submitted SuccessFully");
			}
		}

		return mv;

	}

	@RequestMapping(value = { "/product" }, method = RequestMethod.POST)
	public String postProduct(@ModelAttribute("product") Product xProduct) {

		productDAO.add(xProduct);
		return "redirect:/manage/product?success=product";
	}

	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.list();
	}

}
