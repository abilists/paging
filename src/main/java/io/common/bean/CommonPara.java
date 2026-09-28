package io.common.bean;

import io.paging.bean.PagingPara;

public class CommonPara extends PagingPara {

	private int rowPage;
    private String token;
    private String error;

	public int getRowPage() {
		return rowPage;
	}
	public void setRowPage(int rowPage) {
		this.rowPage = rowPage;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
 
}
