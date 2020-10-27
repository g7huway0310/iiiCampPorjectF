package com.gocamp.campground.impl;

import java.util.List;

import com.gocamp.campground.bean.CampgroundBean;

public interface ICampgroundBeanService {
	public  CampgroundBean insert(CampgroundBean bean);
	public CampgroundBean select(int Id);
	public List<CampgroundBean> selectAll();
	public CampgroundBean update(int id,String name,String city,String adress,String tel,int oprice,int wprice,int tentnum,String elevation,
			  String feature,String facility,String pet,String service,String parking);
	public boolean delete(int Id);

}
