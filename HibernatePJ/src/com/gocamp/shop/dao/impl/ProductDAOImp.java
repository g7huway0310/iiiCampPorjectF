package com.gocamp.shop.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.gocamp.shop.bean.PageBean;
import com.gocamp.shop.bean.Product;
import com.gocamp.shop.dao.ProductDAO;
import com.gocamp.util.HibernateUtil;

import tw.huway0310.model.HouseBean;

public class ProductDAOImp implements ProductDAO {

	int pageNo = 1;

	private Session session;

	public ProductDAOImp() {

	}

	public ProductDAOImp(Session session) {
		this.session = session;
	}

	@Override
	public PageBean<Product> getAll(int firstResult) {
		// TODO Auto-generated method stub
		
		
		Query<Product> query = session.createQuery("from Product order by PCATEGORYID", Product.class);

		// 計算總共資料量
		List<Product> totaList = query.list();

		// 總比數
		int totaListSize = totaList.size();

		// 當前頁數*(1頁顯示10筆)
//		firstResult = firstResult * 10;

		// 設定資料查詢開頭
		query.setFirstResult(firstResult);

		// 限制比數
//		query.setMaxResults(10);

		// 回傳分頁資料結果
		List<Product> list = query.list();

		int maxPage = (totaListSize / 10) + 1;

		PageBean<Product> aPageBean = new PageBean<Product>(firstResult / 10, maxPage, list);

		System.out.println(totaListSize + "總比數");

		System.out.println(maxPage + "總頁數");

		if (list != null) {
			int size = totaListSize;
//			System.out.println("Total Results: " + totaListSize);
			for (Product product : list) {
//				System.out.println("Retrieved Product using Query. Name: " + product.getProductName());
			}
			return aPageBean;
		} else {
			return null;
		}
	}

	// 搜尋商品
	@Override
	public Product findProduct(int id) {
		// TODO Auto-generated method stub
		Product product = session.get(Product.class, id);

		if (product != null) {
			return product;
		}
		return null;
	}

	@Override
	public PageBean<Product> SearchBrandItem(String keyWord, int pageNo) {
		// TODO Auto-generated method stub
		
		Query<Product> query = session.createQuery("from Product where (PBRAND like ?0) OR PNAME like ?1",
				Product.class);

		query.setParameter(0, "%" + keyWord + "%");

		query.setParameter(1, "%" + keyWord + "%");

		// 計算總共資料量
		List<Product> totaList = query.list();

		// 總比數
		int totaListSize = totaList.size();

		// 當前頁數*(1頁顯示10筆)
		pageNo = pageNo * 10;

		// 設定資料查詢開頭
		query.setFirstResult(pageNo);

		// 限制比數
		query.setMaxResults(10);

		// 回傳分頁資料結果
		List<Product> list = query.list();

		int maxPage = (totaListSize / 10) + 1;

		PageBean<Product> aPageBean = new PageBean<Product>(pageNo / 10, maxPage, list);

		System.out.println(totaListSize + "總比數");

		System.out.println(maxPage + "總頁數");

		if (list != null) {
			int size = totaListSize;
			System.out.println("Total Results: " + totaListSize);
			for (Product product : list) {
				System.out.println("Retrieved Product using Query. Name: " + product.getProductName());
			}
			return aPageBean;
		} else {
			return null;
		}
	}

	@Override
	public PageBean<Product> searchtype(int selectWhich, int pageNo) {
		// TODO Auto-generated method stub
		Query<Product> query = session.createQuery("from Product where PCATEGORYID=?0", Product.class);

		query.setParameter(0, selectWhich);

		// 計算總共資料量
		List<Product> totaList = query.list();

		// 總比數
		int totaListSize = totaList.size();

		// 當前頁數*(1頁顯示10筆)
		pageNo = pageNo * 10;

		// 設定資料查詢開頭
		query.setFirstResult(pageNo);

		// 限制比數
		query.setMaxResults(10);

		// 回傳分頁資料結果
		List<Product> list = query.list();

		int maxPage = (totaListSize / 10) + 1;

		PageBean<Product> aPageBean = new PageBean<Product>(pageNo / 10, maxPage, list);

		System.out.println(totaListSize + "總比數");

		System.out.println(maxPage + "總頁數");

		if (list != null) {
			int size = totaListSize;
			System.out.println("Total Results: " + totaListSize);
			for (Product product : list) {
				System.out.println("Retrieved Product using Query. Name: " + product.getProductName());
			}
			return aPageBean;
		} else {
			return null;
		}
	}

	@Override
	public Product updateData(Product shoppingProduct, int id) {
		// TODO Auto-generated method stub
		Product aProduct = findProduct(id);
		aProduct.setProductName(shoppingProduct.getProductName());
		aProduct.setProductBrand(shoppingProduct.getProductBrand());
		aProduct.setProductPrice(shoppingProduct.getProductPrice());
		aProduct.setProductSpec(shoppingProduct.getProductSpec());
		aProduct.setProductStock(shoppingProduct.getProductStock());
		aProduct.setProductfeature(shoppingProduct.getProductfeature());
		aProduct.setProductWarring(shoppingProduct.getProductWarring());
        aProduct.setPicpath(shoppingProduct.getPicpath());
		session.saveOrUpdate(aProduct);
		return aProduct;

	}

	@Override
	public Product inserData(Product product) {
		// TODO Auto-generated method stub
		session.save(product);
		return product;
	}

	@Override
	public PageBean<Product> searchtypeOrderByPrice(int selectWhich, int pageno) {
		// TODO Auto-generated method stub
		Query<Product> query = session.createQuery("from Product where PCATEGORYID=?0 order by PRICE", Product.class);

		query.setParameter(0, selectWhich);

		// 計算總共資料量
		List<Product> totaList = query.list();

		// 總比數
		int totaListSize = totaList.size();

		// 當前頁數*(1頁顯示10筆)
		pageno = pageno * 10;

		// 設定資料查詢開頭
//		query.setFirstResult(pageno);

		// 限制比數
//		query.setMaxResults(50);

		// 回傳分頁資料結果
		List<Product> list = query.list();

		int maxPage = (totaListSize / 10) + 1;

		PageBean<Product> aPageBean = new PageBean<Product>(pageNo / 10, maxPage, list);

		System.out.println(totaListSize + "總比數");

		System.out.println(maxPage + "總頁數");

		if (list != null) {
			int size = totaListSize;
			System.out.println("Total Results: " + totaListSize);
			for (Product product : list) {
				System.out.println("Retrieved Product using Query. Name: " + product.getProductName());
			}
			return aPageBean;
		} else {
			return null;
		}
	}

	@Override
	public PageBean<Product> searchtypePriceDesc(int selectWhich, int pageno) {
		// TODO Auto-generated method stub
		
		Query<Product> query = session.createQuery("from Product where PCATEGORYID=?0 order by PRICE desc", Product.class);
		
		query.setParameter(0, selectWhich);
		
		// 計算總共資料量
		List<Product> totaList = query.list();

		// 總比數
		int totaListSize = totaList.size();

		// 當前頁數*(1頁顯示10筆)
		pageno = pageno * 10;

		// 設定資料查詢開頭
		query.setFirstResult(pageNo);

		// 限制比數
		query.setMaxResults(10);

		// 回傳分頁資料結果
		List<Product> list = query.list();

		int maxPage = (totaListSize / 10) + 1;

		PageBean<Product> aPageBean = new PageBean<Product>(pageNo / 10, maxPage, list);

		System.out.println(totaListSize + "總比數");

		System.out.println(maxPage + "總頁數");

		if (list != null) {
			int size = totaListSize;
			System.out.println("Total Results: " + totaListSize);
			for (Product product : list) {
				System.out.println("Retrieved Product using Query. Name: " + product.getProductName());
			}
			return aPageBean;
		} else {
			return null;
		}
	}

	@Override
	public PageBean<Product> searchOrderByHot(int selectWhich, int pageno) {
		// TODO Auto-generated method stub
        Query<Product> query = session.createQuery("from Product where PCATEGORYID=?0 order by clicknum", Product.class);
		
		query.setParameter(0, selectWhich);
		
		// 計算總共資料量
		List<Product> totaList = query.list();

		// 總比數
		int totaListSize = totaList.size();

		// 當前頁數*(1頁顯示10筆)
		pageno = pageno * 10;

		// 設定資料查詢開頭
		query.setFirstResult(pageNo);

		// 限制比數
		query.setMaxResults(10);

		// 回傳分頁資料結果
		List<Product> list = query.list();

		int maxPage = (totaListSize / 10) + 1;

		PageBean<Product> aPageBean = new PageBean<Product>(pageNo / 10, maxPage, list);

		System.out.println(totaListSize + "總比數");

		System.out.println(maxPage + "總頁數");

		if (list != null) {
			int size = totaListSize;
			System.out.println("Total Results: " + totaListSize);
			for (Product product : list) {
				System.out.println("Retrieved Product using Query. Name: " + product.getProductName());
			}
			return aPageBean;
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		Product product = findProduct(id);

		if (product != null) {
			this.session.delete(product);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateCount(String product_id) {
		// TODO Auto-generated method stub

	}

}