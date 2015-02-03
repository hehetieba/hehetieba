package hehetieba.dao.impl;

import hehetieba.basic.Pager;
import hehetieba.dao.IUserDao;
import hehetieba.domain.User;

public class UserDao extends BaseDao<User> implements IUserDao {

	/**
	 * 返回true表示数据库存在此用户名
	 * 返回false表示数据库不存在此用户名
	 */
	@Override
	public boolean checkUsername(String username) {
		String hql="select count(*) from User u where u.username=:username";
		Integer count = Integer.valueOf(this.getSession().createQuery(hql)
						.setString("username", username)
						.uniqueResult()
						.toString());
		if(count>0)
			return true;
		else return false;
	}
	
	/**
	 * 返回true表示数据库存在此昵称
	 * 返回false表示数据库不存在此昵称
	 */
	@Override
	public boolean checkNickname(String nickname) {
		String hql="select count(*) from User u where u.nickname=:nickname";
		int count = Integer.valueOf(this.getSession().createQuery(hql)
						.setString("nickname", nickname)
						.uniqueResult()
						.toString());
		if(count>0)
			return true;
		else return false;
	}

	@Override
	public User loadByUsername(String username) {
		String hql="from User u where u.username=?";
		User user = (User)this.queryObject(hql, username);
		if(user!=null)
			return user;
		return null;
	}

	@Override
	public Pager<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 检查用户是否激活，返回true表示已激活
	 */
	@Override
	public boolean checkUserEnabled(String username) {
		User user = (User)loadByUsername(username);
		if(user.getEnabled()==(byte)1)
			return true;
		return false;
	}

	/**
	 * 检查用户是否激活，返回true表示已激活
	 */
	@Override
	public boolean checkUserEnabled(Integer id) {
		User user = (User)load(id);
		if(user.getEnabled()==(byte)1)
			return true;
		return false;
	}

	@Override
	public void disableUser(Integer id) {
		User user = (User)load(id);
		user.setEnabled((byte) 0);
	}

	@Override
	public void enableUser(Integer id) {
		User user = (User)load(id);
		user.setEnabled((byte) 1);
	}

	@Override
	public boolean checkTieRead(Integer id) {
		User user = (User)load(id);
		if(user.getTieRead()==(byte)1)
			return true;
		return false;
	}

	@Override
	public boolean checkReplyRead(Integer id) {
		User user = (User)load(id);
		if(user.getReplyRead()==(byte)1)
			return true;
		return false;
	}

	@Override
	public boolean checkAllpyResultRead(Integer id) {
		User user = (User)load(id);
		if(user.getAllpyResultRead()==(byte)1)
			return true;
		return false;
	}

}
