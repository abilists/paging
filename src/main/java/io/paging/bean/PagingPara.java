package io.paging.bean;


public class PagingPara {

	private int nowPage = 0;
	private int allCount = 0;

	public int getNowPage() {

		// Check a nowPage
		if(nowPage <= 0){
			nowPage = 1;
		}

		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

}
