package com.gocamp.shop.dao;

import java.util.List;

import com.gocamp.shop.bean.PageBean;
import com.gocamp.shop.bean.Product;



public interface ProductDAO {

	public PageBean<Product> getAll(int pageNo);

	// 根据id取product
	public Product findProduct(int id);

	// 依照品牌搜尋
	public PageBean<Product> SearchBrandItem(String keyWord,int pageNo);

	// 依照類別
	public PageBean<Product> searchtype(int selectWhich,int pageNo);

	// 更新庫存
	public Product updateData(Product shoppingProduct, int id);

	// 新增產品
	public Product inserData(Product shoppingProduct);
	
	//價格排序小到大
	public PageBean<Product> searchtypeOrderByPrice(int selectWhich,int pageNo);
	
	//價格排序大到小
	public PageBean<Product> searchtypePriceDesc(int selectWhich,int pageNo);
	
	//熱門商品
	public PageBean<Product> searchOrderByHot(int selectWhich ,int pageNo);
	
	//刪除
	public boolean delete(int id);

	public void updateCount(String product_id);

}
