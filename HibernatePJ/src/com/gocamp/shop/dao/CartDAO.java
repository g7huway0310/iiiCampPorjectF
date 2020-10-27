package com.gocamp.shop.dao;

import java.util.List;

import com.gocamp.shop.bean.Cart;
import com.gocamp.shop.bean.Product;



public interface CartDAO {

	public List<Product> getProducts();

	public Product findprProduct(String id);

	public void deleteCartItem(String sid, Cart cart);

	public void clearCart(Cart cart);

	public void changeQuantity(String sid, String quantity, Cart cart);

	public List<Product> SearchBrandItem(String keyWord);

	public List<Product> searchtype(int selectWhich);
	
}
