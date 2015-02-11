package com.gbs.util;

public class Page {
	
	private int currPage ;
	private int rows ;
	private int start;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStart() {
		return (currPage-1)*rows;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
