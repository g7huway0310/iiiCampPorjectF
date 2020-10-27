package com.gocamp.shop.dao;

import java.util.List;

import com.gocamp.shop.bean.Product;

public interface ProductPageDAO {

	public List<Product> getpageProduct();

	public int getTotalPage();// 取得總頁數

	public long getRecordCounts(); // 取得總共資料筆數

	public List<Product> listAllOf(int startIndex, int offset);

	public int counts();
	
}
