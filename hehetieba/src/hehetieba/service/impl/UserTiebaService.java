package hehetieba.service.impl;

import hehetieba.dao.ITiebaDao;
import hehetieba.dao.IUserDao;
import hehetieba.dao.IUserTiebaDao;
import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.domain.UserTieba;
import hehetieba.service.IUserTiebaService;

public class UserTiebaService implements IUserTiebaService {
	IUserTiebaDao iUserTiebaDao;
	ITiebaDao iTiebaDao;
	IUserDao iUserDao;

	public IUserTiebaDao getiUserTiebaDao() {
		return iUserTiebaDao;
	}

	public void setiUserTiebaDao(IUserTiebaDao iUserTiebaDao) {
		this.iUserTiebaDao = iUserTiebaDao;
	}

	public ITiebaDao getiTiebaDao() {
		return iTiebaDao;
	}

	public void setiTiebaDao(ITiebaDao iTiebaDao) {
		this.iTiebaDao = iTiebaDao;
	}

	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	// -----------------------华丽分割线------------------------
	@Override
	public boolean checkFocused(Integer userId, Integer tiebaId) {
		// TODO Auto-generated method stub
		// 组织参数给dao层
		User user = iUserDao.load(userId);
		Tieba tieba = iTiebaDao.load(tiebaId);
		if (iUserTiebaDao.checkFocused(user, tieba) > 0)
			return true;
		return false;
	}

	@Override
	public boolean checkBaZhu(Integer userId, Integer tiebaId) {
		// TODO Auto-generated method stub
		User user = iUserDao.load(userId);
		Tieba tieba = iTiebaDao.load(tiebaId);
		if (checkFocused(userId, tiebaId) == false)
			return false;
		UserTieba userTieba = iUserTiebaDao.loadByUser_Tieba(user, tieba);
		// 判断userTiebat.type==null是为了保险起见
		if (userTieba == null || userTieba.getType() == null)
			return false;
		// 有关注贴吧，并且usertieba的type=1才是吧主
		if (userTieba.getType() == 1)
			return true;
		return false;
	}

	@Override
	public void focus(Integer userId, Integer tiebaId) {
		// TODO Auto-generated method stub
		User user = iUserDao.load(userId);
		Tieba tieba = iTiebaDao.load(tiebaId);
		Integer cnt = iUserTiebaDao.calCountByUser_Tieba(user, tieba);
		//cnt>0表示用户曾经关注过贴吧
		if(cnt>0) {
			UserTieba userTieba = iUserTiebaDao.loadByUser_Tieba(user, tieba);
			userTieba.setEnabled((byte)1);
		}
		//cnt<0,用户未关注过该贴吧,所以数据库要新增一条记录
		else {
			UserTieba userTieba = newDefaultUserTieba();
			userTieba.setUser(user);
			userTieba.setTieba(tieba);
			iUserTiebaDao.save(userTieba);
		}
	}
	
	private UserTieba newDefaultUserTieba() {
		UserTieba userTieba = new UserTieba();
		userTieba.setPoints(0);
		userTieba.setType((byte)0);
		userTieba.setEnabled((byte)1);
		return userTieba;
	}


}
