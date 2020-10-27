package com.gocamp.shop.dao;

import java.sql.Connection;

import com.gocamp.shop.bean.OrderItem;



public interface OrderItemDAO {

	double findItemAmount(OrderItem oib);

	int updateProductStock(OrderItem ob);

	void setConnection(Connection conn);

}
