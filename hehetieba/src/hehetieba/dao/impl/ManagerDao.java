package hehetieba.dao.impl;

import hehetieba.dao.IManagerDao;
import hehetieba.domain.Manager;

public class ManagerDao extends BaseDao<Manager> implements IManagerDao {

	@Override
	public Integer updateTiabaApplyReadToHave_All() {
		// TODO Auto-generated method stub
		String hql = "update Manager m set m.tiebaApplyRead=1";
		Integer count = super.getSession().createQuery(hql).executeUpdate();
		return count;
	}

	@Override
	public Integer updateTiabaApplyReadToNon_All() {
		// TODO Auto-generated method stub
		String hql = "update Manager m set m.tiebaApplyRead=0";
		Integer count = super.getSession().createQuery(hql).executeUpdate();
		return count;
	}

	@Override
	public Integer updateTiabaOwnerApplyReadToHave_All() {
		// TODO Auto-generated method stub
		String hql = "update Manager m set m.tiebaOwnerApplyRead=1";
		Integer count = super.getSession().createQuery(hql).executeUpdate();
		return count;
	}

	@Override
	public Integer updateTiabaOwnerApplyReadToNon_All() {
		// TODO Auto-generated method stub
		String hql = "update Manager m set m.tiebaOwnerApplyRead=0";
		Integer count = super.getSession().createQuery(hql).executeUpdate();
		return count;
	}
}
