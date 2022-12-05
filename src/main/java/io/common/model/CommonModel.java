package io.common.model;

import io.paging.bean.PagingBean;

public class CommonModel {

	private String token;
	private String pagingName;
    private PagingBean paging;
    private String errorMessage;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPagingName() {
		return pagingName;
	}
	public void setPagingName(String pagingName) {
		this.pagingName = pagingName;
	}
	public PagingBean getPaging() {
		return paging;
	}
	public void setPaging(PagingBean paging) {
		this.paging = paging;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}