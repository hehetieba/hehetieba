package hehetieba.service.impl;

import hehetieba.basic.Pager;
import hehetieba.dao.IManagerDao;
import hehetieba.dao.ITiebaApplyDao;
import hehetieba.domain.TiebaApply;
import hehetieba.service.ITiebaApplyService;

public class TiebaApplyService implements ITiebaApplyService  {
	ITiebaApplyDao iTiebaApplyDao;
	IManagerDao iManagerDao;

	public ITiebaApplyDao getiTiebaApplyDao() {
		return iTiebaApplyDao;
	}

	public void setiTiebaApplyDao(ITiebaApplyDao iTiebaApplyDao) {
		this.iTiebaApplyDao = iTiebaApplyDao;
	}

	public IManagerDao getiManagerDao() {
		return iManagerDao;
	}

	public void setiManagerDao(IManagerDao iManagerDao) {
		this.iManagerDao = iManagerDao;
	}

	//--------------------华丽分割线---------------
	@Override
	public Pager<TiebaApply> listAll(Integer index, Integer size) {
		// TODO Auto-generated method stub
		String hql = "from TiebaApply ta order by ta.applyDate desc";
		Pager<TiebaApply> pager = iTiebaApplyDao.find(hql, index, size);
		return pager;
	}

	@Override
	public Pager<TiebaApply> listHandled(Integer index, Integer size) {
		// TODO Auto-generated method stub
		String hql = "from TiebaApply ta where ta.handleStatus!=0 order by ta.applyDate desc";
		Pager<TiebaApply> pager = iTiebaApplyDao.find(hql, index, size);
		return pager;
	}

	@Override
	public Pager<TiebaApply> listUnhandled(Integer index, Integer size) {
		// TODO Auto-generated method stub
		String hql = "from TiebaApply ta where ta.handleStatus=0 order by ta.applyDate desc";
		Pager<TiebaApply> pager = iTiebaApplyDao.find(hql, index, size);
		return pager;
	}

	@Override
	public boolean saveTiebaApply(String tiebaName) {
		// TODO Auto-generated method stub
		//查找t_tiebaapply表是否已经有人申请该贴吧
		//如果已经有人申请过，就分情况处理
		String hql = "select count(*) from TiebaApply ta where ta.tiebaName=?";
		Integer count = ((Number)iTiebaApplyDao.queryObject(hql, tiebaName)).intValue();
		//1、有人申请过了
		if(count>0) {
			String hql2 = "from TiebaApply ta where ta.tiebaName=?";
			TiebaApply tiebaApply = (TiebaApply) iTiebaApplyDao.queryObject(hql2, tiebaName);
			//如果未被处理，返回true，客户界面表示表示成功申请
			if(tiebaApply.getHandleStatus()==0)
				return true;
			//如果已被处理，且该贴吧不能被申请，返回false
			if(tiebaApply.getHandleStatus()==2)
				return false;
		}
		//2、没人申请过做以下处理
		TiebaApply tiebaApply = this.newAnDefaultTiebaApply();
		tiebaApply.setTiebaName(tiebaName);
		iTiebaApplyDao.save(tiebaApply);
		//更新管理员未读消息
		iManagerDao.updateTiabaApplyReadToHave_All();
		return true;
	}
	
	private TiebaApply newAnDefaultTiebaApply() {
		TiebaApply tiebaApply = new TiebaApply();
		tiebaApply.setHandleStatus((byte)0);
		return tiebaApply;
	}

}
