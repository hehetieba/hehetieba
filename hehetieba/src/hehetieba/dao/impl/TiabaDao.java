package hehetieba.dao.impl;

import java.util.List;

import hehetieba.basic.Pager;
import hehetieba.dao.ITiebaDao;
import hehetieba.domain.Tieba;

public class TiabaDao extends BaseDao<Tieba> implements ITiebaDao  {

	@Override
	public Pager<Tieba> list(Integer index, Integer size) {
		String hql="from Tieba t order by t.membaCount";
		Pager<Tieba> pager=super.find(hql, index, size);
		return pager;
	}

	@Override
	public List listFavoriteTieba(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
