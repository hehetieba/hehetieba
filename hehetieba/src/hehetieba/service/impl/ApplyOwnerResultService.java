package hehetieba.service.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.basic.Pager;
import hehetieba.dao.IApplyOwnerResultDao;
import hehetieba.domain.ApplyOwnerResult;
import hehetieba.service.IApplyOwnerResultService;

public class ApplyOwnerResultService implements IApplyOwnerResultService{
	IApplyOwnerResultDao iApplyOwnerResultDao;

	public IApplyOwnerResultDao getiApplyOwnerResultDao() {
		return iApplyOwnerResultDao;
	}


	public void setiApplyOwnerResultDao(IApplyOwnerResultDao iApplyOwnerResultDao) {
		this.iApplyOwnerResultDao = iApplyOwnerResultDao;
	}

	//-----------------华丽分割线-------------------

	@Override
	public Pager<ApplyOwnerResult> listAll(Integer userId, Integer index,
			Integer size) {
		// TODO Auto-generated method stub
		String hql = "from ApplyOwnerResult aor where aor.userId=:userId";
		Map<String,Object> alias = new HashMap<>();
		alias.put("userId", userId);
		Pager<ApplyOwnerResult> pager = iApplyOwnerResultDao.findByAlias(hql, index, size, alias);
		return pager;
	}

}
