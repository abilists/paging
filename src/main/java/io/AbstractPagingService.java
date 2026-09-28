package io;

import java.nio.file.Paths;
import java.util.Locale;

import io.common.bean.CommonPara;
import io.paging.Paging;
import io.paging.bean.PagingBean;

public abstract class AbstractPagingService {

	public final Locale LOCALE = Locale.ENGLISH;

	public static String BASE_PATH = Paths.get(".").toAbsolutePath().normalize().toString();
	public static String USER_HOME = System.getProperty("user.home");

	protected static int INT_DB_NUM = 0;
	protected static int DEFAULT_USER_LIMIT = 7;
	protected static int DEFAULT_PAGING_LIMIT_TOTAL = 2000;

	public PagingBean makePaging(CommonPara commonPara, int sum) throws Exception {
		PagingBean paging = new PagingBean();
		// Set Paging list
		if(commonPara.getAllCount() <= 0) {
			paging.setAllCount(sum);
		} else {
			paging.setAllCount(commonPara.getAllCount());
		}

		int row = Paging.PAGE_LIMIT;
		// If commonPara.getPageRow() is default row over, 
		if ( row < commonPara.getRowPage()) {
			row = commonPara.getRowPage();
		} else {
			row = Paging.PAGE_LIMIT;			
		}
		paging.setRowPage(row);

		Paging.setTotalLimit(paging.getRowPage(), Paging.PAGE_LIMIT, DEFAULT_PAGING_LIMIT_TOTAL);
		Paging.linkPaging(paging, commonPara.getNowPage());

		return paging;
	}

}