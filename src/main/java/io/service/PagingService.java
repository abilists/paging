package io.service;

import io.common.bean.CommonPara;
import io.paging.bean.PagingBean;

public interface PagingService {
	public PagingBean makePaging(CommonPara commonPara, int cnt) throws Exception;
}
