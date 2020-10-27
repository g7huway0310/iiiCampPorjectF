package com.gocamp.campground.impl;

import java.util.List;

import org.hibernate.Session;

import com.gocamp.campground.bean.CampgroundBean;
import com.gocamp.campground.dao.CampgroundDAO;

public class CampgroundBeanService implements ICampgroundBeanService {
	
	private CampgroundDAO cDao;
	
	public CampgroundBeanService(Session session) {
		
		cDao = new CampgroundDAO(session);
	}

	@Override
	public  CampgroundBean insert(CampgroundBean bean)  {
		// TODO Auto-generated method stub
		return cDao.insert(bean);
	}

	@Override
	public CampgroundBean select(int Id) {
		// TODO Auto-generated method stub
		return cDao.select(Id);
	}

	@Override
	public List<CampgroundBean> selectAll(){
		// TODO Auto-generated method stub
		return cDao.selectAll();
	}

	@Override
	public CampgroundBean update(int id,String name,String city,String adress,String tel,int oprice,int wprice,int tentnum,String elevation,
			  String feature,String facility,String pet,String service,String parking) {
		// TODO Auto-generated method stub
		return cDao.update(id, name, city, adress, tel, oprice, wprice, tentnum, elevation, feature, facility,
				pet, service, parking);
	}

	@Override
	public boolean delete(int Id) {
		// TODO Auto-generated method stub
		return cDao.delete(Id);
	}


}
