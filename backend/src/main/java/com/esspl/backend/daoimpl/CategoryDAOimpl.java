package com.esspl.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.esspl.backend.dao.CategoryDAO;
import com.esspl.backend.model.Category;
@Transactional
@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO
{
	@Autowired
	public SessionFactory sessionfactory ;
	
	@Override
	public List<Category> list() {
		String q1 = "FROM Category WHERE active=:active";
		Query query = sessionfactory.getCurrentSession().createQuery(q1);
		query.setParameter("active" ,true);
		return query.getResultList();
	}
	
	
	@Override
	public boolean add(Category category) {
		try {
			sessionfactory.getCurrentSession().persist(category);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Category get(int id) {
		
		return sessionfactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}


}
