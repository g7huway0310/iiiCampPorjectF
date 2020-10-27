package com.gocamp.shop.bean;

import java.util.List;

public class PageBean<T> {

	private int currentPage; // 現在第幾頁

	private int totalPage; // 一共多少頁

	public PageBean(int currentPage, int totalPage, List<T> dataList) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}

	private List<T> dataList; // 要顯示的資料

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	

}
