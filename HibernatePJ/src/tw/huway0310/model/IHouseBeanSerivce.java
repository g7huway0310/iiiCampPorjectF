package tw.huway0310.model;

import java.util.List;

import org.hibernate.Session;



public class IHouseBeanSerivce implements DAOI,IHouseBeanService {

	private DAOI houseBeanDAO;
	
	private Session aSession;
	
	public IHouseBeanSerivce(Session session) {
		houseBeanDAO=new HouseBeanDAO(session);
		
	}
	@Override
	public List<HouseBean> selectAll() {
		// TODO Auto-generated method stub
	   return houseBeanDAO.selectAll();
	    
	}

	@Override
	public HouseBean select(int houseBeanid) {
		// TODO Auto-generated method stub
		return houseBeanDAO.select(houseBeanid);
	}

	@Override
	public HouseBean inert(HouseBean bean) {
		// TODO Auto-generated method stub
		return houseBeanDAO.inert(bean);
	}

	@Override
	public boolean delete(int beanId) {
		// TODO Auto-generated method stub
		return houseBeanDAO.delete(beanId);
	}

	@Override
	public HouseBean update(int houseid, String updateName) {
		// TODO Auto-generated method stub
		return houseBeanDAO.update(houseid, updateName);
	}

}
