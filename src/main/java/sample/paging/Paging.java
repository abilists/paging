package sample.paging;

import jp.ameba.sg2.common.bean.paging.PagingBean;
import jp.ameba.sg2.common.bean.paging.PagingInfoBean;
import jp.ameba.sg2.common.bean.paging.PagingPrevNextBean;

public class Paging {

	protected static int PAGE_PER = 10;
	protected static int PAGE_LIMIT = 10;

	// private 
	public static void linkPaging(PagingBean pagingBean, int intNowPagePara, int intPerPage, int intLimitPage) throws Exception {

		int intNowPage = 1;
		int intMaxPage = 1;
		int intTotalHits = 0;
		int intStartCount = 0;
		int intEndCount = 0;

		if(intPerPage < 1) {
			intPerPage = PAGE_PER;
		}
		if(intLimitPage < 1) {
			intLimitPage = PAGE_LIMIT;
		}

		// Total count
		intTotalHits = pagingBean.getAllCount();

//		// If the total count is over, it set 1000 count.
//		if (intTotalHits > 2000) {
//			intTotalHits = 2000;
//		}

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

		// to set the link parametar in the 7 number
		for (int i=0;intLimitPage > i; i++ ) {
			PagingInfoBean pagingInfoBean = new PagingInfoBean();

			intPageNumber++;

			pagingInfoBean.setPageNumber(String.valueOf(intPageNumber));
			pagingBean.addPagingInfoList(pagingInfoBean);
		}

		// to press the button munber that is paging number.
		pagingBean.setNowPage(String.valueOf(intNowPage));
		// to set the count for represent
		intStartCount = (intNowPage-1)*intPerPage+1;
		intEndCount = (intNowPage)*intPerPage;
		pagingBean.setStartCount(String.valueOf(intStartCount));
		pagingBean.setEndCount(String.valueOf(intEndCount));

	}

	public static void linkPaging(PagingBean pagingBean, int intNowPagePara) throws Exception {

		int intPerPage = PAGE_PER;
		int intLimitPage = PAGE_LIMIT;

		linkPaging(pagingBean, intNowPagePara, intPerPage, intLimitPage);
	}

}
