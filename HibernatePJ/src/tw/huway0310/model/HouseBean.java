package tw.huway0310.model;

import java.io.Serializable;

public class HouseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int houseid; // 第一個不可以大寫

	private String housename;
	
	
	public HouseBean() {
		
	}
	
	public HouseBean(int houseid, String housename) {
		this.houseid = houseid;
		this.housename = housename;
	}



	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

}
