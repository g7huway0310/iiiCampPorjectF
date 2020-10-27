package tw.huway0310.model;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.query.Query;


public class HouseBeanDAO implements DAOI {

	 private Session session;
	
	 public HouseBeanDAO() {	
	 }
	 public HouseBeanDAO(Session session) {
		this.session=session;
	 }
	 
	 @Override
	 public HouseBean inert(HouseBean bean) {
		
		HouseBean result = session.get(HouseBean.class, bean.getHouseid());
		
		if (result==null) {
			this.session.save(bean);
			return bean;
		}
		return null;
		
	}
	@Override
	public HouseBean select(int houseBeanid) {
		
		HouseBean houseBean = session.get(HouseBean.class, houseBeanid);
		
		if (houseBean!=null) {
			return houseBean;
		}
		return null;
		
	}
	
	@Override
	public List<HouseBean> selectAll(){
		
		Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
		
		List<HouseBean> list = query.list();
		
		if (list!=null) {
			return list;
		}
		return null;
		
	}
	
    @Override
	public boolean delete(int beanId) {
		
		HouseBean result = session.get(HouseBean.class, beanId);
		
		if (result!=null) {
			this.session.delete(result);
			return true;
		}
		return false;
		
	}
    
   @Override
public HouseBean update(int houseid,String updateName) {
		
		HouseBean result = session.get(HouseBean.class, houseid);
		
		if (result!=null) {
			result.setHouseid(555);
			result.setHousename("更新後");
			return result;
		}
		return null;
		
	}
    
    
	
}
