package io.paging.bean;

import java.util.ArrayList;
import java.util.List;

public class PagingBean {

	private List<PagingInfoBean> pagingInfoList = new ArrayList<PagingInfoBean>();

	private int allCount;

	private int rowPage;

	private String nowPage;

	private String startCount;

	private String endCount;

	private PagingPrevNextBean prevPage;

	private PagingPrevNextBean nextPage;

	public List<PagingInfoBean> getPagingInfoList() {
		return pagingInfoList;
	}

    public void addPagingInfoList(PagingInfoBean pagingInfoBean) {
        synchronized (pagingInfoBean) {
        	this.pagingInfoList.add(pagingInfoBean);
        }
    }

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public String getNowPage() {
		return nowPage;
	}

	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}

	public int getRowPage() {
		return rowPage;
	}

	public void setRowPage(int rowPage) {
		this.rowPage = rowPage;
	}

	public String getStartCount() {
		return startCount;
	}

	public void setStartCount(String startCount) {
		this.startCount = startCount;
	}

	public String getEndCount() {
		return endCount;
	}

	public void setEndCount(String endCount) {
		this.endCount = endCount;
	}

	public PagingPrevNextBean getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(PagingPrevNextBean prevPage) {
		this.prevPage = prevPage;
	}

	public PagingPrevNextBean getNextPage() {
		return nextPage;
	}

	public void setNextPage(PagingPrevNextBean nextPage) {
		this.nextPage = nextPage;
	}


}