package hehetieba.service.impl;

import hehetieba.dao.IManagerDao;
import hehetieba.service.IManagerService;

public class ManagerService implements IManagerService {
	private IManagerDao iManagerDao;
	public IManagerDao getiManagerDao() {
		return iManagerDao;
	}

	public void setiManagerDao(IManagerDao iManagerDao) {
		this.iManagerDao = iManagerDao;
	}

	//-----------------华丽分割线-----------------
	@Override
	public Integer updateTiabaApplyReadToHave_All() {
		// TODO Auto-generated method stub
		return iManagerDao.updateTiabaApplyReadToHave_All();
	}

	@Override
	public Integer updateTiabaApplyReadToNon_All() {
		// TODO Auto-generated method stub
		return iManagerDao.updateTiabaApplyReadToNon_All();
	}

}
