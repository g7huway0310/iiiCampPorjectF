package tw.huway0310.model;

import java.util.List;



public interface IHouseBeanService {
	public List<HouseBean> selectAll();
	public HouseBean select(int houseBeanid);
	public HouseBean inert(HouseBean bean);
	public boolean delete(int beanId);
	public HouseBean update(int houseid,String updateName);

}
