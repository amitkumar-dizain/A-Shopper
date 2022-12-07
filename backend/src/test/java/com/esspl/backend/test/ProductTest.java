package com.esspl.backend.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.esspl.backend.dao.ProductDAO;
import com.esspl.backend.model.Product;

public class ProductTest {
	public static AnnotationConfigApplicationContext ctx;
	public static ProductDAO productDao;
	public static Product product;
	
	@BeforeClass 
	public static void init() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.esspl.backend");
		ctx.refresh();
		productDao = (ProductDAO) ctx.getBean("productDAO");
		
	}
	@Ignore
	@Test
	public void testAddProd()
	{
		product =new Product();
		product.setName("Mi TV 4X");
		product.setBrand("MI");
		product.setDescription("This is a nice MI Televison ");
		product.setCategoryId(3);
		product.setUnitPrice(20000);
		product.setSupplierId(1);
		product.setQuantity(5);
		product.setActive(true);
		assertEquals("Product is not added successfully",true,productDao.add(product));
		
	}
	
	@Test
	public void testupdateproduct() {
		product = productDao.get(15);
		product.setCategoryId(4);
		assertEquals("not updated sucessfully",true,productDao.update(product));
}
	@Ignore
	@Test
	public void testActiveProd()
	{
		assertEquals("Product is not retrieved successfully",4,productDao.listActiveProducts().size());
		
	}
	@Ignore
	@Test
	public void testActiveProdByCat()
	{
		assertEquals("Product is not retrieved successfully",2,productDao.listActiveProductByCategory(1).size());
		
	}
}
