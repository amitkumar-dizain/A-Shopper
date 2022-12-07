package com.esspl.springweb.project;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esspl.backend.dao.ProductDAO;
import com.esspl.backend.model.Product;

@Controller
@RequestMapping("/json/data")
public class JsonController {
	
	@Autowired
	ProductDAO productdao;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> allproducts(){
		return productdao.listActiveProducts();
	}
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> categoryProducts(@PathVariable int id){
		return productdao.listActiveProductByCategory(id);
	}
	
}
