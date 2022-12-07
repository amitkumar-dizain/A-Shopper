package com.esspl.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.esspl.backend.dao.CategoryDAO;
import com.esspl.backend.model.Category;


public class CategoryTest {

	public static AnnotationConfigApplicationContext ctx;
	public static CategoryDAO categoryDao;
	public static Category category;
	
	@BeforeClass 
	public static void init() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.esspl.backend");
		ctx.refresh();
		categoryDao = (CategoryDAO) ctx.getBean("categoryDAO");
		
	}
	@Ignore
	@Test
	public void testaddcategory() {
		category = new Category();
		category.setName("television");
		category.setImageurl("3.jpg");
		category.setDescription("this is nice television");
		category.setActive(true);
		
		assertEquals("not added sucessfully",true,categoryDao.add(category));
	}
	@Ignore
	@Test
	public void testgetcategory() {
		category = categoryDao.get(3);
		
		assertEquals("not retrived sucessfully","tablet",category.getName());
}
	
	@Test
	public void testupdatecategory() {
		category = categoryDao.get(1);
		
		
		category.setActive(true);
		assertEquals("not updated sucessfully",true,categoryDao.update(category));
}
	@Ignore
	@Test
	public void testdeletcategory() {
		category = categoryDao.get(5);
		assertEquals("not deleted sucessfully",true,categoryDao.delete(category));
}
	@Ignore
	@Test
	public void testlistcategory() {
		
		assertEquals("list not retrived sucessfully",4,categoryDao.list().size());
}
}
