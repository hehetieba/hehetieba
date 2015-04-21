package hehetieba.service.impl;

import hehetieba.dao.IManagerDao;
import hehetieba.domain.Manager;
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

	@Override
	public boolean login(String managername, String pwd) {
		// TODO Auto-generated method stub
		Manager manager = iManagerDao.get(1);
		if(manager.getManagername().equals(managername) && manager.getPwd().equals(pwd)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changePwd(String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		Manager manager = iManagerDao.get(1);
		if(manager.getPwd().equals(oldPwd)) {
			manager.setPwd(newPwd);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkTiebaApplyRead() {
		// TODO Auto-generated method stub
		Manager manager = iManagerDao.get(1);
		if(manager.getTiebaApplyRead()==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkTiebaOwnerApplyRead() {
		// TODO Auto-generated method stub
		Manager manager = iManagerDao.get(1);
		if(manager.getTiebaOwnerApplyRead()==1) {
			return true;
		}
		return false;
	}

	@Override
	public Manager getById(Integer managerId) {
		// TODO Auto-generated method stub
		return iManagerDao.get(managerId);
	}

}
