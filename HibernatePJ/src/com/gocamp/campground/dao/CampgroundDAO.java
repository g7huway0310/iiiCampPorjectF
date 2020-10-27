package com.gocamp.campground.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.gocamp.campground.bean.CampgroundBean;

public class CampgroundDAO {
	
	private Session session;

	public CampgroundDAO (Session session) {
		this.session = session;
	}
	
	public  CampgroundBean insert(CampgroundBean bean) {
			CampgroundBean result = session.get(CampgroundBean.class,bean.getId());
			if(result==null){
				session.save(bean);
				return bean;
			}	
			return null;
		}
	
	public CampgroundBean select(int Id) {
		return session.get(CampgroundBean.class,Id);
	}
	
	public List<CampgroundBean> selectByCity(String city){
		List result= session.createQuery("from CampgroundBean where city like city").list();
		
		for (int i = 0; i<result.size() ; i++) {
			CampgroundBean campinf = (CampgroundBean) result.get(i);
			campinf.getId();
			campinf.getName();
			campinf.getCity();
			campinf.getAdress();
			campinf.getTel();
			campinf.getOprice();
			campinf.getWprice();
			campinf.getTentnum();
			campinf.getElevation();
			campinf.getFeature();
			campinf.getFacility();
			campinf.getPet();
			campinf.getService();
			campinf.getParking();	
		}
		return result;
	}
	
	public List<CampgroundBean> selectAll(){
		Query<CampgroundBean> query = session.createQuery("From CampgroundBean",CampgroundBean.class);
		List<CampgroundBean> list = query.list();
		return list;
	}
	
	  public boolean delete(int Id) {
		  CampgroundBean result = session.get(CampgroundBean.class,Id);
		    	if(result!=null) {
					session.delete(result);
					return true;
				}
						return false;              
	  }
	  
	  public CampgroundBean update(int id,String name,String city,String adress,String tel,int oprice,int wprice,int tentnum,String elevation,
			  String feature,String facility,String pet,String service,String parking) {
		  CampgroundBean result = session.get(CampgroundBean.class,id);

		  if(result!=null) {
			    result.setId(id);
				result.setName(name);
				result.setCity(city);
				result.setAdress(adress);
				result.setTel(tel);
				result.setOprice(oprice);
				result.setWprice(wprice);
				result.setTentnum(tentnum);
				result.setElevation(elevation);
				result.setFeature(feature);
				result.setFacility(facility);
				result.setPet(pet);
				result.setService(service);
				result.setParking(parking);
			}
			return result;
		  }

}
