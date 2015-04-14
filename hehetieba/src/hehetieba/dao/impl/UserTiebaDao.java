package hehetieba.dao.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.dao.IUserTiebaDao;
import hehetieba.domain.Tie;
import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.domain.UserTieba;

public class UserTiebaDao extends BaseDao<UserTieba> implements IUserTiebaDao{

	@Override
	public Integer checkFocused(User user, Tieba tieba) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from UserTieba ut "
				+ "where ut.user=:user and ut.tieba=:tieba and ut.enabled=1";
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("user", user);
		alias.put("tieba", tieba);
		Integer count = ((Number)super.queryObject(hql, null, alias)).intValue();
		return count;
	}

	@Override
	public UserTieba loadByUser_Tieba(User user, Tieba tieba) {
		// TODO Auto-generated method stub
		String hql = "from UserTieba ut where ut.user=:user and ut.tieba=:tieba";
		Map<String, Object> alias = new HashMap<String,Object>();
		alias.put("user", user);
		alias.put("tieba",tieba);
		return (UserTieba) super.queryObjectByAlias(hql, alias);
	}

	@Override
	public Integer calCountByUser_Tieba(User user, Tieba tieba) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from UserTieba ut "
				+ "where ut.user=:user and ut.tieba=:tieba";
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("user", user);
		alias.put("tieba", tieba);
		Integer count = ((Number)super.queryObject(hql, null, alias)).intValue();
		return count;
	}

	@Override
	public Integer updateEnableToZero(User user, Tieba tieba) {
		// TODO Auto-generated method stub
		String hql = "update UserTieba ut "
				+ "set ut.enabled=0 "
				+ "where ut.user=:user and ut.tieba=:tieba";
		Map<String, Object> alias = new HashMap<>();
		alias.put("user", user);
		alias.put("tieba", tieba);
		return super.updateByHql(hql, alias);
	}


}
