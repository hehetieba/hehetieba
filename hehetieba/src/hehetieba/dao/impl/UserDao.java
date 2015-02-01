package hehetieba.dao.impl;

import hehetieba.dao.IUserDao;
import hehetieba.domain.User;

public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public boolean checkUsername(String username) {
		String hql="select count(*) from User u where u.username=:username";
		int count = (int)this.getSession().createQuery(hql)
						.setString("username", username)
						.uniqueResult();
		if(count>0)
			return false;
		else return true;
	}

	@Override
	public boolean checkNickname(String nickname) {
		String hql="select count(*) from User u where u.nickname=:nickname";
		int count = (int)this.getSession().createQuery(hql)
						.setString("nickname", nickname)
						.uniqueResult();
		if(count>0)
			return false;
		else return true;
	}

}
