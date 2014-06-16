package sample.bean.paging;

import java.io.Serializable;

public class PagingPrevNextBean implements Serializable {

	private static final long serialVersionUID = 3863419024973741318L;

	private String nowPage;

	public String getNowPage() {
		return nowPage;
	}

	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}

}