package com.gocamp.shop.dao;

import java.sql.Connection;
import java.util.List;

import com.gocamp.shop.bean.Order;



public interface OrderDAO {

	public void addOrder(Order order);// 新增訂單

	public void delOrder(Order order);// 刪除

	public Order findOrder(int orderid);// 搜尋訂單

	public void update(Order order);// 修改

	

	void setConnection(Connection con);
	
	List<Order> getAllOrders();

	List<Order> getMemberOrders(String memberId);

}
