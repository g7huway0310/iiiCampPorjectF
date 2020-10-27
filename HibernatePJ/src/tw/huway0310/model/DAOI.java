package tw.huway0310.model;

import java.util.List;

public interface DAOI {

	HouseBean inert(HouseBean bean);

	HouseBean select(int houseBeanid);

	List<HouseBean> selectAll();

	boolean delete(int beanId);

	HouseBean update(int houseid, String updateName);

}