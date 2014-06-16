package sample.bean.paging;

import java.io.Serializable;

public class PagingInfoBean implements Serializable{

	private static final long serialVersionUID = -164237641662187614L;

	private String pageNumber;


	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

}