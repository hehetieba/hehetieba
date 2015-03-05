package hehetieba.service.impl;

import hehetieba.basic.Pager;
import hehetieba.dao.IManagerDao;
import hehetieba.dao.ITiebaDao;
import hehetieba.dao.ITiebaOwnerApplyDao;
import hehetieba.dao.IUserDao;
import hehetieba.dao.IUserTiebaDao;
import hehetieba.domain.Tieba;
import hehetieba.domain.TiebaOwnerApply;
import hehetieba.domain.User;
import hehetieba.service.ITiebaOwnerApplyService;

public class TiebaOwnerApplyService implements ITiebaOwnerApplyService {
	IUserDao iUserDao;
	ITiebaDao iTiebaDao;
	ITiebaOwnerApplyDao iTiebaOwnerApplyDao;
	IUserTiebaDao iUserTiebaDao;
	IManagerDao iManagerDao;

	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	public ITiebaDao getiTiebaDao() {
		return iTiebaDao;
	}

	public void setiTiebaDao(ITiebaDao iTiebaDao) {
		this.iTiebaDao = iTiebaDao;
	}

	public ITiebaOwnerApplyDao getiTiebaOwnerApplyDao() {
		return iTiebaOwnerApplyDao;
	}

	public void setiTiebaOwnerApplyDao(ITiebaOwnerApplyDao iTiebaOwnerApplyDao) {
		this.iTiebaOwnerApplyDao = iTiebaOwnerApplyDao;
	}

	public IUserTiebaDao getiUserTiebaDao() {
		return iUserTiebaDao;
	}

	public void setiUserTiebaDao(IUserTiebaDao iUserTiebaDao) {
		this.iUserTiebaDao = iUserTiebaDao;
	}

	public IManagerDao getiManagerDao() {
		return iManagerDao;
	}

	public void setiManagerDao(IManagerDao iManagerDao) {
		this.iManagerDao = iManagerDao;
	}

	//--------------------华丽分割线---------------------
	@Override
	public Integer applyTiebaOwner(Integer userId, Integer tiebaId,
			String username, String tiebaName) {
		// TODO Auto-generated method stub
		//1、申请吧主之前要先关注
		User user = iUserDao.load(userId);
		Tieba tieba = iTiebaDao.load(tiebaId);
		if(iUserTiebaDao.checkFocused(user, tieba)==0)
			return 0;
		//2、检查有木有申请过
		Integer count = iTiebaOwnerApplyDao.checkIsApply(userId, tiebaId);
		if(count!=0)
			return 1;
		//3、提交吧主申请
		TiebaOwnerApply tiebaOwnerApply = this.newAnDefaulTiebaOwnerApply();
		tiebaOwnerApply.setTiebaId(tiebaId);
		tiebaOwnerApply.setTiebaName(tieba.getTiebaName());
		tiebaOwnerApply.setUserId(userId);
		tiebaOwnerApply.setUsername(user.getUsername());
		iTiebaOwnerApplyDao.save(tiebaOwnerApply);
		//4、更新管理员未读消息
		iManagerDao.updateTiabaOwnerApplyReadToHave_All();
		return 2;
	}
	
	private TiebaOwnerApply newAnDefaulTiebaOwnerApply() {
		TiebaOwnerApply tiebaOwnerApply = new TiebaOwnerApply();
		tiebaOwnerApply.setHandleStatus((byte)0);
		return tiebaOwnerApply;
	}

	@Override
	public Pager<TiebaOwnerApply> listAll(Integer index, Integer size) {
		// TODO Auto-generated method stub
		return iTiebaOwnerApplyDao.listAll(index, size);
	}

	@Override
	public Pager<TiebaOwnerApply> listHandled(Integer index, Integer size) {
		// TODO Auto-generated method stub
		return iTiebaOwnerApplyDao.listHandled(index, size);
	}

	@Override
	public Pager<TiebaOwnerApply> listUnhandled(Integer index, Integer size) {
		// TODO Auto-generated method stub
		return iTiebaOwnerApplyDao.listUnhandled(index, size);
	}

}















