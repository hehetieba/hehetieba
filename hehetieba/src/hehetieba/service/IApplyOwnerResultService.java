package hehetieba.service;

import hehetieba.basic.Pager;
import hehetieba.domain.ApplyOwnerResult;

public interface IApplyOwnerResultService {
	/**
	 * 列出用户所有吧主申请反馈
	 * @return
	 */
	public Pager<ApplyOwnerResult> listAll(Integer userId,Integer index,Integer size);
}
