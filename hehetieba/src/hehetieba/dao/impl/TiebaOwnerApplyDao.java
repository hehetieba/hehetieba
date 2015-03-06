package hehetieba.dao.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.basic.Pager;
import hehetieba.dao.ITiebaOwnerApplyDao;
import hehetieba.domain.TiebaApply;
import hehetieba.domain.TiebaOwnerApply;

public class TiebaOwnerApplyDao extends BaseDao<TiebaOwnerApply> implements ITiebaOwnerApplyDao {

	@Override
	public Integer checkIsApply(Integer userId, Integer tiebaId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TiebaOwnerApply toa "
				+ "where toa.userId=:userId and toa.tiebaId=:tiebaId and toa.handleStatus=0";
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("userId", userId);
		alias.put("tiebaId", tiebaId);
		Integer count = ((Number)super.queryObject(hql, null, alias)).intValue();
		return count;
	}

	@Override
	public Pager<TiebaOwnerApply> listAll(Integer index, Integer size) {
		// TODO Auto-generated method stub
		String hql = "from TiebaOwnerApply toa order by toa.applyDate desc";
		Pager<TiebaOwnerApply> pager = super.find(hql, index, size);
		return pager;
	}

	@Override
	public Pager<TiebaOwnerApply> listHandled(Integer index, Integer size) {
		// TODO Auto-generated method stub
		String hql = "from TiebaOwnerApply toa where toa.handleStatus!=0 order by toa.applyDate desc";
		Pager<TiebaOwnerApply> pager = super.find(hql, index, size);
		return pager;
	}

	@Override
	public Pager<TiebaOwnerApply> listUnhandled(Integer index, Integer size) {
		// TODO Auto-generated method stub
		String hql = "from TiebaOwnerApply toa where toa.handleStatus=0 order by toa.applyDate desc";
		Pager<TiebaOwnerApply> pager = super.find(hql, index, size);
		return pager;
	}

}
