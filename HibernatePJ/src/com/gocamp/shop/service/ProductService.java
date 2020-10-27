package com.gocamp.shop.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gocamp.shop.bean.PageBean;
import com.gocamp.shop.bean.Product;
import com.gocamp.shop.dao.ProductDAO;
import com.gocamp.shop.dao.impl.ProductDAOImp;
import com.gocamp.util.HibernateUtil;

import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;

public class ProductService implements ProductDAO{

	ProductDAOImp dao;
	
	
	@Override
	public PageBean<Product> getAll(int pageNo) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		PageBean<Product> list = dao.getAll(pageNo);
		
		return list;
	}

	@Override
	public Product findProduct(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		Product findProduct = dao.findProduct(id);
		return findProduct;
	}

	@Override
	public PageBean<Product> SearchBrandItem(String keyWord, int pageNo) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		PageBean<Product> list = dao.SearchBrandItem(keyWord, pageNo);
		return list;
	}

	@Override
	public PageBean<Product> searchtype(int selectWhich, int pageNo) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		PageBean<Product> searchtypelist = dao.searchtype(selectWhich, pageNo);
		return searchtypelist;
	}

	@Override
	public Product updateData(Product shoppingProduct, int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		Product updateData = dao.updateData(shoppingProduct, id);
		return updateData;
	}

	@Override
	public Product inserData(Product shoppingProduct) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		Product inserData = dao.inserData(shoppingProduct);
		return inserData;
	}

	@Override
	public PageBean<Product> searchtypeOrderByPrice(int selectWhich, int pageNo) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		PageBean<Product> list = dao.searchtypeOrderByPrice(selectWhich, pageNo);
		return list;
	}

	@Override
	public PageBean<Product> searchtypePriceDesc(int selectWhich, int pageNo) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		PageBean<Product> list = dao.searchtypePriceDesc(selectWhich, pageNo);
		return list;
	}

	@Override
	public PageBean<Product> searchOrderByHot(int selectWhich, int pageNo) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		PageBean<Product> list = dao.searchOrderByHot(selectWhich, pageNo);
		return list;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		dao = new ProductDAOImp(session);
		boolean delete = dao.delete(id);
		return delete;
	}

	@Override
	public void updateCount(String product_id) {
		// TODO Auto-generated method stub
		
	}

}
