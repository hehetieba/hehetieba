package hehetieba.dao.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.basic.Pager;
import hehetieba.dao.ITieTitleDao;
import hehetieba.domain.TieTitle;
import hehetieba.domain.Tieba;
import hehetieba.domain.User;

public class TieTitleDao extends BaseDao<TieTitle> implements ITieTitleDao {

	@Override
	public Pager<TieTitle> listJingPin(Integer index, Integer size,
			Tieba tieba) {
		// TODO Auto-generated method stub
		String hql = "from TieTitle tt left join fetch tt.user u "
				+ "where tt.tieba=:tieba and tt.jiajing=1 order by tt.lastPostTime desc";
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("tieba", tieba);
		return findByAlias(hql, index, size, alias);
	}

	@Override
	public Pager<TieTitle> getByUserId(User user,Integer index,Integer size) {
		// TODO Auto-generated method stub
		String hql = "from TieTitle tt where tt.user=:user";
		Map<String, Object> alias = new HashMap<>();
		alias.put("user", user);
		Pager<TieTitle> pager = super.findByAlias(hql, index, size, alias);
		return pager;
	}

}
