package com.esspl.backend.daoimpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.esspl.backend.dao.ProductDAO;
import com.esspl.backend.model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOimpl implements ProductDAO {

	@Autowired
	public SessionFactory sessionfactory;

	@Override
	public List<Product> list() {
		return sessionfactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
	}
		

	@Override
	public Product get(int Productid) {
		try {
			return sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(Productid));
		} catch (Exception e) {
		
		}
		return null;
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionfactory.getCurrentSession().persist(product);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	//Raw Business Logic 
	@Override
	public List<Product> listActiveProducts() {
String s1="FROM Product WHERE active =: active";
		
		return sessionfactory.getCurrentSession().createQuery(s1,Product.class)
				.setParameter("active", true)
				.getResultList();
	}


	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String s1="FROM Product WHERE active =: active AND categoryId =: categoryId";
		return sessionfactory.getCurrentSession().createQuery(s1,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}


	@Override
	public List<Product> getLatestActiveProduct(int count) {
		String s1="FROM Product WHERE active =: active ORDER BY id";
		return sessionfactory.getCurrentSession().createQuery(s1,Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
