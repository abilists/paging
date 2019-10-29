package io.paging;

import io.paging.bean.PagingBean;
import io.paging.bean.PagingInfoBean;
import io.paging.bean.PagingPrevNextBean;

public class Paging {

	public static int PER_PAGE = 10;
	public static int PAGE_LIMIT = 10;
	public static int TOTAL_LIMIT = 2000;

	// private 
	public static void linkPaging(PagingBean pagingBean, int intNowPagePara) throws Exception {

		int intNowPage = 1;
		int intMaxPage = 1;
		int intPerPage = 0;
		int intLimitPage = 0;
		int intTotalHits = 0;
		int intStartCount = 0;
		int intEndCount = 0;

		if(intPerPage < 1) {
			intPerPage = PER_PAGE;
		}
		if(intLimitPage < 1) {
			intLimitPage = PAGE_LIMIT;
		}

		// Total count
		intTotalHits = pagingBean.getAllCount();

		// If the total count is over, it set 2000 count.
		if (intTotalHits > TOTAL_LIMIT) {
			intTotalHits = TOTAL_LIMIT;
		}

		// Now page
		intNowPage = intNowPagePara;

		// If the NowPage the is below, it set 1. 
		if (intNowPage < 1) {
			intNowPage = 1;
		}

		// Set the MaxPage
		if (intTotalHits < intPerPage) {
			intMaxPage = 1;
		} else {
			intMaxPage = (int) (intTotalHits / intPerPage);

			// Plus the page left
			if ((intTotalHits % intPerPage) > 0) {
				intMaxPage++;
			}
		}

		// They request it to set the NowPage
		if (intNowPage > intMaxPage) {
			intNowPage = intMaxPage;
		}

		// Set the limit max page
		if (intMaxPage < intLimitPage) {
			intLimitPage = intMaxPage;
		}

		// If there is the Nextpage, it is setting
		if (intNowPage < intMaxPage) {
			PagingPrevNextBean pagingNext = new PagingPrevNextBean();
			pagingNext.setNowPage(String.valueOf(intNowPage+1));

			pagingBean.setNextPage(pagingNext);
		}

		// If there is the PrevPage, it is setting
		if (intNowPage > 1) {
			PagingPrevNextBean pagingPrev = new PagingPrevNextBean();
			pagingPrev.setNowPage(String.valueOf(intNowPage-1));

			pagingBean.setPrevPage(pagingPrev);
		}

		// To the row page number
		int intAveragePage = intLimitPage / 2;
		int intPageNumber = 0;
		intPageNumber = intNowPage - intAveragePage - 1;

		// To find the end page
		int intEndPage = intMaxPage - intNowPage;

		// To set the first page number
		if (intEndPage <= intAveragePage) {
			intPageNumber = intPageNumber - (intAveragePage - intEndPage);
		}

		// Although it get a minus number, it's 0
		if (intPageNumber < 0) {
			intPageNumber = 0;
		}

		// To set the link parameter in the 7 number
		for (int i=0;intLimitPage > i; i++ ) {
			PagingInfoBean pagingInfoBean = new PagingInfoBean();

			intPageNumber++;

			pagingInfoBean.setPageNumber(String.valueOf(intPageNumber));
			pagingBean.addPagingInfoList(pagingInfoBean);
		}

		// To press the button number that is paging number.
		pagingBean.setNowPage(String.valueOf(intNowPage));
		// To set the count for represent
		intStartCount = (intNowPage-1)*intPerPage+1;
		intEndCount = (intNowPage)*intPerPage;
		pagingBean.setStartCount(String.valueOf(intStartCount));
		pagingBean.setEndCount(String.valueOf(intEndCount));

	}

	public static void setTotalLimit(int pagePer, int pageLimit, int totalLimit) throws Exception {

		if(pagePer > PER_PAGE) {
			PER_PAGE = pagePer;			
		}
		if(pageLimit > PAGE_LIMIT) {
			PAGE_LIMIT = pageLimit;			
		}
		if(totalLimit > TOTAL_LIMIT) {
			TOTAL_LIMIT = totalLimit;			
		}

	}

}
