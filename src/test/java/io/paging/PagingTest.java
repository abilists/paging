package io.paging;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.paging.bean.PagingBean;
import io.paging.bean.PagingInfoBean;
import io.paging.model.PagingModel;

public class PagingTest {

	private PagingModel pagingModel = new PagingModel();
	protected static int DEFAULT_PAGING_LIMIT_TOTAL = 2000;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This is the first excuted");
	}

	@Test
	public void linkPagingTest()  throws Exception {

		// Total count.
		int intSum = 70; 
		int pageLimit = Paging.PAGE_LIMIT;
		int perPage = Paging.PER_PAGE;
		int nowPage = 1;

		PagingBean paging = new PagingBean();

		// Set Paging list
		paging.setAllCount(intSum);
		Paging.setTotalLimit(perPage, pageLimit, intSum);

		// Now page
		Paging.linkPaging(paging, nowPage);
		pagingModel.setPaging(paging);
		List<PagingInfoBean> pagingInfoBeanList = pagingModel.getPaging().getPagingInfoList();
		
		int i=0;
		for (PagingInfoBean pagingInfoBean : pagingInfoBeanList) {
			i++;
			System.out.println(pagingInfoBean.getPageNumber());
		}
		assertTrue(i == 7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("This is the last excuted");
	}

}
